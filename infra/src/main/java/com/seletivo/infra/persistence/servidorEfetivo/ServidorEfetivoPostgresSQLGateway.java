package com.seletivo.infra.persistence.servidorEfetivo;

import com.seletivo.domain.pagination.Pagination;
import com.seletivo.domain.pagination.SearchQuery;
import com.seletivo.domain.pessoa.PessoaID;
import com.seletivo.domain.servidorEfetivo.ServidorEfetivo;
import com.seletivo.domain.servidorEfetivo.ServidorEfetivoGateway;
import com.seletivo.domain.servidorEfetivo.ServidorEfetivoPorUnidade;
import com.seletivo.domain.servidorEfetivo.ServidorEnderecoDomain;
import com.seletivo.infra.utils.SpecificationUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


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
        final Long anIdValue = anId.getValue();
        if (this.repository.existsById(anIdValue)) {
            this.repository.deleteById(anIdValue);
        }

    }


    @Override
    public Optional<ServidorEfetivo> findById(PessoaID anId) {
        return this.repository.findById(anId.getValue()).map(ServidorEfetivoJpaEntity::toAggregate);
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

    @Override
    public Pagination<ServidorEnderecoDomain> searchServidorEndereco(SearchQuery searchQuery) {
        Pageable pageable = PageRequest.of(searchQuery.page(), searchQuery.perPage(),
                Sort.by(Sort.Direction.fromString(searchQuery.direction()), searchQuery.sort()));
        Page<ServidorEnderecoProjection> page =
                repository.findServidorEnderecoByNome(searchQuery.terms(), pageable);

        List<ServidorEnderecoDomain> items =
                page.getContent().stream().map(this::mapToDomain).collect(Collectors.toList());

        return new Pagination<>(page.getNumber(), page.getSize(), page.getTotalElements(), items);

    }

    private ServidorEfetivo save(final ServidorEfetivo aServidorEfetivo) {
        return this.repository.save(ServidorEfetivoJpaEntity.from(aServidorEfetivo)).toAggregate();
    }



    private ServidorEnderecoDomain mapToDomain(ServidorEnderecoProjection projection) {
        return new ServidorEnderecoDomain(projection.getNomeServidor(), projection.getNomeUnidade(),
                projection.getLogradouro(), projection.getNumero(), projection.getBairro());
    }

    @Override
    public Pagination<ServidorEfetivoPorUnidade> findServidoresByUnidade(SearchQuery searchQuery,
            Long unidadeID) {
        Pageable pageable = PageRequest.of(searchQuery.page(), searchQuery.perPage(),
                Sort.by(Sort.Direction.fromString(searchQuery.direction()), searchQuery.sort()));

        Page<ServidorEfetivoByUnidadeProjection> page =
                repository.findServidoresByUnidade(searchQuery.terms(), unidadeID, pageable);

        List<ServidorEfetivoPorUnidade> outputs = page.getContent().stream()
                .map(projection -> new ServidorEfetivoPorUnidade(projection.getNome(),
                        projection.getDataNascimento(), projection.getNomeUnidade(),
                        projection.getBucketFoto()))
                .collect(Collectors.toList());

        return new Pagination<>(page.getNumber(), page.getSize(), page.getTotalElements(), outputs);
    }

    private Specification<ServidorEfetivoJpaEntity> assembleSpecification(final String str) {
        final Specification<ServidorEfetivoJpaEntity> nameLike =
                SpecificationUtils.like("nome", str);
        return nameLike;
    }

}
