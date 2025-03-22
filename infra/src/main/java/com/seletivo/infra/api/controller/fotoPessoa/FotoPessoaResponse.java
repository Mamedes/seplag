package com.seletivo.infra.api.controller.fotoPessoa;

import java.time.LocalDate;
import com.fasterxml.jackson.annotation.JsonProperty;

public record FotoPessoaResponse(
        @JsonProperty("id") Long id,
        @JsonProperty("pessoaID") Long pessoaID,
        @JsonProperty("data") LocalDate data,
        @JsonProperty("bucket") String bucket,
        @JsonProperty("linkTemporario") String linkTemporario,
        @JsonProperty("hash") String hash

) {
}
