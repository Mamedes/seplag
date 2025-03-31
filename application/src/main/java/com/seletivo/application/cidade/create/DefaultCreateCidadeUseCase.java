package com.seletivo.application.cidade.create;

import com.seletivo.domain.cidade.Cidade;
import com.seletivo.domain.cidade.CidadeGateway;
import com.seletivo.domain.validation.handler.Notification;
import io.vavr.control.Either;

import java.util.Objects;

public class DefaultCreateCidadeUseCase extends CreateCidadeUseCase {

    private final CidadeGateway cidadeGateway;

    public DefaultCreateCidadeUseCase(final CidadeGateway cidadeGateway) {
        this.cidadeGateway = Objects.requireNonNull(cidadeGateway);
    }

    @Override
    public Either<Notification, CreateCidadeOutput> execute(final CreateCidadeCommand aCommand) {
        final var nome = aCommand.nome();
        final var uf = aCommand.uf();

        final var aCidade = Cidade.newCidade(nome, uf);

        final var notification = Notification.create();
        aCidade.validate(notification);

        if (notification.hasError()) {
            return Either.left(notification);
        }

        final var createdCidade = cidadeGateway.create(aCidade);
        return Either.right(CreateCidadeOutput.from(createdCidade));
    }
}