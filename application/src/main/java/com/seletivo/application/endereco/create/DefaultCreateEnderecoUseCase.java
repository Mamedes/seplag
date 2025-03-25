package com.seletivo.application.endereco.create;

import static io.vavr.API.Left;
import static io.vavr.API.Try;
import java.util.Objects;
import com.seletivo.domain.cidade.CidadeID;
import com.seletivo.domain.endereco.Endereco;
import com.seletivo.domain.endereco.EnderecoGateway;
import com.seletivo.domain.validation.handler.Notification;
import io.vavr.control.Either;

public class DefaultCreateEnderecoUseCase extends CreateEnderecoUseCase {

    private final EnderecoGateway enderecoGateway;

    public DefaultCreateEnderecoUseCase(final EnderecoGateway enderecoGateway) {
        this.enderecoGateway = Objects.requireNonNull(enderecoGateway);
    }

    @Override
    public Either<Notification, CreateEnderecoOutput> execute(final CreateEnderecoCommand aCommand) {

        final var tipoLogradouro =aCommand.tipoLogradouro();
        final var logradouro = aCommand.logradouro();
        final var numero = aCommand.numero();
        final var bairro = aCommand.bairro();
        final var cidadeID = aCommand.cidadeId();

        final var notification = Notification.create();

        final var aEndereco = Endereco.newEndereco( tipoLogradouro, logradouro,numero,bairro, CidadeID.from(cidadeID));
        aEndereco.validate(notification);

        return notification.hasError() ? Left(notification) : create(aEndereco);
    }

    private Either<Notification, CreateEnderecoOutput> create(final  Endereco aEndereco) {
        return Try(() -> this.enderecoGateway.create(aEndereco))
                .toEither()
                .bimap(Notification::create, CreateEnderecoOutput::from);
    }
}
