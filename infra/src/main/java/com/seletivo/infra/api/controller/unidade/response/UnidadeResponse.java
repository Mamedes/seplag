package com.seletivo.infra.api.controller.unidade.response;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDate;

public record UnidadeResponse(
        @JsonProperty("id") Long id,
        @JsonProperty("nome") String nome,
        @JsonProperty("sigla") String sigla


) {
}