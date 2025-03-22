package com.seletivo.infra.api.controller.fotoPessoa.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDate;

public record PessoaFotoListResponse(
        @JsonProperty("id") Long id,
        @JsonProperty("pessoaID") Long pessoaID,
        @JsonProperty("data")
        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
        LocalDate data,
        @JsonProperty("bucket") String bucket,
        @JsonProperty("hash") String hash
) {
}
