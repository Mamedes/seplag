package com.seletivo.infra.api.controller.servidorEfetivo.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.seletivo.infra.api.controller.pessoa.PessoaResponse;

import java.time.LocalDate;

public record ServidorEfetivoByUnidadeResponse(@JsonProperty("nome") String nome,
                                               @JsonProperty("idade") int idade,
                                               @JsonProperty("nomeUnidade") String nomeUnidade,
                                               @JsonProperty("presignedUrl") String presignedUrl

) {
}
