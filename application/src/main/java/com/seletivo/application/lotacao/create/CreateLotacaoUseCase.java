package com.seletivo.application.lotacao.create;

import com.seletivo.application.UseCase;
import com.seletivo.domain.validation.handler.Notification;
import io.vavr.control.Either;


public abstract class CreateLotacaoUseCase
        extends UseCase<CreateLotacaoCommand, Either<Notification, CreateLotacaoOutput>> {
}
