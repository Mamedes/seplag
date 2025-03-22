package com.seletivo.infra.api.controller.servidorTemporario.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.seletivo.infra.api.controller.pessoa.PessoaResponse;

import java.time.LocalDate;

public record ServidorTemporarioResponse(@JsonProperty("id") Long id,
                                         @JsonProperty("dataAdmissao") LocalDate dataAdmissao,
                                         @JsonProperty("dataDemissao") LocalDate dataDemissao,
                                         @JsonProperty("pessoa") PessoaResponse pessoa

) {
}
