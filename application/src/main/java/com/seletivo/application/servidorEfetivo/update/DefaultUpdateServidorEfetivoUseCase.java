package com.seletivo.application.servidorEfetivo.update;

import com.seletivo.domain.pessoa.Pessoa;
import com.seletivo.domain.pessoa.PessoaGateway;
import com.seletivo.domain.pessoa.PessoaID;
import com.seletivo.domain.servidorEfetivo.ServidorEfetivo;
import com.seletivo.domain.servidorEfetivo.ServidorEfetivoGateway;
import com.seletivo.domain.validation.handler.Notification;
import io.vavr.control.Either;

import java.util.Objects;

import static io.vavr.API.Left;
import static io.vavr.API.Try;

public class DefaultUpdateServidorEfetivoUseCase extends UpdateServidorEfetivoUseCase {

    private final ServidorEfetivoGateway servidorEfetivoGateway;
    private final PessoaGateway pessoaGateway;

    public DefaultUpdateServidorEfetivoUseCase(final ServidorEfetivoGateway servidorEfetivoGateway,
                                               final PessoaGateway pessoaGateway) {
        this.servidorEfetivoGateway = Objects.requireNonNull(servidorEfetivoGateway);
        this.pessoaGateway = Objects.requireNonNull(pessoaGateway);
    }

    @Override
    public Either<Notification, UpdateServidorEfetivoOutput> execute(final UpdateServidorEfetivoCommand aCommand) {
        final var matricula = aCommand.matricula();
        final var pessoaCommand = aCommand.pessoaCommand();
        final var servidorId = aCommand.id();
        final var notification = Notification.create();

        final var pessoa = Pessoa.with(
                PessoaID.from(pessoaCommand.id()),
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

        final var savedPessoa = pessoaGateway.update(pessoa);

        final var servidorEfetivo = ServidorEfetivo.newServidorEfetivo(savedPessoa.getId(), matricula);
        servidorEfetivo.validate(notification);

        return notification.hasError() ? Left(notification) : update(servidorEfetivo, servidorId);
    }

    private Either<Notification, UpdateServidorEfetivoOutput> update(final ServidorEfetivo aServidorEfetivo, Long id) {
        return Try(() -> this.servidorEfetivoGateway.update(aServidorEfetivo))
                .toEither()
                .bimap(Notification::create, UpdateServidorEfetivoOutput::from);
    }
}