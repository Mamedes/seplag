package com.seletivo.application.unidade;

import com.seletivo.domain.endereco.EnderecoGateway;
import com.seletivo.domain.endereco.EnderecoID;
import com.seletivo.domain.unidade.Unidade;
import com.seletivo.domain.unidade.UnidadeGateway;
import com.seletivo.domain.validation.Error;
import com.seletivo.domain.validation.handler.Notification;
import io.vavr.control.Either;
import java.util.Objects;
import java.util.stream.Collectors;

import static io.vavr.API.Left;
import static io.vavr.API.Try;

public class DefaultCreateUnidadeUseCase extends CreateUnidadeUseCase {

    private final UnidadeGateway unidadeGateway;
    private final EnderecoGateway enderecoGateway;


    public DefaultCreateUnidadeUseCase(final UnidadeGateway unidadeGateway, final EnderecoGateway enderecoGateway ) {
        this.unidadeGateway = Objects.requireNonNull(unidadeGateway);
        this.enderecoGateway = Objects.requireNonNull(enderecoGateway);

    }

    @Override
    public Either<Notification, CreateUnidadeOutput> execute(final CreateUnidadeCommand aCommand) {

        final var enderecoIds = aCommand.enderecoIds();

        if (!enderecoGateway.existsByIds(enderecoIds.stream().map(EnderecoID::from).toList())
                .stream()
                .map(EnderecoID::getValue)
                .collect(Collectors.toSet())
                .containsAll(enderecoIds)) {
            return Left(Notification.create().append(new Error("Um ou mais endereços não foram encontrados.")));
        }




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
