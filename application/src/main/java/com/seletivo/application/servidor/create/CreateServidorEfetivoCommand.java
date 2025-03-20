package com.seletivo.application.servidor.create;

import com.seletivo.application.pessoa.create.CreatePessoaCommand;

public record CreateServidorEfetivoCommand(
        String matricula,
        CreatePessoaCommand pessoaCommand
) {

    public static CreateServidorEfetivoCommand with(
            final String matricula,
            final CreatePessoaCommand pessoaCommand
    ) {
        return new CreateServidorEfetivoCommand(matricula, pessoaCommand);
    }
}