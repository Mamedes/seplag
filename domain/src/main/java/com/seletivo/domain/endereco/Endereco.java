package com.seletivo.domain.endereco;

import com.seletivo.domain.AggregateRoot;
import com.seletivo.domain.cidade.CidadeID;
import com.seletivo.domain.validation.ValidationHandler;

public class Endereco extends AggregateRoot<EnderecoID> implements Cloneable{

    private  String tipoLogradouro;
    private  String logradouro;
    private  Integer numero;
    private  String bairro;
    private  CidadeID cidadeId;

    public Endereco(EnderecoID id, String tipoLogradouro, String logradouro, Integer numero, String bairro, CidadeID cidadeId) {
        super(id);
        this.tipoLogradouro = tipoLogradouro;
        this.logradouro = logradouro;
        this.numero = numero;
        this.bairro = bairro;
        this.cidadeId = cidadeId;
    }

    public static Endereco newEndereco(final String tipoLogradouro, final String logradouro, final Integer numero, final String bairro, final CidadeID cidadeId) {

        return new Endereco(null,

                tipoLogradouro, logradouro, numero, bairro, cidadeId);
    }

    public static  Endereco with(final EnderecoID anId, final String tipoLogradouro, final String logradouro, final Integer numero, final String bairro, final CidadeID cidadeId) {

        return new Endereco(anId, tipoLogradouro, logradouro, numero, bairro, cidadeId);
    }

    public static Endereco with(Endereco aEndereco) {

        return new Endereco(aEndereco.getId(), aEndereco.tipoLogradouro, aEndereco.logradouro, aEndereco.numero, aEndereco.bairro, aEndereco.cidadeId);
    }


    @Override
    public void validate(ValidationHandler handler) {

    }
    public Endereco update(
            final String aTipoLogradouro,
            final String aLogradouro,
            final Integer aNumero,
            final String aBairro,
            final CidadeID aCidadeId
    ) {
        this.tipoLogradouro = aTipoLogradouro;
        this.logradouro = aLogradouro;
        this.numero = aNumero;
        this.bairro = aBairro;
        this.cidadeId = aCidadeId;
        return this;
    }

    public EnderecoID getId() {
        return id;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public Integer getNumero() {
        return numero;
    }

    public String getBairro() {
        return bairro;
    }

    public CidadeID getCidadeId() {
        return cidadeId;
    }

    public String getTipoLogradouro() {
        return tipoLogradouro;
    }
}
