package com.seletivo.application.unidade.fetch.get;


import com.seletivo.domain.exceptions.NotFoundException;
import com.seletivo.domain.unidade.Unidade;
import com.seletivo.domain.unidade.UnidadeGateway;
import com.seletivo.domain.unidade.UnidadeID;

import java.util.Objects;
import java.util.function.Supplier;

public class DefaultGetUnidadeByIdUseCase extends GetUnidadeByIdUseCase {

    private final UnidadeGateway unidadeGateway;

    public DefaultGetUnidadeByIdUseCase(final UnidadeGateway unidadeGateway) {
        this.unidadeGateway = Objects.requireNonNull(unidadeGateway);
    }

    @Override
    public UnidadeOutput execute(final Long anIn) {
        final var anUnidadeID = UnidadeID.from(anIn);

        return this.unidadeGateway.findById(anUnidadeID)
                .map(UnidadeOutput::from)
                .orElseThrow(notFound(anUnidadeID));
    }

    private Supplier<NotFoundException> notFound(final UnidadeID anId) {
        return () -> NotFoundException.with(Unidade.class, anId);
    }
}
