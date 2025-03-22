package com.seletivo.application.pessoaFoto.list;

import com.seletivo.application.pessoaFoto.FotoPessoaOutput;
import com.seletivo.domain.pagination.Pagination;
import com.seletivo.domain.pagination.SearchQuery;
import com.seletivo.domain.pessoa.FotoPessoaGateway;

import java.util.Objects;

public class DefaultListPessoaFotoUseCase extends ListPessoaFotoUseCase {

    private final FotoPessoaGateway fotoPessoaGateway;

    public DefaultListPessoaFotoUseCase(final FotoPessoaGateway fotoPessoaGateway) {
        this.fotoPessoaGateway = Objects.requireNonNull(fotoPessoaGateway);
    }

    @Override
    public Pagination<FotoPessoaOutput> execute(final SearchQuery aQuery) {
        return this.fotoPessoaGateway.findAll(aQuery)
                .map(FotoPessoaOutput::from);
    }
}
