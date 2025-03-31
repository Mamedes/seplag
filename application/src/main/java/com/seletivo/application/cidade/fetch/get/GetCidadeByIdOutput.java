package com.seletivo.application.cidade.fetch.get;

import com.seletivo.domain.cidade.Cidade;
import com.seletivo.domain.cidade.CidadeID;

public record GetCidadeByIdOutput(
        CidadeID id,
        String nome,
        String uf
) {

    public static GetCidadeByIdOutput from(final Cidade aCidade) {
        return new GetCidadeByIdOutput(
                aCidade.getId(),
                aCidade.getNome(),
                aCidade.getUf()
        );
    }
}