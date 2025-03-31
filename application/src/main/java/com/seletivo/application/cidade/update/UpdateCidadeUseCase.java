package com.seletivo.application.cidade.update;

import com.seletivo.application.UseCase;
import com.seletivo.application.cidade.UpdateCidadeOutput;
import com.seletivo.domain.validation.handler.Notification;
import io.vavr.control.Either;

public abstract class UpdateCidadeUseCase
        extends UseCase<UpdateCidadeCommand, Either<Notification, UpdateCidadeOutput>> {
}