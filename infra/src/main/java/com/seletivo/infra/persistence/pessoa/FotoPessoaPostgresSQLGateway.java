package com.seletivo.infra.persistence.pessoa;


import com.seletivo.domain.pagination.Pagination;
import com.seletivo.domain.pagination.SearchQuery;
import com.seletivo.domain.pessoa.FotoPessoa;
import com.seletivo.domain.pessoa.FotoPessoaGateway;
import com.seletivo.domain.pessoa.FotoPessoaID;
import com.seletivo.infra.utils.SpecificationUtils;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;


@Component
public class FotoPessoaPostgresSQLGateway implements FotoPessoaGateway {

    private final FotoPessoaRepository repository;

    public FotoPessoaPostgresSQLGateway(final FotoPessoaRepository repository) {
        this.repository = repository;
    }

    @Override
    public FotoPessoa create(final FotoPessoa aFotoPessoa) {
        return save(aFotoPessoa);
    }

    @Override
    public void deleteById(FotoPessoaID anId) {

    }

    @Override
    public Optional<FotoPessoa> findById(FotoPessoaID anId) {
        return this.repository.findById(anId.getValue()).map(FotoPessoaJpaEntity :: toAggregate);
    }

    @Override
    public FotoPessoa update(FotoPessoa aFotoPessoa) {
        return save(aFotoPessoa);
    }

    @Override
    public Pagination<FotoPessoa> findAll(SearchQuery aQuery) {
        final var page = PageRequest.of(
                aQuery.page(),
                aQuery.perPage(),
                Sort.by(Sort.Direction.fromString(aQuery.direction()), aQuery.sort())
        );

        final var pageResult = this.repository.findAll(page);

        return new Pagination<>(
                pageResult.getNumber(),
                pageResult.getSize(),
                pageResult.getTotalElements(),
                pageResult.map(FotoPessoaJpaEntity::toAggregate).toList()
        );
    }

    @Override
    public List<FotoPessoaID> existsByIds(Iterable<FotoPessoaID> ids) {
        return List.of();
    }

    private FotoPessoa save(final FotoPessoa aFotoPessoa) {
        return this.repository.save(FotoPessoaJpaEntity.from(aFotoPessoa)).toAggregate();
    }


}
