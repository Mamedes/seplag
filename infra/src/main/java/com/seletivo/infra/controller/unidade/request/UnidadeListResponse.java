package com.seletivo.infra.controller.unidade.request;

import com.fasterxml.jackson.annotation.JsonProperty;

public record UnidadeListResponse(
        @JsonProperty("id") Integer id,
        @JsonProperty("nome") String nome,
        @JsonProperty("sigla") String sigla
) {
}