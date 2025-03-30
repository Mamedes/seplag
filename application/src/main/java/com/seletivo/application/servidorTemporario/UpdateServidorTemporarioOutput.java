package com.seletivo.application.servidorTemporario;

import com.seletivo.domain.servidorTemporario.ServidorTemporario;

public record UpdateServidorTemporarioOutput(
        Long id
) {

    public static UpdateServidorTemporarioOutput from(final Long anId) {
        return new UpdateServidorTemporarioOutput(anId);
    }

    public static UpdateServidorTemporarioOutput from(final ServidorTemporario aServidorTemporario) {
        return new UpdateServidorTemporarioOutput(aServidorTemporario.getId().getValue());
    }
}