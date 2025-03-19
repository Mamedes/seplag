package com.seletivo.domain.unidade;

import com.seletivo.domain.pagination.Pagination;
import com.seletivo.domain.pagination.SearchQuery;


import java.util.List;
import java.util.Optional;

public interface UnidadeGateway {

    Unidade create(Unidade aUnidade);

    void deleteById(UnidadeID anId);

    Optional<Unidade> findById(UnidadeID anId);

    Unidade update(Unidade aUnidade);

    Pagination<Unidade> findAll(SearchQuery aQuery);

    List<UnidadeID> existsByIds(Iterable<UnidadeID> ids);
}
