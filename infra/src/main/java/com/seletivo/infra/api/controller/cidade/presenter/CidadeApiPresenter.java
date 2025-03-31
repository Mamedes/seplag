package com.seletivo.infra.api.controller.cidade.presenter;

import com.seletivo.application.cidade.fetch.list.CidadeListOutput;
import com.seletivo.infra.api.controller.cidade.response.CidadeListResponse;

public class CidadeApiPresenter {

    public static CidadeListResponse present(final CidadeListOutput output) {
        return new CidadeListResponse(
                output.id().getValue(),
                output.nome(),
                output.uf()
        );
    }
}