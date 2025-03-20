package com.seletivo.application.endereco.create;

import com.seletivo.application.UseCase;
import com.seletivo.domain.validation.handler.Notification;
import io.vavr.control.Either;


public abstract class CreateEnderecoUseCase
        extends UseCase<CreateEnderecoCommand, Either<Notification, CreateEnderecoOutput>> {
}
