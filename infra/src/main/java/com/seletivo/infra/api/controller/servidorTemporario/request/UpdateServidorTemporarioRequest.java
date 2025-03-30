package com.seletivo.infra.api.controller.servidorTemporario.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.seletivo.infra.api.controller.servidorEfetivo.request.UpdatePessoaRequest;

import java.time.LocalDate;

public record UpdateServidorTemporarioRequest(
        @JsonProperty("dataAdmissao")
        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy") LocalDate dataAdmissao,
        @JsonProperty("dataDemissao")
        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")LocalDate dataDemissao,
        @JsonProperty("pessoa") UpdatePessoaRequest pessoa
) {
}