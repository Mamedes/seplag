package com.seletivo.application.unidade.fetch.get;

import com.seletivo.domain.unidade.Unidade;
import com.seletivo.domain.unidade.UnidadeID;

public record UnidadeOutput(
        UnidadeID id,
        String nome,
        String sigla
) {

    public static UnidadeOutput from(final Unidade aUnidade) {
        return new UnidadeOutput(
                aUnidade.getId(),
                aUnidade.getNome(),
                aUnidade.getSigla()
        );
    }
}