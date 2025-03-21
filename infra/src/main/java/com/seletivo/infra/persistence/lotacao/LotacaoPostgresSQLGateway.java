package com.seletivo.infra.persistence.lotacao;

import com.seletivo.domain.lotacao.Lotacao;
import com.seletivo.domain.lotacao.LotacaoGateway;
import com.seletivo.domain.lotacao.LotacaoID;
import com.seletivo.domain.pagination.Pagination;
import com.seletivo.domain.pagination.SearchQuery;
import com.seletivo.infra.utils.SpecificationUtils;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.StreamSupport;


@Component
public class LotacaoPostgresSQLGateway implements LotacaoGateway {

    private final LotacaoRepository repository;

    public LotacaoPostgresSQLGateway(final LotacaoRepository repository) {
        this.repository = repository;
    }

    @Override
    public Lotacao create(final Lotacao aLotacao) {
        return save(aLotacao);
    }

    @Override
    public void deleteById(LotacaoID anId) {
        final Long anIdValue = anId.getValue();
        if(this.repository.existsById(anIdValue)){
            this.repository.deleteById(anIdValue);
        }

    }

    @Override
    public Optional<Lotacao> findById(LotacaoID anId) {
        return this.repository.findById(anId.getValue()).map(LotacaoJpaEntity:: toAggregate);
    }

    @Override
    public Lotacao update(final Lotacao aLotacao) {
        return save(aLotacao);
    }

    @Override
    public Pagination<Lotacao> findAll(SearchQuery aQuery) {
        return null;
    }

    @Override
    public List<LotacaoID> existsByIds(Iterable<LotacaoID> ids) {
        List<Long> idValues = StreamSupport.stream(ids.spliterator(), false)
                .map(LotacaoID::getValue)
                .toList();

        List<Long> foundIds = repository.findAllById(idValues)
                .stream()
                .map(LotacaoJpaEntity::getId)
                .toList();

        return foundIds.stream()
                .map(LotacaoID::from)
                .toList();
    }


    private Lotacao save(final Lotacao aLotacao) {
        return this.repository.save(LotacaoJpaEntity.from(aLotacao)).toAggregate();
    }

    private Specification<LotacaoJpaEntity> assembleSpecification(final String str) {
        final Specification<LotacaoJpaEntity> nameLike = SpecificationUtils.like("nome", str);
        return nameLike;
    }
}
