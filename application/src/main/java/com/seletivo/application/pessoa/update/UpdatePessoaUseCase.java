package com.seletivo.application.pessoa.update;

import com.seletivo.application.UseCase;
import com.seletivo.domain.validation.handler.Notification;
import io.vavr.control.Either;

public abstract class UpdatePessoaUseCase
        extends UseCase<UpdatePessoaCommand, Either<Notification, UpdatePessoaOutput>> {
}
