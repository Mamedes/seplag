package com.seletivo.infra.api.controller.endereco.presenters;


import com.seletivo.application.endereco.fetch.EnderecoOutput;
import com.seletivo.infra.api.controller.endereco.request.EnderecoResponse;

public interface EnderecoApiPresenter {

    static EnderecoResponse present(final EnderecoOutput output) {
        return new EnderecoResponse(
                output.id().getValue(),
                output.tipoLogradouro(),
                output.logradouro(),
                output.numero(),
                output.bairro(),
                output.cidadeId()

        );
    }


}
