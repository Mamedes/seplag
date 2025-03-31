package com.seletivo.infra.api.controller.cidade.response;

import com.seletivo.application.cidade.fetch.list.ListCidadeUseCase;

import com.seletivo.domain.pagination.Pagination;
import com.seletivo.domain.pagination.SearchQuery;
import com.seletivo.infra.api.controller.cidade.CidadeAPI;
import com.seletivo.infra.api.controller.cidade.presenter.CidadeApiPresenter;

import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

@RestController
public class CidadeController implements CidadeAPI {

    private final ListCidadeUseCase listCidadeUseCase;

    public CidadeController(
                            final ListCidadeUseCase listCidadeUseCase) {

        this.listCidadeUseCase = Objects.requireNonNull(listCidadeUseCase);
    }

    @Override
    public Pagination<CidadeListResponse> listCidades(String search, int page, int perPage, String sort, String direction) {
        return listCidadeUseCase.execute(new SearchQuery(page, perPage, search, sort, direction))
                .map(CidadeApiPresenter::present);
    }


}
