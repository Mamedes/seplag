package com.seletivo.infra.persistence.endereco;

import com.seletivo.domain.endereco.Endereco;
import com.seletivo.domain.endereco.EnderecoID;
import com.seletivo.domain.cidade.CidadeID;
import jakarta.persistence.*;

@Entity(name = "Endereco")
@Table(name = "endereco")
public class EnderecoJpaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "endereco_seq")
    @SequenceGenerator(name = "endereco_seq", sequenceName = "endereco_id_seq", allocationSize = 1)
    @Column(name = "end_id", nullable = false, updatable = false)
    private Long id;

    @Column(name = "end_tipo_logradouro")
    private String tipoLogradouro;

    @Column(name = "end_logradouro")
    private String logradouro;

    @Column(name = "end_numero")
    private Integer numero;

    @Column(name = "end_bairro")
    private String bairro;

    @Column(name = "cid_id", nullable = false)
    private Long cidadeId;

    public EnderecoJpaEntity() {
    }

    public EnderecoJpaEntity(final Long id, final String tipoLogradouro, final String logradouro, final Integer numero, final String bairro, final Long cidadeId) {
        this.id = id;
        this.tipoLogradouro = tipoLogradouro;
        this.logradouro = logradouro;
        this.numero = numero;
        this.bairro = bairro;
        this.cidadeId = cidadeId;
    }

    public static EnderecoJpaEntity from(final Endereco endereco) {
        return new EnderecoJpaEntity(
                endereco.getId() != null ? endereco.getId().getValue() : null,
                endereco.getTipoLogradouro(),
                endereco.getLogradouro(),
                endereco.getNumero(),
                endereco.getBairro(),
                endereco.getCidadeId() != null ? endereco.getCidadeId().getValue() : null
        );
    }

    public Endereco toAggregate() {
        return Endereco.with(
                getId() != null ? EnderecoID.from(getId()) : null,
                getTipoLogradouro(),
                getLogradouro(),
                getNumero(),
                getBairro(),
                getCidadeId() != null ? CidadeID.from(getCidadeId()) : null
        );
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTipoLogradouro() {
        return tipoLogradouro;
    }

    public void setTipoLogradouro(String tipoLogradouro) {
        this.tipoLogradouro = tipoLogradouro;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public Long getCidadeId() {
        return cidadeId;
    }

    public void setCidadeId(Long cidadeId) {
        this.cidadeId = cidadeId;
    }
}
