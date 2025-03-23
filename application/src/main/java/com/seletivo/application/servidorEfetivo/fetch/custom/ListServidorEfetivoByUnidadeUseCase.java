package com.seletivo.application.servidorEfetivo.fetch.custom;

import com.seletivo.application.UseCase;
import com.seletivo.application.servidorEfetivo.ServidorEfetivoByUnidadeOutput;
import com.seletivo.domain.pagination.Pagination;
import com.seletivo.domain.pagination.SearchQuery;

public abstract class ListServidorEfetivoByUnidadeUseCase extends UseCase<SearchQuery, Pagination<ServidorEfetivoByUnidadeOutput>> {
    public abstract Pagination<ServidorEfetivoByUnidadeOutput> execute(SearchQuery searchQuery, Long unidadeId);
}