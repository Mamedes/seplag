package com.seletivo.application.endereco.fetch;

import com.seletivo.domain.endereco.Endereco;
import com.seletivo.domain.endereco.EnderecoGateway;
import com.seletivo.domain.endereco.EnderecoID;
import com.seletivo.domain.exceptions.NotFoundException;

import java.util.Objects;
import java.util.function.Supplier;

public class DefaultGetEnderecoByIdUseCase extends GetEnderecoByIdUseCase {

    private final EnderecoGateway enderecoGateway;

    public DefaultGetEnderecoByIdUseCase(final EnderecoGateway enderecoGateway) {
        this.enderecoGateway = Objects.requireNonNull(enderecoGateway);
    }

    @Override
    public EnderecoOutput execute(final Long anIn) {
        final var aEnderecoID = EnderecoID.from(anIn);

        return this.enderecoGateway.findById(aEnderecoID)
                .map(EnderecoOutput::from)
                .orElseThrow(notFound(aEnderecoID));
    }

    private Supplier<NotFoundException> notFound(final EnderecoID anId) {
        return () -> NotFoundException.with(Endereco.class, anId);
    }
}
