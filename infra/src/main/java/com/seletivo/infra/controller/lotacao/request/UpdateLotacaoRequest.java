package com.seletivo.infra.controller.lotacao.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDate;

public record UpdateLotacaoRequest(
        @JsonProperty("pessoaId")
        Long pessoaId,
        @JsonProperty("unidadeId")
        Long unidadeId,
        @JsonProperty("dataLotacao")
        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
        LocalDate dataLotacao,
        @JsonProperty("dataRemocao")
        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy") LocalDate dataRemocao,
        @JsonProperty("portaria") Long portaria

) {
}

