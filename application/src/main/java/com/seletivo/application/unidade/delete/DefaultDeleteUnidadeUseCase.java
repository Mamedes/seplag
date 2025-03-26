package com.seletivo.application.unidade.delete;


import java.util.Objects;
import com.seletivo.domain.unidade.UnidadeGateway;
import com.seletivo.domain.unidade.UnidadeID;

public class DefaultDeleteUnidadeUseCase extends DeleteUnidadeUseCase {

    private final UnidadeGateway unidadeGateway;

    public DefaultDeleteUnidadeUseCase(final UnidadeGateway unidadeGateway) {
        this.unidadeGateway = Objects.requireNonNull(unidadeGateway);
    }

    @Override
    public void execute(final Long anIn) {
        this.unidadeGateway.deleteById(UnidadeID.from(anIn));
    }
}
