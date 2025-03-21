package com.seletivo.application.lotacao.create;

import com.seletivo.domain.lotacao.LotacaoGateway;
import com.seletivo.domain.validation.handler.Notification;
import io.vavr.control.Either;
import com.seletivo.domain.lotacao.Lotacao;
import java.util.Objects;

import static io.vavr.API.Left;
import static io.vavr.API.Try;

public class DefaultCreateLotacaoUseCase extends CreateLotacaoUseCase {

    private final LotacaoGateway lotacaoGateway;

    public DefaultCreateLotacaoUseCase(final LotacaoGateway lotacaoGateway) {
        this.lotacaoGateway = Objects.requireNonNull(lotacaoGateway);
    }


    @Override
    public Either<Notification, CreateLotacaoOutput> execute(final CreateLotacaoCommand aCommand) {
        final var pessoaID = aCommand.pessoaId();
        final var unidadeID = aCommand.unidadeId();
        final var dataLotacao = aCommand.dataLotacao();
        final var dataRemocao = aCommand.dataRemocao();
        final var portaria = aCommand.portaria();

        final var notification = Notification.create();

        final var aLotacao = Lotacao.newLotacao(pessoaID, unidadeID,dataLotacao,dataRemocao,portaria);
        aLotacao.validate(notification);

        return notification.hasError() ? Left(notification) : create(aLotacao);
    }

    private Either<Notification, CreateLotacaoOutput> create(final Lotacao aLotacao) {
        return Try(() -> this.lotacaoGateway.create(aLotacao))
                .toEither()
                .bimap(Notification::create, CreateLotacaoOutput::from);
    }
}


