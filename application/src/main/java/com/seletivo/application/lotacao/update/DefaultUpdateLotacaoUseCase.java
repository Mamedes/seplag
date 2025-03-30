package com.seletivo.application.lotacao.update;

import com.seletivo.domain.lotacao.Lotacao;
import com.seletivo.domain.lotacao.LotacaoGateway;
import com.seletivo.domain.lotacao.LotacaoID;
import com.seletivo.domain.validation.handler.Notification;
import io.vavr.control.Either;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;
import java.util.Optional;

import static io.vavr.API.Left;
import static io.vavr.API.Try;

public class DefaultUpdateLotacaoUseCase extends UpdateLotacaoUseCase {

    private final LotacaoGateway lotacaoGateway;

    public DefaultUpdateLotacaoUseCase(final LotacaoGateway lotacaoGateway) {
        this.lotacaoGateway = Objects.requireNonNull(lotacaoGateway);
    }

    @Override
    @Transactional
    public Either<Notification, UpdateLotacaoOutput> execute(final UpdateLotacaoCommand aCommand) {
        final var lotacaoId = aCommand.id();
        final var pessoaId = aCommand.pessoaId();
        final var unidadeId = aCommand.unidadeId();
        final var dataLotacao = aCommand.dataLotacao();
        final var dataRemocao = aCommand.dataRemocao();
        final var portaria = aCommand.portaria();
        final var notification = Notification.create();

        Optional<Lotacao> lotacaoOptional = lotacaoGateway.findById(LotacaoID.from(lotacaoId));

        if (lotacaoOptional.isEmpty()) {
            notification.append(new com.seletivo.domain.validation.Error("Lotação não encontrada"));
            return Left(notification);
        }

        Lotacao lotacao = lotacaoOptional.get();
        lotacao = Lotacao.with(lotacao.getId(), pessoaId, unidadeId, dataLotacao, dataRemocao, portaria);
        lotacao.validate(notification);

        return notification.hasError() ? Left(notification) : update(lotacao);
    }

    private Either<Notification, UpdateLotacaoOutput> update(final Lotacao aLotacao) {
        return Try(() -> this.lotacaoGateway.update(aLotacao))
                .toEither()
                .bimap(Notification::create, UpdateLotacaoOutput::from);
    }
}