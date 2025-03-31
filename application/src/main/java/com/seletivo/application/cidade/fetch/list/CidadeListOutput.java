package com.seletivo.application.cidade.fetch.list;

import com.seletivo.domain.cidade.Cidade;
import com.seletivo.domain.cidade.CidadeID;

public record CidadeListOutput(
        CidadeID id,
        String nome,
        String uf
) {
    public static CidadeListOutput from(final Cidade aCidade) {
        return new CidadeListOutput(
                aCidade.getId(),
                aCidade.getNome(),
                aCidade.getUf()
        );
    }
}