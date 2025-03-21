package com.seletivo.domain.lotacao;

import com.seletivo.domain.pagination.Pagination;
import com.seletivo.domain.pagination.SearchQuery;


import java.util.List;
import java.util.Optional;

public interface LotacaoGateway {

    Lotacao create(Lotacao aLotacao);

    void deleteById(LotacaoID anId);

    Optional<Lotacao> findById(LotacaoID anId);

    Lotacao update(Lotacao aLotacao);

    Pagination<Lotacao> findAll(SearchQuery aQuery);

    List<LotacaoID> existsByIds(Iterable<LotacaoID> ids);
}
