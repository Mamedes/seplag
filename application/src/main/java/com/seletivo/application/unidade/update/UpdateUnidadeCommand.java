package com.seletivo.application.unidade.update;

import java.util.List;

public record UpdateUnidadeCommand(
        Long id,
        String nome,
        String sigla,
        List<Long> enderecoIds
) {

    public static UpdateUnidadeCommand with(
            final Long anId,
            final String nome,
            final String sigla,
            final List<Long> enderecoIds
    ) {
        return new UpdateUnidadeCommand(anId, nome, sigla, enderecoIds);
    }
}
