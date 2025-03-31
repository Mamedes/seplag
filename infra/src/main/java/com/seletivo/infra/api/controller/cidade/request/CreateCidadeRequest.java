package com.seletivo.infra.api.controller.cidade.request;

public record CreateCidadeRequest(
        String nome,
        String uf
) {
}