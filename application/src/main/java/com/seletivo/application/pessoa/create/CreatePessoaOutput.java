package com.seletivo.application.pessoa.create;


import com.seletivo.domain.pessoa.Pessoa;

public record CreatePessoaOutput(
        Long id
) {

    public static CreatePessoaOutput from(final Long anId) {
        return new CreatePessoaOutput(anId);
    }

    public static CreatePessoaOutput from(final Pessoa aPessoa) {
        return new CreatePessoaOutput(aPessoa.getId().getValue());
    }
}
