package com.seletivo.application.unidade.create;


import com.seletivo.domain.unidade.Unidade;

public record CreateUnidadeOutput(
        Long id
) {

    public static CreateUnidadeOutput from(final Long anId) {
        return new CreateUnidadeOutput(anId);
    }

    public static CreateUnidadeOutput from(final Unidade aUnidade) {
        return new CreateUnidadeOutput(aUnidade.getId().getValue());
    }
}
