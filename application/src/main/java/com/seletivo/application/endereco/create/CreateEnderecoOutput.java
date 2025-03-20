package com.seletivo.application.endereco.create;


import com.seletivo.domain.endereco.Endereco;

public record CreateEnderecoOutput(
        Long id
) {

    public static CreateEnderecoOutput from(final Long anId) {
        return new CreateEnderecoOutput(anId);
    }

    public static CreateEnderecoOutput from(final Endereco aEndereco) {
        return new CreateEnderecoOutput(aEndereco.getId().getValue());
    }
}
