package com.seletivo.domain.servidorEfetivo;

public record ServidorEnderecoDomainOutput(
        String nomeServidor,
        String nomeUnidade,
        String logradouro,
        Integer numero,
        String bairro
) {
}
