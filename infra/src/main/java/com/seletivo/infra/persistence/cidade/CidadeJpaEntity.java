package com.seletivo.infra.persistence.cidade;

import com.seletivo.domain.cidade.Cidade;
import com.seletivo.domain.cidade.CidadeID;
import jakarta.persistence.*;


@Entity(name = "Cidade")
@Table(name = "cidade")
public class CidadeJpaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "cidade_seq")
    @SequenceGenerator(name = "cidade_seq", sequenceName = "cidade_id_seq", allocationSize = 1)
    @Column(name = "cid_id", nullable = false, updatable = false)
    private Long id;

    @Column(name = "cid_nome", nullable = false)
    private String nome;

    @Column(name = "cid_uf", nullable = false, length = 2)
    private String uf;

    public CidadeJpaEntity() {
    }

    public CidadeJpaEntity(final Long id, final String nome, final String uf) {
        this.id = id;
        this.nome = nome;
        this.uf = uf;
    }

    public static CidadeJpaEntity from(final Cidade cidade) {
        return new CidadeJpaEntity(
                cidade.getId() != null ? cidade.getId().getValue() : null,
                cidade.getNome(),
                cidade.getUf()
        );
    }

    public Cidade toAggregate() {
        return Cidade.with(
                getId() != null ? CidadeID.from(getId()) : null,
                getNome(),
                getUf()
        );
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }
}