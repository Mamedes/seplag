package com.seletivo.infra.persistence.unidade;

import com.seletivo.domain.pagination.Pagination;
import com.seletivo.domain.pagination.SearchQuery;
import com.seletivo.domain.unidade.Unidade;
import com.seletivo.domain.unidade.UnidadeGateway;
import com.seletivo.domain.unidade.UnidadeID;
import jakarta.persistence.*;

import java.util.List;
import java.util.Optional;

@Entity(name = "Unidade")
@Table(name = "unidade")
public class UnidadeJpaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "unidade_seq")
    @SequenceGenerator(name = "unidade_seq", sequenceName = "unidade_id_seq", allocationSize = 1)
    @Column(name = "unid_id", nullable = false, updatable = false)
    private Long id;

    @Column(name = "unid_nome", nullable = false)
    private String nome;

    @Column(name = "unid_sigla", nullable = false, unique = true)
    private String sigla;

    public UnidadeJpaEntity() {
    }

    public UnidadeJpaEntity(final Long id, final String nome, final String sigla) {
        this.id = id;
        this.nome = nome;
        this.sigla = sigla;
    }

    public static UnidadeJpaEntity from(final Unidade unidade) {
        return new UnidadeJpaEntity(
                unidade.getId() != null ? unidade.getId().getValue() : null,
                unidade.getNome(),
                unidade.getSigla()
        );
    }

    public Unidade toAggregate() {
        return Unidade.with(
                getId() != null ? UnidadeID.from(getId()) : null,
                getNome(),
                getSigla()
        );
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

  }
