package com.seletivo.infra.persistence.unidade;


import com.seletivo.domain.pagination.Pagination;
import com.seletivo.domain.pagination.SearchQuery;

import com.seletivo.domain.unidade.Unidade;
import com.seletivo.domain.unidade.UnidadeGateway;
import com.seletivo.domain.unidade.UnidadeID;
import com.seletivo.infra.utils.SpecificationUtils;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;


@Component
public class UnidadePostgresSQLGateway implements UnidadeGateway {

    private final UnidadeRepository repository;

    public UnidadePostgresSQLGateway(final UnidadeRepository repository) {
        this.repository = repository;
    }

    @Override
    public Unidade create(final Unidade aUnidade) {
        return save(aUnidade);
    }

    @Override
    public void deleteById(UnidadeID anId) {
        final Long anIdValue = anId.getValue();
        if (this.repository.existsById(anIdValue)) {
            this.repository.deleteById(anIdValue);
        }

    }

    @Override
    public Optional<Unidade> findById(UnidadeID anId) {
        return this.repository.findById(anId.getValue()).map(UnidadeJpaEntity::toAggregate);
    }

    @Override
    public Unidade update(Unidade aUnidade) {
        return save(aUnidade);
    }

    @Override
    public Pagination<Unidade> findAll(SearchQuery aQuery) {
        final var page = PageRequest.of(
                aQuery.page(),
                aQuery.perPage(),
                Sort.by(Sort.Direction.fromString(aQuery.direction()), aQuery.sort())
        );

        final var specifications = Optional.ofNullable(aQuery.terms())
                .filter(str -> !str.isBlank())
                .map(this::assembleSpecification)
                .orElse(null);

        final var pageResult =
                this.repository.findAll(Specification.where(specifications), page);

        return new Pagination<>(
                pageResult.getNumber(),
                pageResult.getSize(),
                pageResult.getTotalElements(),
                pageResult.map(UnidadeJpaEntity::toAggregate).toList()
        );
    }

    @Override
    public List<UnidadeID> existsByIds(Iterable<UnidadeID> ids) {
        return List.of();
    }

    private Unidade save(final Unidade aUnidade) {
        return this.repository.save(UnidadeJpaEntity.from(aUnidade)).toAggregate();
    }

    private Specification<UnidadeJpaEntity> assembleSpecification(final String str) {
        final Specification<UnidadeJpaEntity> nameLike = SpecificationUtils.like("nome", str);
        return nameLike;
    }
}
