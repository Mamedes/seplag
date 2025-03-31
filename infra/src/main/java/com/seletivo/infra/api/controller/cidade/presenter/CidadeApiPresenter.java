package com.seletivo.infra.api.controller.cidade.presenter;

import com.seletivo.application.cidade.fetch.get.GetCidadeByIdOutput;
import com.seletivo.application.cidade.fetch.list.CidadeListOutput;
import com.seletivo.infra.api.controller.cidade.response.CidadeListResponse;
import com.seletivo.infra.api.controller.cidade.response.CidadeResponse;

public class CidadeApiPresenter {
    public static CidadeResponse present(final GetCidadeByIdOutput output) {
        return new CidadeResponse(
                output.id().getValue(),
                output.nome(),
                output.uf()
        );
    }
    public static CidadeListResponse present(final CidadeListOutput output) {
        return new CidadeListResponse(
                output.id().getValue(),
                output.nome(),
                output.uf()
        );
    }
}