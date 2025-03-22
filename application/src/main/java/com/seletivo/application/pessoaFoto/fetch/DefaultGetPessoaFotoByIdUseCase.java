package com.seletivo.application.pessoaFoto.fetch;

import com.seletivo.application.pessoaFoto.FotoPessoaOutput;
import com.seletivo.domain.exceptions.NotFoundException;
import com.seletivo.domain.pessoa.FotoPessoa;
import com.seletivo.domain.pessoa.FotoPessoaGateway;
import com.seletivo.domain.pessoa.FotoPessoaID;

import java.util.Objects;
import java.util.function.Supplier;

public class DefaultGetPessoaFotoByIdUseCase extends GetPessoaFotoByIdUseCase {

    private final FotoPessoaGateway pessoaFotoGateway;

    public DefaultGetPessoaFotoByIdUseCase(final FotoPessoaGateway pessoaFotoGateway) {
        this.pessoaFotoGateway = Objects.requireNonNull(pessoaFotoGateway);
    }

    @Override
    public FotoPessoaOutput execute(final Long anIn) {
        final var aFotoPessoaID = FotoPessoaID.from(anIn);

        return this.pessoaFotoGateway.findById(aFotoPessoaID)
                .map(FotoPessoaOutput::from)
                .orElseThrow(notFound(aFotoPessoaID));
    }

    private Supplier<NotFoundException> notFound(final  FotoPessoaID anId) {
        return () -> NotFoundException.with( FotoPessoa.class, anId);
    }
}
