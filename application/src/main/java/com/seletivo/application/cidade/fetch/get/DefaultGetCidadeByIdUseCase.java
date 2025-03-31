package com.seletivo.application.cidade.fetch.get;

import com.seletivo.domain.cidade.Cidade;
import com.seletivo.domain.cidade.CidadeGateway;
import com.seletivo.domain.cidade.CidadeID;

import java.util.Objects;
import java.util.Optional;

public class DefaultGetCidadeByIdUseCase extends GetCidadeByIdUseCase {

    private final CidadeGateway cidadeGateway;

    public DefaultGetCidadeByIdUseCase(final CidadeGateway cidadeGateway) {
        this.cidadeGateway = Objects.requireNonNull(cidadeGateway);
    }

    @Override
    public GetCidadeByIdOutput execute(final Long anId) {
        final CidadeID cidadeID = CidadeID.from(anId);
        final Optional<Cidade> cidade = cidadeGateway.findById(cidadeID);
        return cidade.map(GetCidadeByIdOutput::from).orElse(null);
    }
}