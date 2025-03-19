package com.seletivo.infra.persistence.pessoa;


import com.seletivo.domain.pagination.Pagination;
import com.seletivo.domain.pagination.SearchQuery;
import com.seletivo.domain.pessoa.Pessoa;
import com.seletivo.domain.pessoa.PessoaGateway;
import com.seletivo.domain.pessoa.PessoaID;
import com.seletivo.infra.utils.SpecificationUtils;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;


@Component
public class PessoaPostgresSQLGateway implements PessoaGateway {

    private final PessoaRepository repository;

    public PessoaPostgresSQLGateway(final PessoaRepository repository) {
        this.repository = repository;
    }

    @Override
    public Pessoa create(final Pessoa aPessoa) {
        return save(aPessoa);
    }

    @Override
    public void deleteById(PessoaID anId) {

    }

    @Override
    public Optional<Pessoa> findById(PessoaID anId) {
        return this.repository.findById(anId.getValue()).map(PessoaJpaEntity :: toAggregate);
    }

    @Override
    public Pessoa update(Pessoa aPessoa) {
        return null;
    }

    @Override
    public Pagination<Pessoa> findAll(SearchQuery aQuery) {
        return null;
    }

    @Override
    public List<PessoaID> existsByIds(Iterable<PessoaID> ids) {
        return List.of();
    }

    private Pessoa save(final Pessoa aPessoa) {
        return this.repository.save(PessoaJpaEntity.from(aPessoa)).toAggregate();
    }

    private Specification<PessoaJpaEntity> assembleSpecification(final String str) {
        final Specification<PessoaJpaEntity> nameLike = SpecificationUtils.like("nome", str);
        return nameLike;
    }
}
