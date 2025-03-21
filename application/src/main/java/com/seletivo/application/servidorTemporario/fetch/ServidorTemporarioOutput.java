package com.seletivo.application.servidorTemporario.fetch;

import com.seletivo.application.pessoa.fetch.PessoaOutput;
import com.seletivo.domain.pessoa.PessoaID;
import com.seletivo.domain.servidorTemporario.ServidorTemporario;

import java.time.LocalDate;

public record ServidorTemporarioOutput(
        PessoaID id,
        LocalDate dataAdmissao,
        LocalDate dataDemissao,
        PessoaOutput pessoa
) {

    public static ServidorTemporarioOutput from(final ServidorTemporario aServidorTemporario, final  PessoaOutput pessoa) {
        return new ServidorTemporarioOutput(
                aServidorTemporario.getId(),
                aServidorTemporario.getDataAdmissao(),
                aServidorTemporario.getDataDemissao(),
                pessoa
        );
    }
}