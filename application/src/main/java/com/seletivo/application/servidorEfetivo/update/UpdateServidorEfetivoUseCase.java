package com.seletivo.application.servidorEfetivo.update;

import com.seletivo.application.UseCase;
import com.seletivo.domain.validation.handler.Notification;
import io.vavr.control.Either;

public abstract class UpdateServidorEfetivoUseCase extends UseCase<UpdateServidorEfetivoCommand, Either<Notification, UpdateServidorEfetivoOutput>> {
}