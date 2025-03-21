package com.seletivo.application.servidorTemporario.create;

import com.seletivo.domain.servidorTemporario.ServidorTemporario;

public record CreateServidorTemporarioOutput(
        Long id
) {

    public static CreateServidorTemporarioOutput from(final Long anId) {
        return new CreateServidorTemporarioOutput(anId);
    }

    public static CreateServidorTemporarioOutput from(final ServidorTemporario aServidorTemporario) {
        return new CreateServidorTemporarioOutput(aServidorTemporario.getId().getValue());
    }
}
