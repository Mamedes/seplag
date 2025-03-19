package com.seletivo.application.pessoa.create;

import com.seletivo.application.UseCase;
import com.seletivo.domain.validation.handler.Notification;
import io.vavr.control.Either;


public abstract class CreatePessoaUseCase
        extends UseCase<CreatePessoaCommand, Either<Notification, CreatePessoaOutput>> {
}
