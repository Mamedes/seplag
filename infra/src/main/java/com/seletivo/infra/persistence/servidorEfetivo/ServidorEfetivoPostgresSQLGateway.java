package com.seletivo.infra.persistence.servidorEfetivo;

import com.seletivo.domain.pagination.Pagination;
import com.seletivo.domain.pagination.SearchQuery;
import com.seletivo.domain.pessoa.PessoaID;
import com.seletivo.domain.servidorEfetivo.ServidorEfetivo;
import com.seletivo.domain.servidorEfetivo.ServidorEfetivoGateway;
import com.seletivo.infra.utils.SpecificationUtils;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;


@Component
public class ServidorEfetivoPostgresSQLGateway implements ServidorEfetivoGateway {

    private final ServidorEfetivoRepository repository;

    public ServidorEfetivoPostgresSQLGateway(final ServidorEfetivoRepository repository) {
        this.repository = repository;
    }

    @Override
    public ServidorEfetivo create(final ServidorEfetivo aServidorEfetivo) {
        return save(aServidorEfetivo);
    }

    @Override
    public void deleteById(PessoaID anId) {

    }

    @Override
    public Optional<ServidorEfetivo> findById(PessoaID anId) {
        return this.repository.findById(anId.getValue()).map(ServidorEfetivoJpaEntity:: toAggregate);
    }

    @Override
    public ServidorEfetivo update(ServidorEfetivo aPessoa) {
        return null;
    }

    @Override
    public Pagination<ServidorEfetivo> findAll(SearchQuery aQuery) {
        return null;
    }

    @Override
    public List<PessoaID> existsByIds(Iterable<PessoaID> ids) {
        return List.of();
    }

    private ServidorEfetivo save(final ServidorEfetivo aServidorEfetivo) {
        return this.repository.save(ServidorEfetivoJpaEntity.from(aServidorEfetivo)).toAggregate();
    }

    private Specification<ServidorEfetivoJpaEntity> assembleSpecification(final String str) {
        final Specification<ServidorEfetivoJpaEntity> nameLike = SpecificationUtils.like("nome", str);
        return nameLike;
    }
}
