package com.seletivo.infra.api.controller.pessoa;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDate;

public record PessoaResponse(
        @JsonProperty("id") Long id,
        @JsonProperty("nome") String nome,
        @JsonProperty("dataNascimento") LocalDate data_nascimento,
        @JsonProperty("sexo") String sexo,
        @JsonProperty("nomeMae") String nomeMae,
        @JsonProperty("nomePai") String nomePai

) {
}