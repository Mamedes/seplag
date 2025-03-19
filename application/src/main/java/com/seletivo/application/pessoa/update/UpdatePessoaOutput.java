package com.seletivo.application.pessoa.update;


import com.seletivo.domain.pessoa.Pessoa;

public record UpdatePessoaOutput(
        Long id
) {

    public static UpdatePessoaOutput from(final Long anId) {
        return new UpdatePessoaOutput(anId);
    }

    public static UpdatePessoaOutput from(final Pessoa aPessoa) {
        return new UpdatePessoaOutput(aPessoa.getId().getValue());
    }
}
