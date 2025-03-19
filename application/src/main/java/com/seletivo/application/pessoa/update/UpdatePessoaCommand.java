package com.seletivo.application.pessoa.update;

import java.time.LocalDate;

public record UpdatePessoaCommand(
        String id,
        String nome,
        LocalDate dataNascimento,
        String sexo,
        String nomeMae,
        String nomePai
) {

    public static UpdatePessoaCommand with(
            final String anId,
            final String nome,
            final LocalDate dataNascimento,
            final String sexo,
            final String nomeMae,
            final String nomePai
    ) {
        return new UpdatePessoaCommand(anId, nome,
                dataNascimento,
                sexo,
                nomeMae,
                nomePai);
    }
}
