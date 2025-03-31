package com.seletivo.infra.api.controller.cidade.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.seletivo.application.cidade.fetch.list.CidadeListOutput;

public record CidadeListResponse(
        @JsonProperty("id") Long id,
        @JsonProperty("nome") String nome,
        @JsonProperty("uf") String uf
) {

    public static CidadeListResponse from(final CidadeListOutput output) {
        return new CidadeListResponse(
                output.id().getValue(),
                output.nome(),
                output.uf()
        );
    }
}