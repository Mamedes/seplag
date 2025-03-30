package com.seletivo.infra.api.controller.servidorEfetivo.request;

import com.fasterxml.jackson.annotation.JsonProperty;

public record UpdateServidorEfetivoRequest(
        @JsonProperty("matricula") String matricula,
        @JsonProperty("pessoa") UpdatePessoaRequest pessoa

) {
}