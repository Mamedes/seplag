package com.seletivo.application.endereco.delete;

import com.seletivo.domain.endereco.EnderecoGateway;
import com.seletivo.domain.endereco.EnderecoID;

import java.util.Objects;

public class DefaultDeleteEnderecoUseCase extends DeleteEnderecoUseCase {

    private final EnderecoGateway enderecoGateway;

    public DefaultDeleteEnderecoUseCase(final EnderecoGateway enderecoGateway) {
        this.enderecoGateway = Objects.requireNonNull(enderecoGateway);
    }

    @Override
    public void execute(final Long anIn) {
        this.enderecoGateway.deleteById(EnderecoID.from(anIn));
    }
}
