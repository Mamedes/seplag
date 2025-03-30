package com.seletivo.application.servidorTemporario.update;

import com.seletivo.application.pessoa.update.UpdatePessoaCommand;

import java.time.LocalDate;

public record UpdateServidorTemporarioCommand(
        Long id,
        LocalDate dataAdmissao,
        LocalDate dataDemissao,
        UpdatePessoaCommand pessoaCommand
) {

    public static UpdateServidorTemporarioCommand with(
            Long id,
            final LocalDate dataAdmissao,
            final LocalDate dataDemissao,
            final UpdatePessoaCommand pessoaCommand
    ) {
        return new UpdateServidorTemporarioCommand(id, dataAdmissao, dataDemissao, pessoaCommand);
    }
}