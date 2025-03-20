package com.seletivo.infra.controller.servidorEfetivo.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.seletivo.infra.controller.pessoa.PessoaResponse;

public record ServidorEfetivoResponse(@JsonProperty("id") Long id,
                @JsonProperty("matricula") String matricula,
                @JsonProperty("pessoa") PessoaResponse pessoa

) {
}
