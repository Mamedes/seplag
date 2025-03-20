package com.seletivo.application.servidor.fetch;

import java.util.Objects;
import java.util.function.Supplier;
import com.seletivo.application.pessoa.fetch.PessoaOutput;
import com.seletivo.domain.exceptions.NotFoundException;
import com.seletivo.domain.pessoa.PessoaGateway;
import com.seletivo.domain.pessoa.PessoaID;
import com.seletivo.domain.servidor.ServidorEfetivo;
import com.seletivo.domain.servidor.ServidorEfetivoGateway;

public class DefaultGetServidorEfetivoByIdUseCase extends GetServidorEfetivoByIdUseCase {

    private final ServidorEfetivoGateway servidorEfetivoGateway;
    private final PessoaGateway pessoaGateway;

    public DefaultGetServidorEfetivoByIdUseCase(final ServidorEfetivoGateway servidorEfetivoGateway,
            final PessoaGateway pessoaGateway) {
        this.servidorEfetivoGateway = Objects.requireNonNull(servidorEfetivoGateway);
        this.pessoaGateway = Objects.requireNonNull(pessoaGateway);
    }

    @Override
    public ServidorEfetivoOutput execute(final Long anIn) {
        final var anPessoaID = PessoaID.from(anIn);

        return this.servidorEfetivoGateway.findById(anPessoaID).map(servidorEfetivo -> {
            PessoaOutput pessoaOutput = pessoaGateway.findById(anPessoaID).map(PessoaOutput::from)
                    .orElseThrow(notFound(anPessoaID));
            return ServidorEfetivoOutput.from(servidorEfetivo, pessoaOutput);
        }).orElseThrow(notFound(anPessoaID));
    }

    private Supplier<NotFoundException> notFound(final PessoaID anId) {
        return () -> NotFoundException.with(ServidorEfetivo.class, anId);
    }
}
