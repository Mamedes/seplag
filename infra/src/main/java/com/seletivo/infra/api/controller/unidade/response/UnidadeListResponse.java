package com.seletivo.infra.api.controller.unidade.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public record UnidadeListResponse(
        @JsonProperty("id") Long id,
        @JsonProperty("nome") String nome,
        @JsonProperty("sigla") String sigla
) {
}