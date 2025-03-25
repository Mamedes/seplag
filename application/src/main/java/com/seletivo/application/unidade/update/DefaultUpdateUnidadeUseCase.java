package com.seletivo.application.unidade.update;
import com.seletivo.domain.cidade.CidadeID;
import com.seletivo.domain.endereco.EnderecoGateway;
import com.seletivo.domain.exceptions.DomainException;
import com.seletivo.domain.exceptions.NotFoundException;
import com.seletivo.domain.unidade.Unidade;
import com.seletivo.domain.unidade.UnidadeGateway;
import com.seletivo.domain.unidade.UnidadeID;
import com.seletivo.domain.validation.handler.Notification;
import io.vavr.control.Either;

import java.util.Objects;
import java.util.function.Supplier;

import static io.vavr.API.Left;
import static io.vavr.API.Try;

public class DefaultUpdateUnidadeUseCase extends UpdateUnidadeUseCase {

  private final UnidadeGateway unidadeGateway;
    private final EnderecoGateway enderecoGateway;

    public DefaultUpdateUnidadeUseCase(final UnidadeGateway unidadeGateway, final EnderecoGateway enderecoGateway ) {
        this.unidadeGateway = Objects.requireNonNull(unidadeGateway);
        this.enderecoGateway = Objects.requireNonNull(enderecoGateway);

    }

    @Override
    public Either<Notification, UpdateUnidadeOutput> execute(final UpdateUnidadeCommand aCommand) {
        final var anId = UnidadeID.from(aCommand.id());
        final var nome= aCommand.nome();
        final var sigla= aCommand.sigla();

        final var aUnidade = this.unidadeGateway.findById(anId)
                .orElseThrow(notFound(anId));

        final var notification = Notification.create();
        aUnidade.update(nome, sigla )
                .validate(notification);

        return notification.hasError() ? Left(notification) : update(aUnidade);
    }

    private Either<Notification, UpdateUnidadeOutput> update(final Unidade aUnidade) {
        return Try(() -> this.unidadeGateway.update(aUnidade))
                .toEither()
                .bimap(Notification::create, UpdateUnidadeOutput::from);
    }

    private Supplier<DomainException> notFound(final UnidadeID anId) {
        return () -> NotFoundException.with(Unidade.class, anId);
    }
}
