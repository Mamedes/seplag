package com.seletivo.infra.api.controller.servidorTemporario.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.seletivo.infra.api.controller.pessoa.request.CreatePessoaRequest;

import java.time.LocalDate;


public record CreateServidorTemporarioRequest(
        @JsonProperty("dataAdmissao")
        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
        LocalDate dataAdmissao,
        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
        @JsonProperty("dataDemissao")
        LocalDate dataDemissao,
        @JsonProperty("pessoa") CreatePessoaRequest pessoa


) {
}