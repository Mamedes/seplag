package com.seletivo.infra.controller.endereco;

import com.seletivo.application.endereco.create.CreateEnderecoCommand;
import com.seletivo.application.endereco.create.CreateEnderecoOutput;
import com.seletivo.application.endereco.create.CreateEnderecoUseCase;
import com.seletivo.application.endereco.delete.DeleteEnderecoUseCase;
import com.seletivo.application.endereco.fetch.GetEnderecoByIdUseCase;
import com.seletivo.application.endereco.update.UpdateEnderecoCommand;
import com.seletivo.application.endereco.update.UpdateEnderecoOutput;
import com.seletivo.application.endereco.update.UpdateEnderecoUseCase;
import com.seletivo.domain.validation.handler.Notification;
import com.seletivo.infra.controller.endereco.presenters.EnderecoApiPresenter;
import com.seletivo.infra.controller.endereco.request.CreateEnderecoRequest;
import com.seletivo.infra.controller.endereco.request.EnderecoResponse;
import com.seletivo.infra.controller.endereco.request.UpdateEnderecoRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.util.Objects;
import java.util.function.Function;

@RestController
public class EnderecoController implements EnderecoAPI {

    private final CreateEnderecoUseCase createEnderecoUseCase;
    private final GetEnderecoByIdUseCase getEnderecoByIdUseCase;
    private final UpdateEnderecoUseCase updateEnderecoUseCase;
    private final DeleteEnderecoUseCase deleteEnderecoUseCase;

    public EnderecoController(
            final CreateEnderecoUseCase createEnderecoUseCase,
            final GetEnderecoByIdUseCase getEnderecoByIdUseCase,
            final UpdateEnderecoUseCase updateEnderecoUseCase,
            final DeleteEnderecoUseCase deleteEnderecoUseCase
    ) {
        this.deleteEnderecoUseCase= Objects.requireNonNull(deleteEnderecoUseCase);
        this.createEnderecoUseCase = Objects.requireNonNull(createEnderecoUseCase);
        this.getEnderecoByIdUseCase = Objects.requireNonNull(getEnderecoByIdUseCase);
        this.updateEnderecoUseCase = Objects.requireNonNull(updateEnderecoUseCase);


    }

    public ResponseEntity<?> createEndereco(final CreateEnderecoRequest input) {
        final var aCommand = CreateEnderecoCommand.with(input.tipoLogradouro(), input.logradouro(), input.numero(), input.bairro(), input.cidadeId());

        final Function<Notification, ResponseEntity<?>> onError = notification -> ResponseEntity.unprocessableEntity().body(notification);

        final Function<CreateEnderecoOutput, ResponseEntity<?>> onSuccess = output -> ResponseEntity.created(URI.create("/endereco" + output.id())).body(output);

        return this.createEnderecoUseCase.execute(aCommand).fold(onError, onSuccess);
    }

    @Override
    public EnderecoResponse getById(final Long id) {
        return EnderecoApiPresenter.present(this.getEnderecoByIdUseCase.execute(id));
    }

    @Override
    public ResponseEntity<?> updateById(Long id, UpdateEnderecoRequest input) {
        final var aCommand = UpdateEnderecoCommand.with(
                id,
                input.tipoLogradouro(),
                input.logradouro(),
                input.numero(),
                input.bairro(),
                input.cidadeId()
        );

        final Function<Notification, ResponseEntity<?>> onError = notification ->
                ResponseEntity.unprocessableEntity().body(notification);

        final Function<UpdateEnderecoOutput, ResponseEntity<?>> onSuccess =
                ResponseEntity::ok;

        return this.updateEnderecoUseCase.execute(aCommand)
                .fold(onError, onSuccess);
    }

    @Override
    public void deleteById(Long anId) {
        this.deleteEnderecoUseCase.execute(anId);
    }
}
