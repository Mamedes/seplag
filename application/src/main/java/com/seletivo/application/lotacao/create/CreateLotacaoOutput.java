package com.seletivo.application.lotacao.create;

import com.seletivo.domain.lotacao.Lotacao;

public record CreateLotacaoOutput(
        Long id
) {

    public static CreateLotacaoOutput from(final Long anId) {
        return new CreateLotacaoOutput(anId);
    }

    public static CreateLotacaoOutput from(final Lotacao aLotacao) {
        return new CreateLotacaoOutput(aLotacao.getId().getValue());
    }
}
