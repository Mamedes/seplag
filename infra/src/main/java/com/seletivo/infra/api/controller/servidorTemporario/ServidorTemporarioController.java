package com.seletivo.infra.api.controller.servidorTemporario;

import com.seletivo.application.pessoa.create.CreatePessoaCommand;
import com.seletivo.application.servidorTemporario.create.CreateServidorTemporarioCommand;
import com.seletivo.application.servidorTemporario.create.CreateServidorTemporarioOutput;
import com.seletivo.application.servidorTemporario.create.CreateServidorTemporarioUseCase;
import com.seletivo.application.servidorTemporario.fetch.GetServidorTemporarioByIdUseCase;
import com.seletivo.domain.validation.handler.Notification;
import com.seletivo.infra.api.controller.servidorTemporario.presenters.ServidorTemporarioApiPresenter;
import com.seletivo.infra.api.controller.servidorTemporario.request.CreateServidorTemporarioRequest;
import com.seletivo.infra.api.controller.servidorTemporario.response.ServidorTemporarioResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.util.Objects;
import java.util.function.Function;

@RestController
public class ServidorTemporarioController implements ServidorTemporarioAPI {

    private final CreateServidorTemporarioUseCase createServidorTemporarioUseCase;
    private final GetServidorTemporarioByIdUseCase getServidorTemporarioByIdUseCase;

    public ServidorTemporarioController(final CreateServidorTemporarioUseCase createServidorTemporarioUseCase, final GetServidorTemporarioByIdUseCase getServidorTemporarioByIdUseCase) {

        this.createServidorTemporarioUseCase = Objects.requireNonNull(createServidorTemporarioUseCase);
        this.getServidorTemporarioByIdUseCase = Objects.requireNonNull(getServidorTemporarioByIdUseCase);

    }

    public ResponseEntity<?> createServidorTemporario(final CreateServidorTemporarioRequest request) {
        final var pessoaCommand = CreatePessoaCommand.with(
                request.pessoa().nome(),
                request.pessoa().dataNascimento(),
                request.pessoa().sexo(),
                request.pessoa().nomeMae(),
                request.pessoa().nomePai()
        );

        final var command = CreateServidorTemporarioCommand.with(request.dataAdmissao(), request.dataDemissao(), pessoaCommand);

        final Function<Notification, ResponseEntity<?>> onError =
                notification -> ResponseEntity.unprocessableEntity().body(notification);

        final Function<CreateServidorTemporarioOutput, ResponseEntity<?>> onSuccess =
                output -> ResponseEntity.created(URI.create("/servidor-temporario/" + output.id())).body(output);

        return this.createServidorTemporarioUseCase.execute(command).fold(onError, onSuccess);
    }

    @Override
    public ServidorTemporarioResponse getById(final Long id) {
        return ServidorTemporarioApiPresenter.present(this.getServidorTemporarioByIdUseCase.execute(id));
    }
}
