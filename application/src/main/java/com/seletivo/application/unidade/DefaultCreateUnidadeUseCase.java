package com.seletivo.application.unidade;

import com.seletivo.domain.unidade.Unidade;
import com.seletivo.domain.unidade.UnidadeGateway;
import com.seletivo.domain.validation.handler.Notification;
import io.vavr.control.Either;

import java.util.Objects;

import static io.vavr.API.Left;
import static io.vavr.API.Try;

public class DefaultCreateUnidadeUseCase extends CreateUnidadeUseCase {

    private final UnidadeGateway unidadeGateway;

    public DefaultCreateUnidadeUseCase(final UnidadeGateway unidadeGateway) {
        this.unidadeGateway = Objects.requireNonNull(unidadeGateway);
    }

    @Override
    public Either<Notification, CreateUnidadeOutput> execute(final CreateUnidadeCommand aCommand) {
        final var nome = aCommand.nome();
        final var sigla = aCommand.sigla();

        final var notification = Notification.create();

        final var aUnidade = Unidade.newUnidade( nome,   sigla);
        aUnidade.validate(notification);

        return notification.hasError() ? Left(notification) : create(aUnidade);
    }

    private Either<Notification, CreateUnidadeOutput> create(final Unidade aUnidade) {
        return Try(() -> this.unidadeGateway.create(aUnidade))
                .toEither()
                .bimap(Notification::create, CreateUnidadeOutput::from);
    }
}
