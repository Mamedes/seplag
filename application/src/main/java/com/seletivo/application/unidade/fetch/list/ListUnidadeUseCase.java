package com.seletivo.application.unidade.fetch.list;

import com.seletivo.application.UseCase;
import com.seletivo.domain.pagination.Pagination;
import com.seletivo.domain.pagination.SearchQuery;

public abstract class ListUnidadeUseCase
                extends UseCase<SearchQuery, Pagination<UnidadeListOutput>> {
}
