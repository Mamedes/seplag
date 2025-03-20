package com.seletivo.infra.controller.pessoa;

import com.seletivo.application.pessoa.create.CreatePessoaCommand;
import com.seletivo.application.pessoa.create.CreatePessoaOutput;
import com.seletivo.application.pessoa.create.CreatePessoaUseCase;
import com.seletivo.application.pessoa.fetch.get.GetPessoaByIdUseCase;
import com.seletivo.domain.validation.handler.Notification;
import com.seletivo.infra.controller.pessoa.presenters.PessoaApiPresenter;
import com.seletivo.infra.controller.pessoa.request.CreatePessoaRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.util.Objects;
import java.util.function.Function;

@RestController
public class PessoaController implements PessoaAPI {

    private final CreatePessoaUseCase createPessoaUseCase;
    private final GetPessoaByIdUseCase getPessoaByIdUseCase;

    public PessoaController(final CreatePessoaUseCase createPessoaUseCase, final GetPessoaByIdUseCase getPessoaByIdUseCase) {

        this.createPessoaUseCase = Objects.requireNonNull(createPessoaUseCase);
        this.getPessoaByIdUseCase = Objects.requireNonNull(getPessoaByIdUseCase);

    }

    public ResponseEntity<?> createPessoa(final CreatePessoaRequest input) {
        final var aCommand = CreatePessoaCommand.with(input.nome(), input.dataNascimento(), input.sexo(), input.nomeMae(), input.nomePai());

        final Function<Notification, ResponseEntity<?>> onError = notification -> ResponseEntity.unprocessableEntity().body(notification);

        final Function<CreatePessoaOutput, ResponseEntity<?>> onSuccess = output -> ResponseEntity.created(URI.create("/pessoa/" + output.id())).body(output);

        return this.createPessoaUseCase.execute(aCommand).fold(onError, onSuccess);
    }

    @Override
    public PessoaResponse getById(final Long id) {
        return PessoaApiPresenter.present(this.getPessoaByIdUseCase.execute(id));
    }
}
