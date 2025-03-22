package com.seletivo.infra.api.controller.servidorEfetivo.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.seletivo.infra.api.controller.pessoa.request.CreatePessoaRequest;


public record CreateServidorEfetivoRequest(
        @JsonProperty("matricula") String matricula,
        @JsonProperty("pessoa") CreatePessoaRequest pessoa


) {
}