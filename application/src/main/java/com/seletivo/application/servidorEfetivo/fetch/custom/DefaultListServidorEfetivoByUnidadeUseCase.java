package com.seletivo.application.servidorEfetivo.fetch.custom;

import com.seletivo.application.servidorEfetivo.ServidorEfetivoByUnidadeOutput;
import com.seletivo.domain.pagination.Pagination;
import com.seletivo.domain.pagination.SearchQuery;
import com.seletivo.domain.servidorEfetivo.ServidorEfetivoGateway;

import java.util.Objects;

public class DefaultListServidorEfetivoByUnidadeUseCase
        extends ListServidorEfetivoByUnidadeUseCase {

    private final ServidorEfetivoGateway servidorEfetivoGateway;

    public DefaultListServidorEfetivoByUnidadeUseCase(
            final ServidorEfetivoGateway servidorEfetivoGateway) {
        this.servidorEfetivoGateway = Objects.requireNonNull(servidorEfetivoGateway);
    }

    @Override
    public Pagination<ServidorEfetivoByUnidadeOutput> execute(SearchQuery searchQuery,
            Long unidadeId) {
        return this.servidorEfetivoGateway.findServidoresByUnidade(searchQuery, unidadeId)
                .map(servidorEfetivoPorUnidade -> new ServidorEfetivoByUnidadeOutput(
                        servidorEfetivoPorUnidade.nome(),
                        servidorEfetivoPorUnidade.idade(),
                        servidorEfetivoPorUnidade.nomeUnidade(),
                        servidorEfetivoPorUnidade.bucketFoto()));
    }

    @Override
    public Pagination<ServidorEfetivoByUnidadeOutput> execute(SearchQuery anIn) {
        return null;
    }
}
