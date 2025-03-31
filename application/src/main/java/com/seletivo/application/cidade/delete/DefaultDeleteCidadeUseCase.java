package com.seletivo.application.cidade.delete;


import com.seletivo.domain.cidade.CidadeGateway;
import com.seletivo.domain.cidade.CidadeID;

import java.util.Objects;

public class DefaultDeleteCidadeUseCase extends DeleteCidadeUseCase {

    private final CidadeGateway cidadeGateway;

    public DefaultDeleteCidadeUseCase(final CidadeGateway cidadeGateway) {
        this.cidadeGateway = Objects.requireNonNull(cidadeGateway);
    }

    @Override
    public Void execute(final Long anId) {
        cidadeGateway.deleteById(CidadeID.from(anId));
        return null;
    }
}