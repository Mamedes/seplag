package com.seletivo.domain.endereco;

import com.seletivo.domain.pagination.Pagination;
import com.seletivo.domain.pagination.SearchQuery;

import java.util.List;
import java.util.Optional;

public interface EnderecoGateway {

    Endereco create(Endereco aEndereco);

    void deleteById(EnderecoID anId);

    Optional<Endereco> findById(EnderecoID anId);

    Endereco update(Endereco aEndereco);

    Pagination<Endereco> findAll(SearchQuery aQuery);

    List<EnderecoID> existsByIds(Iterable<EnderecoID> ids);
}
