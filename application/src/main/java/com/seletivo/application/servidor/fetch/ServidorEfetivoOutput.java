package com.seletivo.application.servidor.fetch;

import com.seletivo.application.pessoa.fetch.PessoaOutput;
import com.seletivo.domain.pessoa.PessoaID;
import com.seletivo.domain.servidor.ServidorEfetivo;

public record ServidorEfetivoOutput(
        PessoaID id,
        String matricula,
        PessoaOutput pessoa
) {

    public static ServidorEfetivoOutput from(final ServidorEfetivo aServidorEfetivo, final  PessoaOutput pessoa) {
        return new ServidorEfetivoOutput(
                aServidorEfetivo.getId(),
                aServidorEfetivo.getMatricula(),
                pessoa
        );
    }
}