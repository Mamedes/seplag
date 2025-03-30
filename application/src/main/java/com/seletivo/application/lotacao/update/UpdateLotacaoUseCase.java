package com.seletivo.application.lotacao.update;

import com.seletivo.application.UseCase;
import com.seletivo.domain.validation.handler.Notification;
import io.vavr.control.Either;

public abstract class UpdateLotacaoUseCase extends UseCase<UpdateLotacaoCommand, Either<Notification, UpdateLotacaoOutput>> {
}