package com.seletivo.infra.api.controller.cidade;

import com.seletivo.application.cidade.UpdateCidadeOutput;
import com.seletivo.application.cidade.create.CreateCidadeCommand;
import com.seletivo.application.cidade.create.CreateCidadeOutput;
import com.seletivo.application.cidade.create.CreateCidadeUseCase;
import com.seletivo.application.cidade.delete.DeleteCidadeUseCase;
import com.seletivo.application.cidade.fetch.get.GetCidadeByIdUseCase;
import com.seletivo.application.cidade.fetch.list.ListCidadeUseCase;
import com.seletivo.application.cidade.update.UpdateCidadeCommand;
import com.seletivo.application.cidade.update.UpdateCidadeUseCase;
import com.seletivo.domain.pagination.Pagination;
import com.seletivo.domain.pagination.SearchQuery;
import com.seletivo.domain.validation.handler.Notification;
import com.seletivo.infra.api.controller.cidade.presenter.CidadeApiPresenter;
import com.seletivo.infra.api.controller.cidade.request.CreateCidadeRequest;
import com.seletivo.infra.api.controller.cidade.request.UpdateCidadeRequest;
import com.seletivo.infra.api.controller.cidade.response.CidadeListResponse;
import com.seletivo.infra.api.controller.cidade.response.CidadeResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.util.Objects;
import java.util.function.Function;

@RestController
public class CidadeController implements CidadeAPI {

    private final ListCidadeUseCase listCidadeUseCase;
    private final GetCidadeByIdUseCase getCidadeByIdUseCase;
    private final CreateCidadeUseCase createCidadeUseCase;
    private final DeleteCidadeUseCase deleteCidadeUseCase;
    private final UpdateCidadeUseCase updateCidadeUseCase;
    public CidadeController(
     final ListCidadeUseCase listCidadeUseCase,
     final GetCidadeByIdUseCase getCidadeByIdUseCase,
     final UpdateCidadeUseCase updateCidadeUseCase,
     final DeleteCidadeUseCase deleteCidadeUseCase,
     final CreateCidadeUseCase createCidadeUseCase) {
        this.getCidadeByIdUseCase = Objects.requireNonNull(getCidadeByIdUseCase);
        this.listCidadeUseCase = Objects.requireNonNull(listCidadeUseCase);
        this.createCidadeUseCase = createCidadeUseCase;
        this.deleteCidadeUseCase = Objects.requireNonNull(deleteCidadeUseCase);
        this.updateCidadeUseCase = Objects.requireNonNull(updateCidadeUseCase);
    }
    @Override
    public ResponseEntity<?> createCidade(final CreateCidadeRequest input) {
        final var aCommand = CreateCidadeCommand.with(input.nome(), input.uf());

        final Function<Notification, ResponseEntity<?>> onError =
                notification -> ResponseEntity.unprocessableEntity().body(notification);

        final Function<CreateCidadeOutput, ResponseEntity<?>> onSuccess =
                output -> ResponseEntity.created(URI.create("/cidade/" + output.id())).body(output);

        return this.createCidadeUseCase.execute(aCommand).fold(onError, onSuccess);
    }

    @Override
    public Pagination<CidadeListResponse> listCidades(String search, int page, int perPage, String sort, String direction) {
        return listCidadeUseCase.execute(new SearchQuery(page, perPage, search, sort, direction))
                .map(CidadeApiPresenter::present);
    }
    @Override
    public CidadeResponse getById(final Long id) {
        return CidadeApiPresenter.present(this.getCidadeByIdUseCase.execute(id));
    }
    @Override
    public void deleteById(Long id) {
        deleteCidadeUseCase.execute(id);
    }


    @Override
    public ResponseEntity<?> updateCidade(Long id, UpdateCidadeRequest input) {
        final var aCommand = UpdateCidadeCommand.with(id, input.nome(), input.uf());

        final Function<Notification, ResponseEntity<?>> onError =
                notification -> ResponseEntity.unprocessableEntity().body(notification);

        final Function<UpdateCidadeOutput, ResponseEntity<?>> onSuccess = ResponseEntity::ok;

        return this.updateCidadeUseCase.execute(aCommand).fold(onError, onSuccess);
    }

}
