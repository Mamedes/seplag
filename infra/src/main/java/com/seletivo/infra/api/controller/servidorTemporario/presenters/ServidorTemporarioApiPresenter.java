package com.seletivo.infra.api.controller.servidorTemporario.presenters;

import com.seletivo.application.servidorTemporario.fetch.ServidorTemporarioOutput;
import com.seletivo.infra.api.controller.pessoa.PessoaResponse;
import com.seletivo.infra.api.controller.servidorTemporario.response.ServidorTemporarioResponse;

public interface ServidorTemporarioApiPresenter {

     static ServidorTemporarioResponse present(final ServidorTemporarioOutput output) {
        return new ServidorTemporarioResponse(
                output.id().getValue(),
                output.dataAdmissao(),
                output.dataDemissao(),
                new PessoaResponse(
                        output.pessoa().id().getValue(),
                        output.pessoa().nome(),
                        output.pessoa().dataNascimento(),
                        output.pessoa().sexo(),
                        output.pessoa().nomeMae(),
                        output.pessoa().nomePai()
                )
        );
    }

}
