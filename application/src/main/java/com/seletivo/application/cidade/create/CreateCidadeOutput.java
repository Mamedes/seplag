package com.seletivo.application.cidade.create;

import com.seletivo.domain.cidade.Cidade;
import com.seletivo.domain.cidade.CidadeID;

public record CreateCidadeOutput(
        CidadeID id
) {

    public static CreateCidadeOutput from(final Cidade aCidade) {
        return new CreateCidadeOutput(aCidade.getId());
    }
}
