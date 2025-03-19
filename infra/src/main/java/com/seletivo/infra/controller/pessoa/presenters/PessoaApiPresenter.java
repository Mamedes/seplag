package com.seletivo.infra.controller.pessoa.presenters;


import com.seletivo.application.pessoa.fetch.PessoaOutput;
import com.seletivo.infra.controller.pessoa.request.PessoaListResponse;
import com.seletivo.infra.controller.unidade.PessoaResponse;

public interface PessoaApiPresenter {

    static PessoaResponse present(final PessoaOutput output) {
        return new PessoaResponse(
                output.id().getValue(),
                output.nome(),
                output.dataNascimento(),
                output.sexo(),
                output.nomeMae(),
                output.nomePai()

        );
    }

    static PessoaListResponse present(final PessoaListResponse output) {
        return new PessoaListResponse(
                output.id(),
                output.nome(),
                output.dataNascimento(),
                output.sexo(),
                output.nomeMae(),
                output.nomePai()
        );
    }
}
