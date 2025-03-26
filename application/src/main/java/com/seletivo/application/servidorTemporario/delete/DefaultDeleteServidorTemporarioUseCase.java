package com.seletivo.application.servidorTemporario.delete;

import java.util.Objects;
import com.seletivo.domain.pessoa.PessoaID;
import com.seletivo.domain.servidorTemporario.ServidorTemporarioGateway;

public class DefaultDeleteServidorTemporarioUseCase extends DeleteServidorTemporarioUseCase {

    private final ServidorTemporarioGateway servidorTemporarioGateway;

    public DefaultDeleteServidorTemporarioUseCase(
            final ServidorTemporarioGateway servidorTemporarioGateway) {
        this.servidorTemporarioGateway = Objects.requireNonNull(servidorTemporarioGateway);
    }

    @Override
    public void execute(final Long anIn) {
        this.servidorTemporarioGateway.deleteById(PessoaID.from(anIn));
    }
}
