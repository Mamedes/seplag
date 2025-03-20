package com.seletivo.application.unidade.unidadeEndereco;


import com.seletivo.domain.unidade.UnidadeEndereco;

public record CreateUnidadeEnderecoOutput(
        Long id
) {

    public static CreateUnidadeEnderecoOutput from(final Long anId) {
        return new CreateUnidadeEnderecoOutput(anId);
    }

    public static CreateUnidadeEnderecoOutput from(final UnidadeEndereco aUnidadeEndereco) {
        return new CreateUnidadeEnderecoOutput(aUnidadeEndereco.getEnderecoId().getValue());
    }
}
