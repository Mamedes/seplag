package com.seletivo.application.servidorTemporario.fetch;

import com.seletivo.application.pessoa.fetch.PessoaOutput;
import com.seletivo.domain.exceptions.NotFoundException;
import com.seletivo.domain.pessoa.PessoaGateway;
import com.seletivo.domain.pessoa.PessoaID;
import com.seletivo.domain.servidorTemporario.ServidorTemporario;
import com.seletivo.domain.servidorTemporario.ServidorTemporarioGateway;

import java.util.Objects;
import java.util.function.Supplier;

public class DefaultGetServidorTemporarioByIdUseCase extends GetServidorTemporarioByIdUseCase {

    private final ServidorTemporarioGateway servidorTemporarioGateway;
    private final PessoaGateway pessoaGateway;

    public DefaultGetServidorTemporarioByIdUseCase(final ServidorTemporarioGateway servidorTemporarioGateway,
                                                   final PessoaGateway pessoaGateway) {
        this.servidorTemporarioGateway = Objects.requireNonNull(servidorTemporarioGateway);
        this.pessoaGateway = Objects.requireNonNull(pessoaGateway);
    }

    @Override
    public ServidorTemporarioOutput execute(final Long anIn) {
        final var anPessoaID = PessoaID.from(anIn);

        return this.servidorTemporarioGateway.findById(anPessoaID).map(servidorTemporario -> {
            PessoaOutput pessoaOutput = pessoaGateway.findById(anPessoaID).map(PessoaOutput::from)
                    .orElseThrow(notFound(anPessoaID));
            return ServidorTemporarioOutput.from(servidorTemporario, pessoaOutput);
        }).orElseThrow(notFound(anPessoaID));
    }

    private Supplier<NotFoundException> notFound(final PessoaID anId) {
        return () -> NotFoundException.with(ServidorTemporario.class, anId);
    }
}
