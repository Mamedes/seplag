package com.seletivo.infra.api.controller.unidade;

import java.net.URI;
import java.util.Objects;
import java.util.function.Function;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import com.seletivo.application.unidade.create.CreateUnidadeCommand;
import com.seletivo.application.unidade.create.CreateUnidadeOutput;
import com.seletivo.application.unidade.create.CreateUnidadeUseCase;
import com.seletivo.application.unidade.fetch.GetUnidadeByIdUseCase;
import com.seletivo.application.unidade.unidadeEndereco.CreateUnidadeEnderecoCommand;
import com.seletivo.application.unidade.unidadeEndereco.CreateUnidadeEnderecoUseCase;
import com.seletivo.application.unidade.update.UpdateUnidadeCommand;
import com.seletivo.application.unidade.update.UpdateUnidadeOutput;
import com.seletivo.application.unidade.update.UpdateUnidadeUseCase;
import com.seletivo.domain.endereco.EnderecoID;
import com.seletivo.domain.unidade.UnidadeID;
import com.seletivo.domain.validation.handler.Notification;
import com.seletivo.infra.api.controller.unidade.Presenter.UnidadeApiPresenter;
import com.seletivo.infra.api.controller.unidade.request.CreateUnidadeRequest;
import com.seletivo.infra.api.controller.unidade.request.UnidadeResponse;
import com.seletivo.infra.api.controller.unidade.request.UpdateUnidadeRequest;

@RestController
public class UnidadeController implements UnidadeAPI {

    private final CreateUnidadeUseCase createUnidadeUseCase;
    private final GetUnidadeByIdUseCase getUnidadeByIdUseCase;
    private final CreateUnidadeEnderecoUseCase createUnidadeEnderecoUseCase;
    private final UpdateUnidadeUseCase updateUnidadeUseCase;


    public UnidadeController(final CreateUnidadeUseCase createUnidadeUseCase,
            final GetUnidadeByIdUseCase getUnidadeByIdUseCase,
            final CreateUnidadeEnderecoUseCase createUnidadeEnderecoUseCase,
            final UpdateUnidadeUseCase updateUnidadeUseCase) {
        this.createUnidadeEnderecoUseCase = Objects.requireNonNull(createUnidadeEnderecoUseCase);
        this.createUnidadeUseCase = Objects.requireNonNull(createUnidadeUseCase);
        this.getUnidadeByIdUseCase = Objects.requireNonNull(getUnidadeByIdUseCase);
        this.updateUnidadeUseCase = Objects.requireNonNull(updateUnidadeUseCase);

    }

    public ResponseEntity<?> createUnidade(final CreateUnidadeRequest input) {
        final var aCommand =
                CreateUnidadeCommand.with(input.nome(), input.sigla(), input.enderecoIds());

        final Function<Notification, ResponseEntity<?>> onError =
                notification -> ResponseEntity.unprocessableEntity().body(notification);

        final Function<CreateUnidadeOutput, ResponseEntity<?>> onSuccess = output -> {
            UnidadeID unidadeId = UnidadeID.from(output.id());

            // Criar os relacionamentos com os endereços
            // if (input.enderecoId() != null && !input.enderecoId().isEmpty()) {
            input.enderecoIds().forEach(enderecoId -> {
                var createUnidadeEnderecoCommand =
                        CreateUnidadeEnderecoCommand.with(unidadeId, EnderecoID.from(enderecoId));
                createUnidadeEnderecoUseCase.execute(createUnidadeEnderecoCommand);
            });
            // }

            return ResponseEntity.created(URI.create("/unidade/" + output.id())).body(output);
        };

        return this.createUnidadeUseCase.execute(aCommand).fold(onError, onSuccess);
    }

    @Override
    public UnidadeResponse getById(final Long id) {
        return UnidadeApiPresenter.present(this.getUnidadeByIdUseCase.execute(id));
    }

    @Override
    public ResponseEntity<?> updateById(Long id, UpdateUnidadeRequest input) {
        final var aCommand =
                UpdateUnidadeCommand.with(id, input.nome(), input.sigla(), input.enderecoIds());

        final Function<Notification, ResponseEntity<?>> onError =
                notification -> ResponseEntity.unprocessableEntity().body(notification);

        final Function<UpdateUnidadeOutput, ResponseEntity<?>> onSuccess = ResponseEntity::ok;

        return this.updateUnidadeUseCase.execute(aCommand).fold(onError, onSuccess);
    }

}
