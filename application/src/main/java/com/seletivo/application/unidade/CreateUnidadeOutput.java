package com.seletivo.application.unidade;


import com.seletivo.domain.pessoa.Pessoa;
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
