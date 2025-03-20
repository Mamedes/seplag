package com.seletivo.application.unidade.unidadeEndereco;

import com.seletivo.domain.unidade.UnidadeEndereco;
import com.seletivo.domain.unidade.UnidadeEnderecoGateway;
import com.seletivo.domain.validation.handler.Notification;
import io.vavr.control.Either;

import java.util.Objects;

import static io.vavr.API.Left;
import static io.vavr.API.Try;

public class DefaultCreateUnidadeEnderecoUseCase extends CreateUnidadeEnderecoUseCase {

    private final UnidadeEnderecoGateway unidadeEnderecoGateway;

    public DefaultCreateUnidadeEnderecoUseCase(final UnidadeEnderecoGateway unidadeEnderecoGateway) {
        this.unidadeEnderecoGateway = Objects.requireNonNull(unidadeEnderecoGateway);
    }

    @Override
    public Either<Notification, CreateUnidadeEnderecoOutput> execute(final CreateUnidadeEnderecoCommand aCommand) {
        final var endereco = aCommand.enderecoId();
        final var unidadeId = aCommand.unidadeID();

        final var notification = Notification.create();

        final var aUnidadeEndereco = UnidadeEndereco.newUnidadeEndereco( unidadeId,   endereco);
//        aUnidadeEndereco.validate(notification);
//
        return notification.hasError() ? Left(notification) : create(aUnidadeEndereco);
    }

    private Either<Notification, CreateUnidadeEnderecoOutput> create(final UnidadeEndereco aUnidadeEndereco) {
        return Try(() -> this.unidadeEnderecoGateway.create( aUnidadeEndereco))
                .toEither()
                .bimap(Notification::create, CreateUnidadeEnderecoOutput::from);
    }
}
