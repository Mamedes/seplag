package com.seletivo.application.servidorTemporario.update;

import com.seletivo.application.UseCase;
import com.seletivo.application.servidorTemporario.UpdateServidorTemporarioOutput;
import com.seletivo.domain.validation.handler.Notification;
import io.vavr.control.Either;

public abstract class UpdateServidorTemporarioUseCase extends UseCase<UpdateServidorTemporarioCommand, Either<Notification, UpdateServidorTemporarioOutput>> {
}