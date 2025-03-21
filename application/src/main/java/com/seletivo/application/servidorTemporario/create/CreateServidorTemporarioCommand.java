package com.seletivo.application.servidorTemporario.create;

import com.seletivo.application.pessoa.create.CreatePessoaCommand;

import java.time.LocalDate;

public record CreateServidorTemporarioCommand(
        LocalDate dataAdmissao,
        LocalDate dataDemissao,
        CreatePessoaCommand pessoaCommand
) {

    public static CreateServidorTemporarioCommand with(
            final LocalDate dataAdmissao,
            final LocalDate dataDemissao,
            final CreatePessoaCommand pessoaCommand
    ) {
        return new CreateServidorTemporarioCommand(dataAdmissao,dataDemissao, pessoaCommand);
    }
}