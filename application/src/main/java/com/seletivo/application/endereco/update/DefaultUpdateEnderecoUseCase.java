package com.seletivo.application.endereco.update;


import com.seletivo.domain.cidade.CidadeID;
import com.seletivo.domain.endereco.Endereco;
import com.seletivo.domain.endereco.EnderecoGateway;
import com.seletivo.domain.endereco.EnderecoID;
import com.seletivo.domain.exceptions.DomainException;
import com.seletivo.domain.exceptions.NotFoundException;
import com.seletivo.domain.validation.handler.Notification;
import io.vavr.control.Either;

import java.util.Objects;
import java.util.function.Supplier;

import static io.vavr.API.Left;
import static io.vavr.API.Try;

public class DefaultUpdateEnderecoUseCase extends UpdateEnderecoUseCase {

    private final EnderecoGateway enderecoGateway;

    public DefaultUpdateEnderecoUseCase(final EnderecoGateway enderecoGateway) {
        this.enderecoGateway = Objects.requireNonNull(enderecoGateway);
    }

    @Override
    public Either<com.seletivo.domain.validation.handler.Notification, UpdateEnderecoOutput> execute(final UpdateEnderecoCommand aCommand) {
        final var anId = EnderecoID.from(aCommand.id());
        final var tipoLogradouro= aCommand.tipoLogradouro();
        final var logradouro= aCommand.logradouro();
        final var numero= aCommand.numero();
        final var bairro= aCommand.bairro();
        final Long cidadeId= aCommand.cidadeId();

        final var aEndereco = this.enderecoGateway.findById(anId)
                .orElseThrow(notFound(anId));

        final var notification = Notification.create();
        aEndereco.update(tipoLogradouro, logradouro, numero,bairro, CidadeID.from(cidadeId) )
                .validate(notification);

        return notification.hasError() ? Left(notification) : update(aEndereco);
    }

    private Either<Notification, UpdateEnderecoOutput> update(final Endereco aEndereco) {
        return Try(() -> this.enderecoGateway.update(aEndereco))
                .toEither()
                .bimap(Notification::create, UpdateEnderecoOutput::from);
    }

    private Supplier<DomainException> notFound(final EnderecoID anId) {
        return () -> NotFoundException.with(Endereco.class, anId);
    }
}
