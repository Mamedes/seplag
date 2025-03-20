package com.seletivo.application.pessoa.create;



import com.seletivo.domain.pessoa.Pessoa;
import com.seletivo.domain.pessoa.PessoaGateway;
import com.seletivo.domain.validation.handler.Notification;
import io.vavr.control.Either;

import java.util.Objects;

import static io.vavr.API.Left;
import static io.vavr.API.Try;

public class DefaultCreatePessoaUseCase extends CreatePessoaUseCase {

    private final PessoaGateway pessoaGateway;

    public DefaultCreatePessoaUseCase(final PessoaGateway pessoaGateway) {
        this.pessoaGateway = Objects.requireNonNull(pessoaGateway);
    }

    @Override
    public Either<Notification, CreatePessoaOutput> execute(final CreatePessoaCommand aCommand) {
        final var nome = aCommand.nome();
        final var dataNascimento = aCommand.dataNascimento();
        final var  sexo = aCommand.sexo();
        final var nomeMae= aCommand.nomeMae();
        final var nomePai = aCommand.nomePai();

        final var notification = Notification.create();

        final var aPessoa = Pessoa.newPessoa(nome, dataNascimento, sexo,nomeMae,nomePai);
        aPessoa.validate(notification);

        return notification.hasError() ? Left(notification) : create(aPessoa);
    }

    private Either<Notification, CreatePessoaOutput> create(final Pessoa aPessoa) {
        return Try(() -> this.pessoaGateway.create(aPessoa))
                .toEither()
                .bimap(Notification::create, CreatePessoaOutput::from);
    }
}
