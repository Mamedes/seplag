package com.seletivo.infra.persistence.pessoa;
import com.seletivo.domain.endereco.EnderecoID;
import com.seletivo.domain.pessoa.PessoaEndereco;
import com.seletivo.domain.pessoa.PessoaID;

import jakarta.persistence.*;

@Entity(name = "PessoaEndereco")
@Table(name = "pessoa_endereco")

public class PessoaEnderecoJpaEntity {

    @Id
    @Column(name = "pes_id", nullable = false)
    private Long pessoaId;

    @Id
    @Column(name = "end_id", nullable = false)
    private Long enderecoId;

    public PessoaEnderecoJpaEntity() {
    }

    public PessoaEnderecoJpaEntity(final Long pessoaId, final Long enderecoId) {
        this.pessoaId = pessoaId;
        this.enderecoId = enderecoId;
    }

    public static PessoaEnderecoJpaEntity from(final PessoaEndereco pessoaEndereco) {
        return new PessoaEnderecoJpaEntity(
                pessoaEndereco.getPessoaId() != null ? pessoaEndereco.getPessoaId().getValue() : null,
                pessoaEndereco.getEnderecoId() != null ? pessoaEndereco.getEnderecoId().getValue() : null
        );
    }

    public PessoaEndereco toAggregate() {
        return PessoaEndereco.with(
                PessoaID.from(getPessoaId()),
                EnderecoID.from(getEnderecoId())
        );
    }

    public Long getEnderecoId() {
        return enderecoId;
    }

    public void setEnderecoId(Long enderecoId) {
        this.enderecoId = enderecoId;
    }

    public Long getPessoaId() {
        return pessoaId;
    }

    public void setPessoaId(Long pessoaId) {
        this.pessoaId = pessoaId;
    }
}
