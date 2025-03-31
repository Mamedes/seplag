package com.seletivo.domain.cidade;

import com.seletivo.domain.pagination.Pagination;
import com.seletivo.domain.pagination.SearchQuery;

import java.util.List;
import java.util.Optional;

public interface CidadeGateway {

    Cidade create(Cidade aCidade);

    void deleteById(CidadeID anId);

    Optional<Cidade> findById(CidadeID anId);

    Cidade update(Cidade aCidade);

    Pagination<Cidade> findAll(SearchQuery aQuery);

    List<CidadeID> existsByIds(Iterable<CidadeID> ids);
}