package com.seletivo.infra.persistence.unidade;

import com.seletivo.domain.endereco.EnderecoID;
import com.seletivo.domain.unidade.UnidadeEndereco;
import com.seletivo.domain.unidade.UnidadeID;

import jakarta.persistence.*;

@Entity(name = "UnidadeEndereco")
@Table(name = "unidade_endereco")
public class UnidadeEnderecoJpaEntity {
    @Id
    @Column(name = "unid_id", nullable = false)
    private Long unidadeId;

    @Id
    @Column(name = "end_id", nullable = false)
    private Long enderecoId;

    public UnidadeEnderecoJpaEntity() {
    }

    public UnidadeEnderecoJpaEntity(final Long unidadeId, final Long enderecoId) {
        this.unidadeId = unidadeId;
        this.enderecoId = enderecoId;
    }

    public static UnidadeEnderecoJpaEntity from(final UnidadeEndereco unidadeEndereco) {
        return new UnidadeEnderecoJpaEntity(
                unidadeEndereco.getId() != null ?  unidadeEndereco.getId().getValue() : null,
                unidadeEndereco.getEnderecoId() != null ? unidadeEndereco.getEnderecoId().getValue() : null
        );
    }

    public UnidadeEndereco toAggregate() {
        return UnidadeEndereco.with(
                getUnidadeId() != null ? UnidadeID.from(getUnidadeId()) : null,
                EnderecoID.from(getEnderecoId())
        );
    }

    public Long getUnidadeId() {
        return unidadeId;
    }

    public void setUnidadeId(Long unidadeId) {
        this.unidadeId = unidadeId;
    }

    public Long getEnderecoId() {
        return enderecoId;
    }

    public void setEnderecoId(Long enderecoId) {
        this.enderecoId = enderecoId;
    }
}
