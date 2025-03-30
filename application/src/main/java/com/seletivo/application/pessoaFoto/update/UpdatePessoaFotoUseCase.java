package com.seletivo.application.pessoaFoto.update;

import com.seletivo.application.UseCase;
import com.seletivo.application.pessoaFoto.FotoPessoaOutput;
import com.seletivo.domain.validation.handler.Notification;
import io.vavr.control.Either;

public abstract class UpdatePessoaFotoUseCase
        extends UseCase<UpdateFotoPessoaCommand, Either<Notification, FotoPessoaOutput>> {
}