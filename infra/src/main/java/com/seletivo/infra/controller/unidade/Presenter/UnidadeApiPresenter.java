package com.seletivo.infra.controller.unidade.Presenter;


import com.seletivo.application.unidade.fetch.UnidadeOutput;
import com.seletivo.infra.controller.unidade.request.UnidadeListResponse;
import com.seletivo.infra.controller.unidade.request.UnidadeResponse;

public interface UnidadeApiPresenter {

    static UnidadeResponse present(final UnidadeOutput output) {
        return new UnidadeResponse(
                output.id().getValue(),
                output.nome(),
                output.sigla()
        );
    }

    static UnidadeListResponse present(final UnidadeListResponse output) {
        return new UnidadeListResponse(
                output.id(),
                output.nome(),
                output.sigla()
        );
    }
}
