package com.seletivo.application.cidade.update;

import com.seletivo.application.cidade.UpdateCidadeOutput;
import com.seletivo.domain.cidade.Cidade;
import com.seletivo.domain.cidade.CidadeGateway;
import com.seletivo.domain.cidade.CidadeID;
import com.seletivo.domain.exceptions.DomainException;
import com.seletivo.domain.exceptions.NotFoundException;
import com.seletivo.domain.validation.handler.Notification;
import io.vavr.control.Either;

import java.util.Objects;
import java.util.function.Supplier;

import static io.vavr.API.Left;
import static io.vavr.API.Try;

public class DefaultUpdateCidadeUseCase extends UpdateCidadeUseCase {

    private final CidadeGateway cidadeGateway;

    public DefaultUpdateCidadeUseCase(final CidadeGateway cidadeGateway) {
        this.cidadeGateway = Objects.requireNonNull(cidadeGateway);
    }

    @Override
    public Either<Notification, UpdateCidadeOutput> execute(final UpdateCidadeCommand aCommand) {
        final var anId = CidadeID.from(aCommand.id());
        final var nome = aCommand.nome();
        final var uf = aCommand.uf();

        final var aCidade = this.cidadeGateway.findById(anId)
                .orElseThrow(notFound(anId));

        final var notification = Notification.create();
        aCidade.update(nome, uf )
                .validate(notification);

        return notification.hasError() ? Left(notification) : update(aCidade);
    }

    private Either<Notification, UpdateCidadeOutput> update(final Cidade aCidade) {
        return Try(() -> this.cidadeGateway.update(aCidade))
                .toEither()
                .bimap(Notification::create, UpdateCidadeOutput::from);
    }


    private Supplier<DomainException> notFound(final CidadeID anId) {
        return () -> NotFoundException.with(Cidade.class, anId);
    }
}