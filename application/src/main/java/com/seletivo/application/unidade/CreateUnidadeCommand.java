package com.seletivo.application.unidade;

import com.seletivo.domain.endereco.EnderecoID;

import java.time.LocalDate;
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
