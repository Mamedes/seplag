package com.seletivo.infra.api.controller.unidade.request;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public record UpdateUnidadeRequest(
        @JsonProperty("nome") String nome,
        @JsonProperty("sigla") String sigla,
        @JsonProperty("enderecoIds") List<Long> enderecoIds


) {
}