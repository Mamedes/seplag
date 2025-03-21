package com.seletivo.infra.controller.lotacao;


import com.seletivo.application.lotacao.create.CreateLotacaoCommand;
import com.seletivo.application.lotacao.create.CreateLotacaoOutput;
import com.seletivo.application.lotacao.create.CreateLotacaoUseCase;
import com.seletivo.application.lotacao.fetch.GetLotacaoByIdUseCase;
import com.seletivo.domain.pessoa.PessoaID;
import com.seletivo.domain.unidade.UnidadeID;
import com.seletivo.domain.validation.handler.Notification;
import com.seletivo.infra.controller.lotacao.presenters.LotacaoApiPresenter;
import com.seletivo.infra.controller.lotacao.request.CreateLotacaoRequest;
import com.seletivo.infra.controller.lotacao.request.LotacaoResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.util.Objects;
import java.util.function.Function;

@RestController
public class LotacaoController implements LotacaoAPI {

    private final CreateLotacaoUseCase createLotacaoUseCase;
    private final GetLotacaoByIdUseCase getLotacaoByIdUseCase;

    public LotacaoController(
            final CreateLotacaoUseCase createLotacaoUseCase,
            final GetLotacaoByIdUseCase getLotacaoByIdUseCase

    ) {
        this.createLotacaoUseCase = Objects.requireNonNull(createLotacaoUseCase);
        this.getLotacaoByIdUseCase = Objects.requireNonNull(getLotacaoByIdUseCase);

    }

    public ResponseEntity<?> createLotacao(final CreateLotacaoRequest input) {
        final var aCommand = CreateLotacaoCommand.with(PessoaID.from(input.pessoaId()), UnidadeID.from( input.unidadeId()), input.dataLotacao(), input.dataRemocao(), input.portaria());

        final Function<Notification, ResponseEntity<?>> onError = notification -> ResponseEntity.unprocessableEntity().body(notification);

        final Function<CreateLotacaoOutput, ResponseEntity<?>> onSuccess = output -> ResponseEntity.created(URI.create("/lotacao/" + output.id())).body(output);

        return this.createLotacaoUseCase.execute(aCommand).fold(onError, onSuccess);
    }

    @Override
    public LotacaoResponse getById(final Long id) {
        return LotacaoApiPresenter.present(this.getLotacaoByIdUseCase.execute(id));
    }


}
