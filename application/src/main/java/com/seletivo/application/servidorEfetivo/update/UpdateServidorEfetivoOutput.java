package com.seletivo.application.servidorEfetivo.update;

import com.seletivo.domain.servidorEfetivo.ServidorEfetivo;

public record UpdateServidorEfetivoOutput(
        Long id
) {

    public static UpdateServidorEfetivoOutput from(final Long anId) {
        return new UpdateServidorEfetivoOutput(anId);
    }

    public static UpdateServidorEfetivoOutput from(final ServidorEfetivo aServidorEfetivo) {
        return new UpdateServidorEfetivoOutput(aServidorEfetivo.getId().getValue());
    }
}