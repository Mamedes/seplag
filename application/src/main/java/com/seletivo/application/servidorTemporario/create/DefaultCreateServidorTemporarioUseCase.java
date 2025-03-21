package com.seletivo.application.servidorTemporario.create;

import com.seletivo.domain.pessoa.Pessoa;
import com.seletivo.domain.pessoa.PessoaGateway;
import com.seletivo.domain.servidorTemporario.ServidorTemporario;
import com.seletivo.domain.servidorTemporario.ServidorTemporarioGateway;
import com.seletivo.domain.validation.handler.Notification;
import io.vavr.control.Either;

import java.util.Objects;

import static io.vavr.API.Left;
import static io.vavr.API.Try;

public class DefaultCreateServidorTemporarioUseCase extends CreateServidorTemporarioUseCase {

    private final ServidorTemporarioGateway servidorTemporarioGateway;
    private final PessoaGateway pessoaGateway;

    public DefaultCreateServidorTemporarioUseCase(final ServidorTemporarioGateway servidorTemporarioGateway,
                                                  final PessoaGateway pessoaGateway) {
        this.servidorTemporarioGateway = Objects.requireNonNull(servidorTemporarioGateway);
        this.pessoaGateway = Objects.requireNonNull(pessoaGateway);
    }


    @Override
    public Either<Notification, CreateServidorTemporarioOutput> execute(final CreateServidorTemporarioCommand aCommand) {
        final var dataAdmissao = aCommand.dataAdmissao();
        final var dataDemissao = aCommand.dataDemissao();
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

        // Criar o Servidor Temporario com a Pessoa criada
        final var servidorTemporario = ServidorTemporario.newServidorTemporario(savedPessoa.getId(), dataAdmissao,dataDemissao);
        servidorTemporario.validate(notification);

        return notification.hasError() ? Left(notification) : create(servidorTemporario);
    }

    private Either<Notification, CreateServidorTemporarioOutput> create(final ServidorTemporario aServidorTemporario) {
        return Try(() -> this.servidorTemporarioGateway.create(aServidorTemporario))
                .toEither()
                .bimap(Notification::create, CreateServidorTemporarioOutput::from);
    }
}


