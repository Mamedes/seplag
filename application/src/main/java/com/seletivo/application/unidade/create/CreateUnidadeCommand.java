package com.seletivo.application.unidade.create;

import java.util.List;

public record CreateUnidadeCommand(
        String nome,
        String sigla,
        List<Long> enderecoIds
) {

    public static CreateUnidadeCommand with(
            final String nome,
            final String sigla,
            List<Long> enderecoIds
    ) {
        return new CreateUnidadeCommand(nome, sigla, enderecoIds);
    }
}
