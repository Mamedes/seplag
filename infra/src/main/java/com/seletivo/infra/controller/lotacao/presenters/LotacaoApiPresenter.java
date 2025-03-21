package com.seletivo.infra.controller.lotacao.presenters;

import com.seletivo.application.lotacao.fetch.LotacaoOutput;
import com.seletivo.infra.controller.lotacao.request.LotacaoResponse;

public interface LotacaoApiPresenter {

    static LotacaoResponse present(final LotacaoOutput output) {
        return new LotacaoResponse(
                output.lotacaoID().getValue(),
                output.pessoaId().getValue(),
                output.unidadeId().getValue(),
                output.dataLotacao(),
                output.dataRemocao(),
                output.portaria()

        );
    }


}
