package com.seletivo.infra.api.controller.servidorEfetivo.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.time.LocalDate;

public record UpdatePessoaRequest(
        @JsonProperty("id") Long id,
        @JsonProperty("nome") String nome,
        @JsonProperty("dataNascimento")
        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy") LocalDate dataNascimento,
        @JsonProperty("sexo") String sexo,
        @JsonProperty("nomeMae") String nomeMae,
        @JsonProperty("nomePai") String nomePai
) {}