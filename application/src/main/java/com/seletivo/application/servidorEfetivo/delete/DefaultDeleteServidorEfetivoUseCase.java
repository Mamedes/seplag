package com.seletivo.application.servidorEfetivo.delete;


import java.util.Objects;
import com.seletivo.domain.pessoa.PessoaID;
import com.seletivo.domain.servidorEfetivo.ServidorEfetivoGateway;

public class DefaultDeleteServidorEfetivoUseCase extends DeleteServidorEfetivoUseCase {

    private final ServidorEfetivoGateway servidorEfetivoGateway;

    public DefaultDeleteServidorEfetivoUseCase(
            final ServidorEfetivoGateway servidorEfetivoGateway) {
        this.servidorEfetivoGateway = Objects.requireNonNull(servidorEfetivoGateway);
    }

    @Override
    public void execute(final Long anIn) {
        this.servidorEfetivoGateway.deleteById(PessoaID.from(anIn));
    }
}
