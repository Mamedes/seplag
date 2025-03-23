package com.seletivo.infra.api.controller.servidorEfetivo.response;

import com.seletivo.application.servidorEfetivo.ServidorEnderecoOutput;

public record ServidorEnderecoResponse(
        String nomeServidor,
        String nomeUnidade,
        String logradouro,
        Integer numero,
        String bairro
) {
    public static ServidorEnderecoResponse from(ServidorEnderecoOutput output) {
        return new ServidorEnderecoResponse(
                output.nomeServidor(),
                output.nomeUnidade(),
                output.logradouro(),
                output.numero(),
                output.bairro()

        );
    }
}