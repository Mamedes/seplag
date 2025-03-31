package com.seletivo.application.cidade.fetch.list;


import com.seletivo.application.UseCase;
import com.seletivo.domain.pagination.Pagination;
import com.seletivo.domain.pagination.SearchQuery;

public abstract class ListCidadeUseCase extends UseCase<SearchQuery, Pagination<CidadeListOutput>> {
}
