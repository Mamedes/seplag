package com.seletivo.application.servidorTemporario.update;

import com.seletivo.application.servidorTemporario.UpdateServidorTemporarioOutput;
import com.seletivo.domain.pessoa.Pessoa;
import com.seletivo.domain.pessoa.PessoaGateway;
import com.seletivo.domain.pessoa.PessoaID;
import com.seletivo.domain.servidorTemporario.ServidorTemporario;
import com.seletivo.domain.servidorTemporario.ServidorTemporarioGateway;
import com.seletivo.domain.validation.handler.Notification;
import io.vavr.control.Either;

import java.util.Objects;
import java.util.Optional;

import static io.vavr.API.Left;
import static io.vavr.API.Try;

import org.springframework.transaction.annotation.Transactional;

public class DefaultUpdateServidorTemporarioUseCase extends UpdateServidorTemporarioUseCase {

    private final ServidorTemporarioGateway servidorTemporarioGateway;
    private final PessoaGateway pessoaGateway;

    public DefaultUpdateServidorTemporarioUseCase(final ServidorTemporarioGateway servidorTemporarioGateway,
                                                  final PessoaGateway pessoaGateway) {
        this.servidorTemporarioGateway = Objects.requireNonNull(servidorTemporarioGateway);
        this.pessoaGateway = Objects.requireNonNull(pessoaGateway);
    }

    @Override
    @Transactional
    public Either<Notification, UpdateServidorTemporarioOutput> execute(final UpdateServidorTemporarioCommand aCommand) {
        final var dataAdmissao = aCommand.dataAdmissao();
        final var dataDemissao = aCommand.dataDemissao();
        final var pessoaCommand = aCommand.pessoaCommand();
        final var servidorId = aCommand.id();
        final var notification = Notification.create();

        final var pessoa = Pessoa.with(
                PessoaID.from(servidorId),
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

        pessoaGateway.update(pessoa);

        Optional<ServidorTemporario> servidorTemporarioOptional = servidorTemporarioGateway.findById(PessoaID.from(servidorId));

       if(servidorTemporarioOptional.isEmpty()) {
            return Left(Notification.create().append(new com.seletivo.domain.validation.Error("Servidor Temporário não encontrado")));
        }


        ServidorTemporario servidorTemporario = servidorTemporarioOptional.get();
        servidorTemporario = ServidorTemporario.with(servidorTemporario.getId(), dataAdmissao, dataDemissao);
        servidorTemporario.validate(notification);

        return notification.hasError() ? Left(notification) : update(servidorTemporario);
    }

    private Either<Notification, UpdateServidorTemporarioOutput> update(final ServidorTemporario aServidorTemporario) {
        return Try(() -> this.servidorTemporarioGateway.update(aServidorTemporario))
                .toEither()
                .bimap(Notification::create, UpdateServidorTemporarioOutput::from);
    }
}