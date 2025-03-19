package com.seletivo.application.pessoa.fetch.get;




import com.seletivo.application.pessoa.fetch.PessoaOutput;
import com.seletivo.domain.exceptions.NotFoundException;
import com.seletivo.domain.pessoa.Pessoa;
import com.seletivo.domain.pessoa.PessoaGateway;
import com.seletivo.domain.pessoa.PessoaID;

import java.util.Objects;
import java.util.function.Supplier;

public class DefaultGetPessoaByIdUseCase extends GetPessoaByIdUseCase {

    private final PessoaGateway pessoaGateway;

    public DefaultGetPessoaByIdUseCase(final PessoaGateway pessoaGateway) {
        this.pessoaGateway = Objects.requireNonNull(pessoaGateway);
    }

    @Override
    public PessoaOutput execute(final Long anIn) {
        final var anPessoaID = PessoaID.from(anIn);

        return this.pessoaGateway.findById(anPessoaID)
                .map(PessoaOutput::from)
                .orElseThrow(notFound(anPessoaID));
    }

    private Supplier<NotFoundException> notFound(final PessoaID anId) {
        return () -> NotFoundException.with(Pessoa.class, anId);
    }
}
