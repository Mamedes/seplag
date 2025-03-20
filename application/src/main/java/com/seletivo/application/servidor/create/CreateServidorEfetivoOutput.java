package com.seletivo.application.servidor.create;


import com.seletivo.domain.servidor.ServidorEfetivo;

public record CreateServidorEfetivoOutput(
        Long id
) {

    public static CreateServidorEfetivoOutput from(final Long anId) {
        return new CreateServidorEfetivoOutput(anId);
    }

    public static CreateServidorEfetivoOutput from(final ServidorEfetivo aServidorEfetivo) {
        return new CreateServidorEfetivoOutput(aServidorEfetivo.getId().getValue());
    }
}
