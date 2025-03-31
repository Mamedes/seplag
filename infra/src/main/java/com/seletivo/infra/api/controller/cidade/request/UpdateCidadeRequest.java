package com.seletivo.infra.api.controller.cidade.request;

public record UpdateCidadeRequest(
        String nome,
        String uf
) {
}