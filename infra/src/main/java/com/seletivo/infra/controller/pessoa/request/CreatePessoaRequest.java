package com.seletivo.infra.controller.pessoa.request;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDate;

public record CreatePessoaRequest(
        @JsonProperty("nome") String nome,
        @JsonProperty("dataNascimento") LocalDate dataNascimento,
        @JsonProperty("sexo") String sexo,
        @JsonProperty("nomeMae") String nomeMae,
        @JsonProperty("nomePai") String nomePai

) {
}