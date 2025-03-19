package com.seletivo.infra.controller.unidade.request;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDate;

public record UnidadeResponse(
        @JsonProperty("id") Long id,
        @JsonProperty("nome") String nome,
        @JsonProperty("sigla") String sigla


) {
}