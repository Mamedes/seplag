package com.seletivo.infra.api.controller.servidorEfetivo;

import com.seletivo.application.pessoa.create.CreatePessoaCommand;
import com.seletivo.application.servidorEfetivo.create.CreateServidorEfetivoCommand;
import com.seletivo.application.servidorEfetivo.create.CreateServidorEfetivoOutput;
import com.seletivo.application.servidorEfetivo.create.CreateServidorEfetivoUseCase;
import com.seletivo.application.servidorEfetivo.fetch.GetServidorEfetivoByIdUseCase;
import com.seletivo.domain.validation.handler.Notification;
import com.seletivo.infra.api.controller.servidorEfetivo.presenters.ServidorApiPresenter;
import com.seletivo.infra.api.controller.servidorEfetivo.request.CreateServidorEfetivoRequest;
import com.seletivo.infra.api.controller.servidorEfetivo.response.ServidorEfetivoResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.util.Objects;
import java.util.function.Function;

@RestController
public class ServidorEfetivoController implements ServidorEfetivoAPI {

    private final CreateServidorEfetivoUseCase createServidorEfetivoUseCase;
    private final GetServidorEfetivoByIdUseCase getServidorEfetivoByIdUseCase;

    public ServidorEfetivoController(final CreateServidorEfetivoUseCase createServidorEfetivoUseCase, final GetServidorEfetivoByIdUseCase getServidorEfetivoByIdUseCase) {

        this.createServidorEfetivoUseCase = Objects.requireNonNull(createServidorEfetivoUseCase);
        this.getServidorEfetivoByIdUseCase = Objects.requireNonNull(getServidorEfetivoByIdUseCase);

    }

    public ResponseEntity<?> createServidorEfetivo(final CreateServidorEfetivoRequest request) {
        final var pessoaCommand = CreatePessoaCommand.with(
                request.pessoa().nome(),
                request.pessoa().dataNascimento(),
                request.pessoa().sexo(),
                request.pessoa().nomeMae(),
                request.pessoa().nomePai()
        );

        final var command = CreateServidorEfetivoCommand.with(request.matricula(), pessoaCommand);

        final Function<Notification, ResponseEntity<?>> onError =
                notification -> ResponseEntity.unprocessableEntity().body(notification);

        final Function<CreateServidorEfetivoOutput, ResponseEntity<?>> onSuccess =
                output -> ResponseEntity.created(URI.create("/servidor-efetivo/" + output.id())).body(output);

        return this.createServidorEfetivoUseCase.execute(command).fold(onError, onSuccess);
    }

    @Override
    public ServidorEfetivoResponse getById(final Long id) {
        return ServidorApiPresenter.present(this.getServidorEfetivoByIdUseCase.execute(id));
    }
}
