package com.seletivo.infra.persistence.servidor;

import com.seletivo.domain.pessoa.PessoaID;
import com.seletivo.domain.servidor.ServidorTemporario;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity(name = "ServidorTemporario")
@Table(name = "servidor_temporario")
public class ServidorTemporarioJpaEntity {


    @Id
    @Column(name = "pes_id", nullable = false, updatable = false)
    private Long pessoaId;

    @Column(name = "st_data_admissao")
    private LocalDate dataAdmissao;

    @Column(name = "st_data_demissao")
    private LocalDate dataDemissao;

    public ServidorTemporarioJpaEntity() {
    }

    public ServidorTemporarioJpaEntity(final Long pessoaId, final LocalDate dataAdmissao, final LocalDate dataDemissao) {
        this.pessoaId = pessoaId;
        this.dataAdmissao = dataAdmissao;
        this.dataDemissao = dataDemissao;
    }

    public static ServidorTemporarioJpaEntity from(final ServidorTemporario servidorTemporario) {
        return new ServidorTemporarioJpaEntity(
                servidorTemporario.getId() != null ? servidorTemporario.getId().getValue() : null,
                servidorTemporario.getDataAdmissao(),
                servidorTemporario.getDataDemissao()
        );
    }

    public ServidorTemporario toAggregate() {
        return ServidorTemporario.with(
                getPessoaId() != null ? PessoaID.from(getPessoaId()) : null,
                getDataAdmissao(),
                getDataDemissao()
        );
    }

    public Long getPessoaId() {
        return pessoaId;
    }

    public void setPessoaId(Long pessoaId) {
        this.pessoaId = pessoaId;
    }

    public LocalDate getDataAdmissao() {
        return dataAdmissao;
    }

    public void setDataAdmissao(LocalDate dataAdmissao) {
        this.dataAdmissao = dataAdmissao;
    }

    public LocalDate getDataDemissao() {
        return dataDemissao;
    }

    public void setDataDemissao(LocalDate dataDemissao) {
        this.dataDemissao = dataDemissao;
    }
}
