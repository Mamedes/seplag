package com.seletivo.infra.persistence.servidor;

import com.seletivo.domain.pessoa.PessoaID;
import com.seletivo.domain.servidor.ServidorEfetivo;
import jakarta.persistence.*;

@Entity(name = "ServidorEfetivo")
@Table(name = "servidor_efetivo")
public class ServidorEfetivoJpaEntity {

    @Id
    @Column(name = "pes_id", nullable = false, updatable = false)
    private Long pessoaId;

    @Column(name = "se_matricula", nullable = false, unique = true)
    private String matricula;

    public ServidorEfetivoJpaEntity() {
    }

    public ServidorEfetivoJpaEntity(final Long pessoaId, final String matricula) {
        this.pessoaId = pessoaId;
        this.matricula = matricula;
    }

    public static ServidorEfetivoJpaEntity from(final ServidorEfetivo servidorEfetivo) {
        return new ServidorEfetivoJpaEntity(
                servidorEfetivo.getId() != null ? servidorEfetivo.getId().getValue() : null,
                servidorEfetivo.getMatricula()
        );
    }

    public ServidorEfetivo toAggregate() {
        return ServidorEfetivo.with(
                getPessoaId() != null ? PessoaID.from(getPessoaId()) : null,
                getMatricula()
        );
    }

    public Long getPessoaId() {
        return pessoaId;
    }

    public void setPessoaId(Long pessoaId) {
        this.pessoaId = pessoaId;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }
}