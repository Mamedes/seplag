package com.seletivo.application.servidorTemporario.create;

import com.seletivo.application.UseCase;
import com.seletivo.domain.validation.handler.Notification;
import io.vavr.control.Either;


public abstract class CreateServidorTemporarioUseCase
        extends UseCase<CreateServidorTemporarioCommand, Either<Notification, CreateServidorTemporarioOutput>> {
}
