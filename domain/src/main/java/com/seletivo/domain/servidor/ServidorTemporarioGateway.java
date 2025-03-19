package com.seletivo.domain.servidor;

import com.seletivo.domain.pagination.Pagination;
import com.seletivo.domain.pagination.SearchQuery;
import com.seletivo.domain.pessoa.Pessoa;
import com.seletivo.domain.pessoa.PessoaID;

import java.util.List;
import java.util.Optional;

public interface ServidorTemporarioGateway {

    Pessoa create(Pessoa aPessoa);

    void deleteById(PessoaID anId);

    Optional<Pessoa> findById(PessoaID anId);

    Pessoa update(Pessoa aPessoa);

    Pagination<Pessoa> findAll(SearchQuery aQuery);

    List<PessoaID> existsByIds(Iterable<PessoaID> ids);
}
