package com.seletivo.application.unidade;

import com.seletivo.application.UseCase;
import com.seletivo.domain.validation.handler.Notification;
import io.vavr.control.Either;


public abstract class CreateUnidadeUseCase
        extends UseCase<CreateUnidadeCommand, Either<Notification, CreateUnidadeOutput>> {
}
