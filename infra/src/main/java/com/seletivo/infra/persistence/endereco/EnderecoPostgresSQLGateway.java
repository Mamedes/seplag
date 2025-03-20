package com.seletivo.infra.persistence.endereco;

import com.seletivo.domain.endereco.Endereco;
import com.seletivo.domain.endereco.EnderecoGateway;
import com.seletivo.domain.endereco.EnderecoID;
import com.seletivo.domain.pagination.Pagination;
import com.seletivo.domain.pagination.SearchQuery;
import com.seletivo.infra.utils.SpecificationUtils;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.StreamSupport;


@Component
public class EnderecoPostgresSQLGateway implements EnderecoGateway {

    private final EnderecoRepository repository;

    public EnderecoPostgresSQLGateway(final EnderecoRepository repository) {
        this.repository = repository;
    }

    @Override
    public Endereco create(final Endereco aEndereco) {
        return save(aEndereco);
    }

    @Override
    public void deleteById(EnderecoID anId) {
        final Long anIdValue = anId.getValue();
        if(this.repository.existsById(anIdValue)){
            this.repository.deleteById(anIdValue);
        }

    }

    @Override
    public Optional<Endereco> findById(EnderecoID anId) {
        return this.repository.findById(anId.getValue()).map(EnderecoJpaEntity:: toAggregate);
    }

    @Override
    public Endereco update(final Endereco aEndereco) {
        return save(aEndereco);
    }

    @Override
    public Pagination<Endereco> findAll(SearchQuery aQuery) {
        return null;
    }

    @Override
    public List<EnderecoID> existsByIds(Iterable<EnderecoID> ids) {
        List<Long> idValues = StreamSupport.stream(ids.spliterator(), false)
                .map(EnderecoID::getValue)
                .toList();

        List<Long> foundIds = repository.findAllById(idValues)
                .stream()
                .map(EnderecoJpaEntity::getId)
                .toList();

        return foundIds.stream()
                .map(EnderecoID::from)
                .toList();
    }


    private Endereco save(final Endereco aEndereco) {
        return this.repository.save(EnderecoJpaEntity.from(aEndereco)).toAggregate();
    }

    private Specification<EnderecoJpaEntity> assembleSpecification(final String str) {
        final Specification<EnderecoJpaEntity> nameLike = SpecificationUtils.like("nome", str);
        return nameLike;
    }
}
