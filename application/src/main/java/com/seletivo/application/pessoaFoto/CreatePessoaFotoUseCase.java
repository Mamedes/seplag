package com.seletivo.application.pessoaFoto;


import com.seletivo.application.UseCase;
import com.seletivo.domain.validation.handler.Notification;
import io.vavr.control.Either;

import java.util.List;

public abstract class CreatePessoaFotoUseCase
        extends UseCase<CreateFotoPessoaCommand, Either<Notification, List<CreateFotoPessoaOutput>>>{
}
