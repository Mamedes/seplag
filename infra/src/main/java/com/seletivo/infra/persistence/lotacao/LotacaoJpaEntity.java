package com.seletivo.infra.persistence.lotacao;

import com.seletivo.domain.lotacao.Lotacao;
import com.seletivo.domain.lotacao.LotacaoID;
import com.seletivo.domain.pessoa.PessoaID;
import com.seletivo.domain.unidade.UnidadeID;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity(name = "Lotacao")
@Table(name = "lotacao")
public class LotacaoJpaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "lotacao_seq")
    @SequenceGenerator(name = "lotacao_seq", sequenceName = "lotacao_id_seq", allocationSize = 1)
    @Column(name = "lot_id", nullable = false, updatable = false)
    private Long id;

    @Column(name = "pes_id", nullable = false)
    private Long pessoaId;

    @Column(name = "unid_id", nullable = false)
    private Long unidadeId;

    @Column(name = "lot_data_lotacao", nullable = false)
    private LocalDate dataLotacao;

    @Column(name = "lot_data_remocao")
    private LocalDate dataRemocao;

    @Column(name = "lot_portaria")
    private String portaria;

    public LotacaoJpaEntity() {
    }

    public LotacaoJpaEntity(final Long id, final Long pessoaId, final Long unidadeId, final LocalDate dataLotacao, final LocalDate dataRemocao, final String portaria) {
        this.id = id;
        this.pessoaId = pessoaId;
        this.unidadeId = unidadeId;
        this.dataLotacao = dataLotacao;
        this.dataRemocao = dataRemocao;
        this.portaria = portaria;
    }

    public static LotacaoJpaEntity from(final Lotacao lotacao) {
        return new LotacaoJpaEntity(
                lotacao.getId() != null ? lotacao.getId().getValue() : null,
                lotacao.getPessoaId() != null ? lotacao.getPessoaId().getValue() : null,
                lotacao.getUnidadeId() != null ? lotacao.getUnidadeId().getValue() : null,
                lotacao.getDataLotacao(),
                lotacao.getDataRemocao(),
                lotacao.getPortaria()
        );
    }

    public Lotacao toAggregate() {
        return Lotacao.with(
                getId() != null ? LotacaoID.from(getId()) : null,
                getPessoaId() != null ? PessoaID.from(getPessoaId()) : null,
                getUnidadeId() != null ? UnidadeID.from(getUnidadeId()) : null,
                getDataLotacao(),
                getDataRemocao(),
                getPortaria()
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

    public Long getUnidadeId() {
        return unidadeId;
    }

    public void setUnidadeId(Long unidadeId) {
        this.unidadeId = unidadeId;
    }

    public LocalDate getDataLotacao() {
        return dataLotacao;
    }

    public void setDataLotacao(LocalDate dataLotacao) {
        this.dataLotacao = dataLotacao;
    }

    public String getPortaria() {
        return portaria;
    }

    public void setPortaria(String portaria) {
        this.portaria = portaria;
    }

    public LocalDate getDataRemocao() {
        return dataRemocao;
    }

    public void setDataRemocao(LocalDate dataRemocao) {
        this.dataRemocao = dataRemocao;
    }
}
