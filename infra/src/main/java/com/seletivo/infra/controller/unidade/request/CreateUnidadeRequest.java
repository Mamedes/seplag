package com.seletivo.infra.controller.unidade.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.seletivo.domain.endereco.EnderecoID;

import java.util.List;

public record CreateUnidadeRequest(
        @JsonProperty("nome") String nome,
        @JsonProperty("sigla") String sigla,
        @JsonProperty("enderecoIds") List<Long> enderecoIds


) {
}