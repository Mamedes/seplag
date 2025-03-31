package com.seletivo.application.cidade.fetch.list;

import com.seletivo.domain.cidade.Cidade;
import com.seletivo.domain.cidade.CidadeGateway;
import com.seletivo.domain.pagination.Pagination;
import com.seletivo.domain.pagination.SearchQuery;

import java.util.Objects;

public class DefaultListCidadeUseCase extends ListCidadeUseCase {

    private final CidadeGateway cidadeGateway;

    public DefaultListCidadeUseCase(final CidadeGateway cidadeGateway) {
        this.cidadeGateway = Objects.requireNonNull(cidadeGateway);
    }

    @Override
    public Pagination<CidadeListOutput> execute(final SearchQuery aQuery) {
        return this.cidadeGateway.findAll(aQuery)
                .map(CidadeListOutput::from);
    }
}