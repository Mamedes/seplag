package com.seletivo.domain.servidorEfetivo;

public class ServidorEnderecoDomain {
    private final String nomeServidor;
    private final String nomeUnidade;
    private final String logradouro;
    private final Integer numero;
    private final String bairro;

    public ServidorEnderecoDomain(String nomeServidor, String nomeUnidade, String logradouro, Integer numero, String bairro) {
        this.nomeServidor = nomeServidor;
        this.nomeUnidade = nomeUnidade;
        this.logradouro = logradouro;
        this.numero = numero;
        this.bairro = bairro;
    }

    public String getNomeServidor() {
        return nomeServidor;
    }

    public String getNomeUnidade() {
        return nomeUnidade;
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
}