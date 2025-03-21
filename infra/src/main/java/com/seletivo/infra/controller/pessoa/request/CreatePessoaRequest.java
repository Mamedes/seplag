package com.seletivo.infra.controller.pessoa.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDate;

public record CreatePessoaRequest(
        @JsonProperty("nome") String nome,
        @JsonProperty("dataNascimento")
        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")  LocalDate dataNascimento,
        @JsonProperty("sexo") String sexo,
        @JsonProperty("nomeMae") String nomeMae,
        @JsonProperty("nomePai") String nomePai

) {
}