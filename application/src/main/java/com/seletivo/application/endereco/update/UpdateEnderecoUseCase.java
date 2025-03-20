package com.seletivo.application.endereco.update;


import com.seletivo.application.UseCase;
import com.seletivo.domain.validation.handler.Notification;
import io.vavr.control.Either;

public abstract class UpdateEnderecoUseCase
        extends UseCase<UpdateEnderecoCommand, Either<Notification, UpdateEnderecoOutput>> {
}
