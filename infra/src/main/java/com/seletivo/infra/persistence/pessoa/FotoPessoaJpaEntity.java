package com.seletivo.infra.persistence.pessoa;


import com.seletivo.domain.pessoa.FotoID;
import com.seletivo.domain.pessoa.FotoPessoa;
import com.seletivo.domain.pessoa.PessoaID;
import jakarta.persistence.*;

import java.time.LocalDate;


@Entity(name = "FotoPessoa")
@Table(name = "foto_pessoa")
public class FotoPessoaJpaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "foto_pessoa_seq")
    @SequenceGenerator(name = "foto_pessoa_seq", sequenceName = "foto_pessoa_id_seq", allocationSize = 1)
    @Column(name = "fot_id", nullable = false, updatable = false)
    private Long id;

    @Column(name = "pes_id", nullable = false)
    private Long pessoaId;

    @Column(name = "fot_data", nullable = false)
    private LocalDate data;

    @Column(name = "fot_bucket", nullable = false)
    private String bucket;

    @Column(name = "fot_hash", nullable = false)
    private String hash;

    public FotoPessoaJpaEntity() {
    }

    public FotoPessoaJpaEntity(final Long id, final Long pessoaId, final LocalDate data, final String bucket, final String hash) {
        this.id = id;
        this.pessoaId = pessoaId;
        this.data = data;
        this.bucket = bucket;
        this.hash = hash;
    }

    public static FotoPessoaJpaEntity from(final FotoPessoa aFotoPessoa) {
        return new FotoPessoaJpaEntity(
                aFotoPessoa.getId() != null ? aFotoPessoa.getId().getValue() : null,
                aFotoPessoa.getPessoaID() != null ? aFotoPessoa.getPessoaID().getValue() : null,
                aFotoPessoa.getData(),
                aFotoPessoa.getBucket(),
                aFotoPessoa.getHash()
        );
    }

    public FotoPessoa toAggregate() {
        return FotoPessoa.with(
                getId() != null ? FotoID.from(getId()) : null,
                getPessoaId() != null ? PessoaID.from(getPessoaId()) : null,
                getData(),
                getBucket(),
                getHash()
        );
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPessoaId() {
        return pessoaId;
    }

    public void setPessoaId(Long pessoaId) {
        this.pessoaId = pessoaId;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public String getBucket() {
        return bucket;
    }

    public void setBucket(String bucket) {
        this.bucket = bucket;
    }

    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }
}