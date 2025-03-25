package com.seletivo.infra.persistence.unidade;


import com.seletivo.domain.endereco.EnderecoID;
import com.seletivo.domain.pagination.Pagination;
import com.seletivo.domain.pagination.SearchQuery;
import com.seletivo.domain.unidade.Unidade;
import com.seletivo.domain.unidade.UnidadeEndereco;
import com.seletivo.domain.unidade.UnidadeEnderecoGateway;
import com.seletivo.domain.unidade.UnidadeID;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;


@Component
public class UnidadeEnderecoPostgresSQLGateway implements UnidadeEnderecoGateway {

    private final UnidadeEnderecoRepository repository ;

    public UnidadeEnderecoPostgresSQLGateway(final UnidadeEnderecoRepository repository) {
        this.repository = repository;
    }


    @Override
    public UnidadeEndereco create(final UnidadeEndereco aUnidadeEndereco) {
        return save(aUnidadeEndereco);
    }

    @Override
    public UnidadeEndereco createAll(UnidadeID unidadeID, List<EnderecoID> enderecoId) {
        return null;
    }

    @Override
    public void deleteById(UnidadeID anId) {

    }

    @Override
    public Optional<UnidadeEndereco> findById(UnidadeID anId) {
        return Optional.empty();
    }

    @Override
    public UnidadeEndereco update(UnidadeEndereco aUnidadeEndereco) {
        return save(aUnidadeEndereco);
    }

    @Override
    public Pagination<UnidadeEndereco> findAll(SearchQuery aQuery) {
        return null;
    }

    @Override
    public List<UnidadeID> existsByIds(Iterable<UnidadeID> ids) {
        return List.of();
    }

    private UnidadeEndereco save(final UnidadeEndereco aUnidadeEndereco) {
        return this.repository.save(UnidadeEnderecoJpaEntity.from(aUnidadeEndereco)).toAggregate();
    }
}
