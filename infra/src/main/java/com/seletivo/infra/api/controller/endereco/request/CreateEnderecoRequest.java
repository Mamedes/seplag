package com.seletivo.infra.api.controller.endereco.request;

import com.fasterxml.jackson.annotation.JsonProperty;

public record CreateEnderecoRequest(
        @JsonProperty("tipoLogradouro") String tipoLogradouro,
        @JsonProperty("logradouro") String logradouro,
        @JsonProperty("numero") Integer numero,
        @JsonProperty("bairro") String bairro,
        @JsonProperty("cidadeId") Long cidadeId

) {
}

