package com.seletivo.application.pessoaFoto.list;

import com.seletivo.application.UseCase;
import com.seletivo.application.pessoaFoto.FotoPessoaOutput;
import com.seletivo.domain.pagination.Pagination;
import com.seletivo.domain.pagination.SearchQuery;

public abstract class ListPessoaFotoUseCase
        extends UseCase<SearchQuery, Pagination<FotoPessoaOutput>> {
}
