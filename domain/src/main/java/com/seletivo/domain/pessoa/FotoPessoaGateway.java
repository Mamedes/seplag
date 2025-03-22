package com.seletivo.domain.pessoa;

import com.seletivo.domain.pagination.Pagination;
import com.seletivo.domain.pagination.SearchQuery;

import java.util.List;
import java.util.Optional;

public interface FotoPessoaGateway {

    FotoPessoa create(FotoPessoa aFotoPessoa);

    void deleteById(FotoPessoaID anId);

    Optional<FotoPessoa> findById(FotoPessoaID anId);

    FotoPessoa update(FotoPessoa aFotoPessoa);

    Pagination<FotoPessoa> findAll(SearchQuery aQuery);

    List<FotoPessoaID> existsByIds(Iterable<FotoPessoaID> ids);
}
