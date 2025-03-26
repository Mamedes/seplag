package com.seletivo.infra.api.controller.servidorEfetivo;

import java.net.URI;
import java.util.Objects;
import java.util.function.Function;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import com.seletivo.application.pessoa.create.CreatePessoaCommand;
import com.seletivo.application.servidorEfetivo.ServidorEnderecoOutput;
import com.seletivo.application.servidorEfetivo.create.CreateServidorEfetivoCommand;
import com.seletivo.application.servidorEfetivo.create.CreateServidorEfetivoOutput;
import com.seletivo.application.servidorEfetivo.create.CreateServidorEfetivoUseCase;
import com.seletivo.application.servidorEfetivo.delete.DeleteServidorEfetivoUseCase;
import com.seletivo.application.servidorEfetivo.fetch.GetServidorEfetivoByIdUseCase;
import com.seletivo.application.servidorEfetivo.fetch.custom.ListServidorEfetivoByUnidadeUseCase;
import com.seletivo.application.servidorEfetivo.fetch.custom.SearchServidorEnderecoUseCase;
import com.seletivo.domain.pagination.Pagination;
import com.seletivo.domain.pagination.SearchQuery;
import com.seletivo.domain.validation.handler.Notification;
import com.seletivo.infra.api.controller.servidorEfetivo.presenters.ServidorApiPresenter;
import com.seletivo.infra.api.controller.servidorEfetivo.presenters.ServidorListByUnidadeApiPresenter;
import com.seletivo.infra.api.controller.servidorEfetivo.request.CreateServidorEfetivoRequest;
import com.seletivo.infra.api.controller.servidorEfetivo.response.ServidorEfetivoByUnidadeResponse;
import com.seletivo.infra.api.controller.servidorEfetivo.response.ServidorEfetivoResponse;
import com.seletivo.infra.api.controller.servidorEfetivo.response.ServidorEnderecoResponse;

@RestController
public class ServidorEfetivoController implements ServidorEfetivoAPI {

    private final CreateServidorEfetivoUseCase createServidorEfetivoUseCase;
    private final GetServidorEfetivoByIdUseCase getServidorEfetivoByIdUseCase;
    private final SearchServidorEnderecoUseCase searchServidorEnderecoUseCase;
    private final ListServidorEfetivoByUnidadeUseCase listServidorEfetivoByUnidadeUseCase;
    private final ServidorListByUnidadeApiPresenter servidorEfetivoApiPresenter;
    private final DeleteServidorEfetivoUseCase deleteServidorEfetivoUseCase;



    public ServidorEfetivoController(
            final CreateServidorEfetivoUseCase createServidorEfetivoUseCase,
            final GetServidorEfetivoByIdUseCase getServidorEfetivoByIdUseCase,
            final SearchServidorEnderecoUseCase searchServidorEnderecoUseCase,
            final ListServidorEfetivoByUnidadeUseCase listServidorEfetivoByUnidadeUseCase,
            ServidorListByUnidadeApiPresenter servidorEfetivoApiPresenter,
            final DeleteServidorEfetivoUseCase deleteServidorEfetivoUseCase) {

        this.createServidorEfetivoUseCase = Objects.requireNonNull(createServidorEfetivoUseCase);
        this.getServidorEfetivoByIdUseCase = Objects.requireNonNull(getServidorEfetivoByIdUseCase);
        this.searchServidorEnderecoUseCase = Objects.requireNonNull(searchServidorEnderecoUseCase);
        this.listServidorEfetivoByUnidadeUseCase =
                Objects.requireNonNull(listServidorEfetivoByUnidadeUseCase);
        this.servidorEfetivoApiPresenter = servidorEfetivoApiPresenter;
        this.deleteServidorEfetivoUseCase = Objects.requireNonNull(deleteServidorEfetivoUseCase);

    }

    public ResponseEntity<?> createServidorEfetivo(final CreateServidorEfetivoRequest request) {
        final var pessoaCommand = CreatePessoaCommand.with(request.pessoa().nome(),
                request.pessoa().dataNascimento(), request.pessoa().sexo(),
                request.pessoa().nomeMae(), request.pessoa().nomePai());

        final var command = CreateServidorEfetivoCommand.with(request.matricula(), pessoaCommand);

        final Function<Notification, ResponseEntity<?>> onError =
                notification -> ResponseEntity.unprocessableEntity().body(notification);

        final Function<CreateServidorEfetivoOutput, ResponseEntity<?>> onSuccess =
                output -> ResponseEntity.created(URI.create("/servidor-efetivo/" + output.id()))
                        .body(output);

        return this.createServidorEfetivoUseCase.execute(command).fold(onError, onSuccess);
    }

    @Override
    public ServidorEfetivoResponse getById(final Long id) {
        return ServidorApiPresenter.present(this.getServidorEfetivoByIdUseCase.execute(id));
    }

    @Override
    public Pagination<ServidorEnderecoResponse> searchEnderecoByNome(final String nome,
            final int page, final int perPage, final String sort, final String direction) {
        final SearchQuery searchQuery = new SearchQuery(page, perPage, nome, sort, direction);
        Pagination<ServidorEnderecoOutput> outputPagination =
                searchServidorEnderecoUseCase.execute(searchQuery);
        return outputPagination.map(ServidorEnderecoResponse::from);
    }

    @Override
    public Pagination<ServidorEfetivoByUnidadeResponse> listServidoresByUnidade( // Alterado o tipo
                                                                                 // de retorno
            Long id, final String nome, final int page, final int perPage, final String sort,
            final String direction) {
        final SearchQuery searchQuery = new SearchQuery(page, perPage, nome, sort, direction);
        return listServidorEfetivoByUnidadeUseCase.execute(searchQuery, id)
                .map(servidorEfetivoApiPresenter::present);
    }

    @Override
    public void deleteById(Long id) {
        this.deleteServidorEfetivoUseCase.execute(id);
    }
}
