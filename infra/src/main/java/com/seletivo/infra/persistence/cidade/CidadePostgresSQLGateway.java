package com.seletivo.infra.persistence.cidade;

import com.seletivo.domain.cidade.Cidade;
import com.seletivo.domain.cidade.CidadeGateway;
import com.seletivo.domain.cidade.CidadeID;
import com.seletivo.domain.pagination.Pagination;
import com.seletivo.domain.pagination.SearchQuery;
import com.seletivo.infra.utils.SpecificationUtils;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class CidadePostgresSQLGateway implements CidadeGateway {

    private final CidadeRepository repository;

    public CidadePostgresSQLGateway(final CidadeRepository repository) {
        this.repository = repository;
    }

    @Override
    public Cidade create(final Cidade aCidade) {
        return save(aCidade);
    }

    @Override
    public void deleteById(CidadeID anId) {
        final Long anIdValue = anId.getValue();
        if (this.repository.existsById(anIdValue)) {
            this.repository.deleteById(anIdValue);
        }
    }

    @Override
    public Optional<Cidade> findById(CidadeID anId) {
        return this.repository.findById(anId.getValue()).map(CidadeJpaEntity::toAggregate);
    }

    @Override
    public Cidade update(Cidade aCidade) {
        return save(aCidade);
    }

    @Override
    public Pagination<Cidade> findAll(SearchQuery aQuery) {
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
                pageResult.map(CidadeJpaEntity::toAggregate).toList()
        );
    }

    @Override
    public List<CidadeID> existsByIds(Iterable<CidadeID> ids) {
        return List.of();
    }

    private Cidade save(final Cidade aCidade) {
        return this.repository.save(CidadeJpaEntity.from(aCidade)).toAggregate();
    }

    private Specification<CidadeJpaEntity> assembleSpecification(final String str) {
        final Specification<CidadeJpaEntity> nameLike = SpecificationUtils.like("nome", str);
        return nameLike;
    }
}