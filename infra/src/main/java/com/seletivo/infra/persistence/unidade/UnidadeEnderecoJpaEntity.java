package com.seletivo.infra.persistence.unidade;

import com.seletivo.domain.endereco.EnderecoID;
import com.seletivo.domain.pagination.Pagination;
import com.seletivo.domain.pagination.SearchQuery;
import com.seletivo.domain.unidade.UnidadeEndereco;
import com.seletivo.domain.unidade.UnidadeEnderecoGateway;
import com.seletivo.domain.unidade.UnidadeID;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import java.util.Optional;


@Entity(name = "UnidadeEndereco")
@Table(name = "unidade_endereco")
@IdClass(UnidadeEnderecoJpaEntity.UnidadeEnderecoId.class)
public class UnidadeEnderecoJpaEntity  {
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
                unidadeEndereco.getUnidadeId() != null ?  unidadeEndereco.getUnidadeId().getValue() : null,
              unidadeEndereco.getEnderecoId().getValue()
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
    public static class UnidadeEnderecoId implements Serializable {
        private Long unidadeId;
        private Long enderecoId;

        public UnidadeEnderecoId() {
        }

        public UnidadeEnderecoId(Long unidadeId, Long enderecoId) {
            this.unidadeId = unidadeId;
            this.enderecoId = enderecoId;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            UnidadeEnderecoId that = (UnidadeEnderecoId) o;
            return Objects.equals(unidadeId, that.unidadeId) &&
                    Objects.equals(enderecoId, that.enderecoId);
        }

        @Override
        public int hashCode() {
            return Objects.hash(unidadeId, enderecoId);
        }
    }


}
