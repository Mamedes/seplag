package com.seletivo.application.cidade;

import com.seletivo.domain.cidade.Cidade;
import com.seletivo.domain.cidade.CidadeID;

public record UpdateCidadeOutput(
        CidadeID id
) {

    public static UpdateCidadeOutput from(final Cidade aCidade) {
        return new UpdateCidadeOutput(aCidade.getId());
    }
}