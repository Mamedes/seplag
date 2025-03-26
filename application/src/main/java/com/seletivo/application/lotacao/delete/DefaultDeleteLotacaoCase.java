package com.seletivo.application.lotacao.delete;

import java.util.Objects;
import com.seletivo.domain.lotacao.LotacaoGateway;
import com.seletivo.domain.lotacao.LotacaoID;


public class DefaultDeleteLotacaoCase extends DeleteLotacaoUseCase {

    private final LotacaoGateway lotacaoGateway;

    public DefaultDeleteLotacaoCase(final LotacaoGateway lotacaoGateway) {
        this.lotacaoGateway = Objects.requireNonNull(lotacaoGateway);
    }

    @Override
    public void execute(final Long anIn) {
        this.lotacaoGateway.deleteById(LotacaoID.from(anIn));
    }
}
