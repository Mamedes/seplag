package com.seletivo.application.pessoa.create;

import java.time.LocalDate;

public record CreatePessoaCommand(
        String nome,
        LocalDate dataNascimento,
        String sexo,
        String nomeMae,
        String nomePai
) {

    public static CreatePessoaCommand with(
            final String nome,
            final LocalDate dataNascimento,
            final String sexo,
            final String nomeMae,
            final String nomePai
    ) {
        return new CreatePessoaCommand(nome, dataNascimento, sexo,nomeMae,nomePai);
    }
}
