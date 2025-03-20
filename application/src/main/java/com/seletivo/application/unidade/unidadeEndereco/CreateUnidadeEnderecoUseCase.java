package com.seletivo.application.unidade.unidadeEndereco;

import com.seletivo.application.UseCase;
import com.seletivo.domain.validation.handler.Notification;
import io.vavr.control.Either;


public abstract class CreateUnidadeEnderecoUseCase
        extends UseCase<CreateUnidadeEnderecoCommand, Either<Notification, CreateUnidadeEnderecoOutput>> {
}
