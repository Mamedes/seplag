package com.seletivo.domain.unidade;

import com.seletivo.domain.endereco.EnderecoID;
import com.seletivo.domain.pagination.Pagination;
import com.seletivo.domain.pagination.SearchQuery;

import java.util.List;
import java.util.Optional;

public interface UnidadeEnderecoGateway {

    UnidadeEndereco create(UnidadeEndereco unidadeEndereco);

    UnidadeEndereco createAll(UnidadeID unidadeID,  List<EnderecoID> enderecoId);


    void deleteById(UnidadeID anId);

    Optional<UnidadeEndereco> findById(UnidadeID anId);

    UnidadeEndereco update(UnidadeEndereco aUnidadeEndereco);

    Pagination<UnidadeEndereco> findAll(SearchQuery aQuery);

    List<UnidadeID> existsByIds(Iterable<UnidadeID> ids);
}
