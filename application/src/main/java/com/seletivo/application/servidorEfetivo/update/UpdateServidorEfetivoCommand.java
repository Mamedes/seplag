package com.seletivo.application.servidorEfetivo.update;

import com.seletivo.application.pessoa.update.UpdatePessoaCommand;

public record UpdateServidorEfetivoCommand(
        Long id,
        String matricula,
        UpdatePessoaCommand pessoaCommand
) {

    public static UpdateServidorEfetivoCommand with(
            final Long id,
            final String matricula,
            final UpdatePessoaCommand pessoaCommand
    ) {
        return new UpdateServidorEfetivoCommand(id,matricula, pessoaCommand);
    }
}