package com.seletivo.application.servidorEfetivo;

public record ServidorEnderecoOutput(
        String nomeServidor,
        String nomeUnidade,
        String logradouro,
        Integer numero,
        String bairro
) {
}