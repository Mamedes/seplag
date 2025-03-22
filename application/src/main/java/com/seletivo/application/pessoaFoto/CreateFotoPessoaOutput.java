package com.seletivo.application.pessoaFoto;


import com.seletivo.domain.pessoa.FotoPessoa;

public record CreateFotoPessoaOutput(
        Long id
) {

    public static CreateFotoPessoaOutput from(final Long anId) {
        return new CreateFotoPessoaOutput(anId);
    }

    public static CreateFotoPessoaOutput from(final FotoPessoa aFotoPessoa) {
        return new CreateFotoPessoaOutput(aFotoPessoa.getId().getValue());
    }

    public Long id() {
        return id;
    }
}