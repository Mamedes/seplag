package com.seletivo.domain.servidorTemporario;

import com.seletivo.domain.pagination.Pagination;
import com.seletivo.domain.pagination.SearchQuery;
import com.seletivo.domain.pessoa.PessoaID;

import java.util.List;
import java.util.Optional;

public interface ServidorTemporarioGateway {

    ServidorTemporario create(ServidorTemporario aPessoa);

    void deleteById(PessoaID anId);

    Optional<ServidorTemporario> findById(PessoaID anId);

    ServidorTemporario update(ServidorTemporario aPessoa);

    Pagination<ServidorTemporario> findAll(SearchQuery aQuery);

    List<PessoaID> existsByIds(Iterable<PessoaID> ids);
}
