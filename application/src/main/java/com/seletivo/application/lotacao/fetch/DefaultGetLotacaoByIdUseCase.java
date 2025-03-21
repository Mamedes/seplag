package com.seletivo.application.lotacao.fetch;

import com.seletivo.domain.exceptions.NotFoundException;
import com.seletivo.domain.lotacao.Lotacao;
import com.seletivo.domain.lotacao.LotacaoGateway;
import com.seletivo.domain.lotacao.LotacaoID;


import java.util.Objects;
import java.util.function.Supplier;

public class DefaultGetLotacaoByIdUseCase extends GetLotacaoByIdUseCase {

    private final LotacaoGateway lotacaoGateway;

    public DefaultGetLotacaoByIdUseCase(final LotacaoGateway lotacaoGateway ) {
        this.lotacaoGateway = Objects.requireNonNull(lotacaoGateway);
    }

    @Override
    public LotacaoOutput execute(final Long anIn) {
        final var anLotacaoID = LotacaoID.from(anIn);

        return this.lotacaoGateway.findById(anLotacaoID)
                .map(LotacaoOutput::from)
                .orElseThrow(notFound(anLotacaoID));
    }

    private Supplier<NotFoundException> notFound(final LotacaoID anId) {
        return () -> NotFoundException.with(Lotacao.class, anId);
    }
}
