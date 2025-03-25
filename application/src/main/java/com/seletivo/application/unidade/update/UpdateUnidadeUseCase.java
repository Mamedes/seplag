package com.seletivo.application.unidade.update;


import com.seletivo.application.UseCase;
import com.seletivo.domain.validation.handler.Notification;
import io.vavr.control.Either;

public abstract class UpdateUnidadeUseCase
        extends UseCase<UpdateUnidadeCommand, Either<Notification, UpdateUnidadeOutput>> {
}
