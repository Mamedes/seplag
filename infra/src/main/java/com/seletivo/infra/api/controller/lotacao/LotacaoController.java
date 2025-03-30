package com.seletivo.infra.api.controller.lotacao;


import com.seletivo.application.lotacao.create.CreateLotacaoCommand;
import com.seletivo.application.lotacao.create.CreateLotacaoOutput;
import com.seletivo.application.lotacao.create.CreateLotacaoUseCase;
import com.seletivo.application.lotacao.delete.DeleteLotacaoUseCase;
import com.seletivo.application.lotacao.fetch.GetLotacaoByIdUseCase;
import com.seletivo.application.lotacao.update.UpdateLotacaoCommand;
import com.seletivo.application.lotacao.update.UpdateLotacaoOutput;
import com.seletivo.application.lotacao.update.UpdateLotacaoUseCase;
import com.seletivo.domain.pessoa.PessoaID;
import com.seletivo.domain.unidade.UnidadeID;
import com.seletivo.domain.validation.handler.Notification;
import com.seletivo.infra.api.controller.lotacao.presenters.LotacaoApiPresenter;
import com.seletivo.infra.api.controller.lotacao.request.CreateLotacaoRequest;
import com.seletivo.infra.api.controller.lotacao.request.LotacaoResponse;
import com.seletivo.infra.api.controller.lotacao.request.UpdateLotacaoRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.util.Objects;
import java.util.function.Function;

@RestController
public class LotacaoController implements LotacaoAPI {

    private final CreateLotacaoUseCase createLotacaoUseCase;
    private final GetLotacaoByIdUseCase getLotacaoByIdUseCase;
    private final DeleteLotacaoUseCase deleteLotacaoUseCase;
    private final UpdateLotacaoUseCase updateLotacaoUseCase;

    public LotacaoController(
            final CreateLotacaoUseCase createLotacaoUseCase,
            final GetLotacaoByIdUseCase getLotacaoByIdUseCase,
            final DeleteLotacaoUseCase deleteLotacaoUseCase,
            final UpdateLotacaoUseCase updateLotacaoUseCase
    ) {
        this.createLotacaoUseCase = Objects.requireNonNull(createLotacaoUseCase);
        this.getLotacaoByIdUseCase = Objects.requireNonNull(getLotacaoByIdUseCase);
        this.deleteLotacaoUseCase = Objects.requireNonNull(deleteLotacaoUseCase);
        this.updateLotacaoUseCase = Objects.requireNonNull(updateLotacaoUseCase);


    }

    public ResponseEntity<?> createLotacao(final CreateLotacaoRequest input) {
        final var aCommand = CreateLotacaoCommand.with(PessoaID.from(input.pessoaId()),
                UnidadeID.from(input.unidadeId()), input.dataLotacao(), input.dataRemocao(),
                input.portaria());

        final Function<Notification, ResponseEntity<?>> onError =
                notification -> ResponseEntity.unprocessableEntity().body(notification);

        final Function<CreateLotacaoOutput, ResponseEntity<?>> onSuccess = output -> ResponseEntity
                .created(URI.create("/lotacao/" + output.id())).body(output);

        return this.createLotacaoUseCase.execute(aCommand).fold(onError, onSuccess);
    }

    @Override
    public LotacaoResponse getById(final Long id) {
        return LotacaoApiPresenter.present(this.getLotacaoByIdUseCase.execute(id));
    }

    @Override
    public void deleteById(Long id) {
        this.deleteLotacaoUseCase.execute(id);
    }

    @Override
    public ResponseEntity<?> updateLotacao(final Long id, final UpdateLotacaoRequest input) {
        final var aCommand = UpdateLotacaoCommand.with(id, PessoaID.from(input.pessoaId()),
                UnidadeID.from(input.unidadeId()), input.dataLotacao(), input.dataRemocao(),
                input.portaria());

        final Function<Notification, ResponseEntity<?>> onError =
                notification -> ResponseEntity.unprocessableEntity().body(notification);

        final Function<UpdateLotacaoOutput, ResponseEntity<?>> onSuccess = output -> ResponseEntity.ok(output);

        return this.updateLotacaoUseCase.execute(aCommand).fold(onError, onSuccess);
    }
}

