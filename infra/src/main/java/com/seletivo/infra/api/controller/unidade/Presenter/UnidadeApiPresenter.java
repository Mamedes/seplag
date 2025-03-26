package com.seletivo.infra.api.controller.unidade.Presenter;

import com.seletivo.application.unidade.fetch.get.UnidadeOutput;
import com.seletivo.application.unidade.fetch.list.UnidadeListOutput;
import com.seletivo.infra.api.controller.unidade.response.UnidadeListResponse;
import com.seletivo.infra.api.controller.unidade.response.UnidadeResponse;

public interface UnidadeApiPresenter {

    static UnidadeResponse present(final UnidadeOutput output) {
        return new UnidadeResponse(
                output.id().getValue(),
                output.nome(),
                output.sigla()
        );
    }

    static UnidadeListResponse present(final UnidadeListOutput output) {
        return new UnidadeListResponse(
                output.id().getValue(),
                output.nome(),
                output.sigla()
        );
    }
 }
