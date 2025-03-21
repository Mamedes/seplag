package com.seletivo.infra.controller.servidorEfetivo.presenters;


import com.seletivo.application.servidorEfetivo.fetch.ServidorEfetivoOutput;
import com.seletivo.infra.controller.pessoa.PessoaResponse;
import com.seletivo.infra.controller.servidorEfetivo.response.ServidorEfetivoResponse;

public interface ServidorApiPresenter {

    public static ServidorEfetivoResponse present(final ServidorEfetivoOutput output) {
        return new ServidorEfetivoResponse(
                output.id().getValue(),
                output.matricula(),
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
