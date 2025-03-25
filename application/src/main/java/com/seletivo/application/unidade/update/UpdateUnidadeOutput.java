package com.seletivo.application.unidade.update;

import com.seletivo.domain.unidade.Unidade;

public record UpdateUnidadeOutput(Long id) {

    public static UpdateUnidadeOutput from(final Long anId) {
        return new UpdateUnidadeOutput(anId);
    }

    public static UpdateUnidadeOutput from(final Unidade aUnidade) {
        return new UpdateUnidadeOutput(aUnidade.getId().getValue());
    }
}
