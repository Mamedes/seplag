package com.seletivo.domain.pessoa;

import com.seletivo.domain.pagination.Pagination;
import com.seletivo.domain.pagination.SearchQuery;

import java.util.List;
import java.util.Optional;

public interface PessoaGateway {

    Pessoa create(Pessoa aPessoa);

    void deleteById(PessoaID anId);

    Optional<Pessoa> findById(PessoaID anId);

    Pessoa update(Pessoa aPessoa);

    Pagination<Pessoa> findAll(SearchQuery aQuery);

    List<PessoaID> existsByIds(Iterable<PessoaID> ids);
}
