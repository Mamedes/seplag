package com.seletivo.application.servidorEfetivo.create;

import com.seletivo.domain.pessoa.Pessoa;
import com.seletivo.domain.pessoa.PessoaGateway;
import com.seletivo.domain.servidorEfetivo.ServidorEfetivo;
import com.seletivo.domain.servidorEfetivo.ServidorEfetivoGateway;
import com.seletivo.domain.validation.handler.Notification;
import io.vavr.control.Either;

import java.util.Objects;

import static io.vavr.API.Left;
import static io.vavr.API.Try;

public class DefaultCreateServidorEfetivoUseCase extends CreateServidorEfetivoUseCase {

    private final ServidorEfetivoGateway servidorEfetivoGateway;
    private final PessoaGateway pessoaGateway;

    public DefaultCreateServidorEfetivoUseCase(final ServidorEfetivoGateway servidorEfetivoGateway,
                                               final PessoaGateway pessoaGateway) {
        this.servidorEfetivoGateway = Objects.requireNonNull(servidorEfetivoGateway);
        this.pessoaGateway = Objects.requireNonNull(pessoaGateway);
    }

    @Override
    public Either<Notification, CreateServidorEfetivoOutput> execute(final CreateServidorEfetivoCommand aCommand) {
        final var matricula = aCommand.matricula();
        final var pessoaCommand = aCommand.pessoaCommand();

        final var notification = Notification.create();

        // Criar a Pessoa primeiro
        final var pessoa = Pessoa.newPessoa(
                pessoaCommand.nome(),
                pessoaCommand.dataNascimento(),
                pessoaCommand.sexo(),
                pessoaCommand.nomeMae(),
                pessoaCommand.nomePai()
        );
        pessoa.validate(notification);

        if (notification.hasError()) {
            return Left(notification);
        }

        final var savedPessoa = pessoaGateway.create(pessoa);

        // Criar o Servidor Efetivo com a Pessoa criada
        final var servidorEfetivo = ServidorEfetivo.newServidorEfetivo(savedPessoa.getId(), matricula);
        servidorEfetivo.validate(notification);

        return notification.hasError() ? Left(notification) : create(servidorEfetivo);
    }

    private Either<Notification, CreateServidorEfetivoOutput> create(final ServidorEfetivo aServidorEfetivo) {
        return Try(() -> this.servidorEfetivoGateway.create(aServidorEfetivo))
                .toEither()
                .bimap(Notification::create, CreateServidorEfetivoOutput::from);
    }
}


