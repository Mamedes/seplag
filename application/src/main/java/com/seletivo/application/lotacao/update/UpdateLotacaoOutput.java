package com.seletivo.application.lotacao.update;

import com.seletivo.domain.lotacao.Lotacao;
import com.seletivo.domain.lotacao.LotacaoID;

public record UpdateLotacaoOutput(
        Long id
) {

    public static UpdateLotacaoOutput from(final Long anId) {
        return new UpdateLotacaoOutput(anId);
    }

    public static UpdateLotacaoOutput from(final Lotacao aLotacao) {
        return new UpdateLotacaoOutput(aLotacao.getId().getValue());
    }
}