package com.seletivo.application.unidade.fetch.list;

import com.seletivo.domain.unidade.Unidade;
import com.seletivo.domain.unidade.UnidadeID;

public record  UnidadeListOutput(         
        UnidadeID id,
        String nome,
        String sigla
) {
        public static UnidadeListOutput from(final Unidade aUnidade) {
            return new UnidadeListOutput(
                    aUnidade.getId(),
                    aUnidade.getNome(),
                    aUnidade.getSigla()
            );
        }
    }