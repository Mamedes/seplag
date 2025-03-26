package com.seletivo.application.unidade.fetch.list;


import com.seletivo.domain.pagination.Pagination;
import com.seletivo.domain.pagination.SearchQuery;
import com.seletivo.domain.unidade.UnidadeGateway;

import java.util.Objects;

public class DefaultListUnidadeUseCase extends ListUnidadeUseCase {

    private final UnidadeGateway unidadeGateway;

    public DefaultListUnidadeUseCase(final UnidadeGateway unidadeGateway) {
        this.unidadeGateway = Objects.requireNonNull(unidadeGateway);
    }

    @Override
    public Pagination<UnidadeListOutput> execute(final SearchQuery aQuery) {
        return this.unidadeGateway.findAll(aQuery)
                .map(UnidadeListOutput::from);
    }
}