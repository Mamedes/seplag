package com.seletivo.domain.servidorEfetivo;

import com.seletivo.domain.pagination.Pagination;
import com.seletivo.domain.pagination.SearchQuery;
import com.seletivo.domain.pessoa.PessoaID;

import java.util.List;
import java.util.Optional;

public interface ServidorEfetivoGateway {

    ServidorEfetivo create(ServidorEfetivo aServidorEfetivo);

    void deleteById(PessoaID anId);

    Optional<ServidorEfetivo> findById(PessoaID anId);

    ServidorEfetivo update(ServidorEfetivo aServidorEfetivo);

    Pagination<ServidorEfetivo> findAll(SearchQuery aQuery);

    List<PessoaID> existsByIds(Iterable<PessoaID> ids);

    Pagination<ServidorEnderecoDomain> searchServidorEndereco(SearchQuery searchQuery);

    Pagination<ServidorEfetivoPorUnidade> findServidoresByUnidade(SearchQuery searchQuery, Long unidadeID);
}
