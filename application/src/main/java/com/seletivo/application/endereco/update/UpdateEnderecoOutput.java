package com.seletivo.application.endereco.update;

import com.seletivo.domain.endereco.Endereco;

public record UpdateEnderecoOutput(
        Long id
) {

    public static UpdateEnderecoOutput from(final Long anId) {
        return new UpdateEnderecoOutput(anId);
    }

    public static UpdateEnderecoOutput from(final Endereco aEndereco) {
        return new UpdateEnderecoOutput(aEndereco.getId().getValue());
    }
}
