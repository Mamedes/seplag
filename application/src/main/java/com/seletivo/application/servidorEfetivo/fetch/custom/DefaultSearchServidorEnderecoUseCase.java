package com.seletivo.application.servidorEfetivo.fetch.custom;

import com.seletivo.application.servidorEfetivo.ServidorEnderecoOutput;
import com.seletivo.domain.pagination.Pagination;
import com.seletivo.domain.pagination.SearchQuery;
import com.seletivo.domain.servidorEfetivo.ServidorEnderecoDomain;
import com.seletivo.domain.servidorEfetivo.ServidorEfetivoGateway;
import org.springframework.stereotype.Service;


@Service
public class DefaultSearchServidorEnderecoUseCase extends SearchServidorEnderecoUseCase {

    private final ServidorEfetivoGateway servidorEfetivoGateway;

    public DefaultSearchServidorEnderecoUseCase(ServidorEfetivoGateway servidorEfetivoGateway) {
        this.servidorEfetivoGateway = servidorEfetivoGateway;
    }

    @Override
    public Pagination<ServidorEnderecoOutput> execute(SearchQuery searchQuery) {

        Pagination<ServidorEnderecoDomain> domainPagination =
                servidorEfetivoGateway.searchServidorEndereco(searchQuery);

        return domainPagination.map(domain -> new ServidorEnderecoOutput(domain.getNomeServidor(),
                domain.getNomeUnidade(), domain.getLogradouro(), domain.getNumero(),
                domain.getBairro()));
    }
}
