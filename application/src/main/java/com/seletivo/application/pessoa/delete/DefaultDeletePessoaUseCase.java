package com.seletivo.application.pessoa.delete;



import com.seletivo.domain.pessoa.PessoaGateway;
import com.seletivo.domain.pessoa.PessoaID;

import java.util.Objects;

public class DefaultDeletePessoaUseCase extends DeletePessoaUseCase {

    private final PessoaGateway pessoaGateway;

    public DefaultDeletePessoaUseCase(final PessoaGateway pessoaGateway) {
        this.pessoaGateway = Objects.requireNonNull(pessoaGateway);
    }

    @Override
    public void execute(final Long anIn) {
        this.pessoaGateway.deleteById(PessoaID.from(anIn));
    }
}
