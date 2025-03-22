package com.seletivo.infra.api.controller.pessoa.request;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDate;

public record PessoaListResponse(
        @JsonProperty("id") Integer id,
        @JsonProperty("nome") String nome,
        @JsonProperty("dataNascimento") LocalDate dataNascimento,
        @JsonProperty("sexo") String sexo,
        @JsonProperty("nomeMae") String nomeMae,
        @JsonProperty("nomePai") String nomePai

) {
}