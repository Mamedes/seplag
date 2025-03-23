package com.seletivo.application.servidorEfetivo.fetch.custom;

import com.seletivo.application.UseCase;
import com.seletivo.application.servidorEfetivo.ServidorEnderecoOutput;
import com.seletivo.domain.pagination.Pagination;
import com.seletivo.domain.pagination.SearchQuery;

public abstract class SearchServidorEnderecoUseCase
                extends UseCase<SearchQuery, Pagination<ServidorEnderecoOutput>> {
}
