package com.seletivo.application.pessoaFoto;

import com.seletivo.domain.pessoa.FotoPessoaID;
import com.seletivo.domain.pessoa.FotoPessoa;
import com.seletivo.domain.pessoa.PessoaID;

import java.time.LocalDate;

public record FotoPessoaOutput(
        FotoPessoaID id,
        PessoaID pessoaID,
        LocalDate data,
        String bucket,
        String hash
) {

    public static FotoPessoaOutput from(final FotoPessoa aFotoPessoa) {
        return new FotoPessoaOutput(
                aFotoPessoa.getId(),
                aFotoPessoa.getPessoaID(),
                aFotoPessoa.getData(),
                aFotoPessoa.getBucket(),
                aFotoPessoa.getHash()
        );
    }
}