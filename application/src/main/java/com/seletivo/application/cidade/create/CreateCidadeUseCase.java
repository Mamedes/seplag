package com.seletivo.application.cidade.create;

import com.seletivo.application.UseCase;
import com.seletivo.domain.validation.handler.Notification;
import io.vavr.control.Either;

public abstract class CreateCidadeUseCase
        extends UseCase<CreateCidadeCommand, Either<Notification, CreateCidadeOutput>> {
}