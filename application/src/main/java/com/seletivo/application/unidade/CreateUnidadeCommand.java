package com.seletivo.application.unidade;

import java.time.LocalDate;

public record CreateUnidadeCommand(
        String nome,
        String sigla
) {

    public static CreateUnidadeCommand with(
            final String nome,
            final String sigla
    ) {
        return new CreateUnidadeCommand(nome, sigla);
    }
}
