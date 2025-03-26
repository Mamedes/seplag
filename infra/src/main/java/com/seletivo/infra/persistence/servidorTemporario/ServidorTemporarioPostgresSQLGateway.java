package com.seletivo.infra.persistence.servidorTemporario;

import com.seletivo.domain.pagination.Pagination;
import com.seletivo.domain.pagination.SearchQuery;
import com.seletivo.domain.pessoa.PessoaID;
import com.seletivo.domain.servidorTemporario.ServidorTemporario;
import com.seletivo.domain.servidorTemporario.ServidorTemporarioGateway;
import com.seletivo.infra.utils.SpecificationUtils;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;


@Component
public class ServidorTemporarioPostgresSQLGateway implements ServidorTemporarioGateway {

    private final ServidorTemporarioRepository repository;

    public ServidorTemporarioPostgresSQLGateway(final ServidorTemporarioRepository repository) {
        this.repository = repository;
    }

    @Override
    public ServidorTemporario create(final ServidorTemporario aServidorTemporario) {
        return save(aServidorTemporario);
    }

    @Override
    public void deleteById(PessoaID anId) {
        final Long anIdValue = anId.getValue();
        if (this.repository.existsById(anIdValue)) {
            this.repository.deleteById(anIdValue);
        }
    }

    @Override
    public Optional<ServidorTemporario> findById(PessoaID anId) {
        return this.repository.findById(anId.getValue())
                .map(ServidorTemporarioJpaEntity::toAggregate);
    }

    @Override
    public ServidorTemporario update(ServidorTemporario aPessoa) {
        return null;
    }

    @Override
    public Pagination<ServidorTemporario> findAll(SearchQuery aQuery) {
        return null;
    }

    @Override
    public List<PessoaID> existsByIds(Iterable<PessoaID> ids) {
        return List.of();
    }

    private ServidorTemporario save(final ServidorTemporario aServidorTemporario) {
        return this.repository.save(ServidorTemporarioJpaEntity.from(aServidorTemporario))
                .toAggregate();
    }

    private Specification<ServidorTemporarioJpaEntity> assembleSpecification(final String str) {
        final Specification<ServidorTemporarioJpaEntity> nameLike =
                SpecificationUtils.like("nome", str);
        return nameLike;
    }
}
