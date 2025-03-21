package com.seletivo.application.servidorEfetivo.create;

import com.seletivo.application.UseCase;
import com.seletivo.domain.validation.handler.Notification;
import io.vavr.control.Either;


public abstract class CreateServidorEfetivoUseCase
        extends UseCase<CreateServidorEfetivoCommand, Either<Notification, CreateServidorEfetivoOutput>> {
}
