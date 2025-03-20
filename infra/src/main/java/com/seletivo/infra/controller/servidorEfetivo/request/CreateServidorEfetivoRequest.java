package com.seletivo.infra.controller.servidorEfetivo.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.seletivo.infra.controller.pessoa.request.CreatePessoaRequest;


public record CreateServidorEfetivoRequest(
        @JsonProperty("matricula") String matricula,
        @JsonProperty("pessoa") CreatePessoaRequest pessoa


) {
}