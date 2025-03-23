package com.seletivo.infra.configuration.usecases;

import com.seletivo.application.servidorEfetivo.create.CreateServidorEfetivoUseCase;
import com.seletivo.application.servidorEfetivo.create.DefaultCreateServidorEfetivoUseCase;
import com.seletivo.application.servidorEfetivo.fetch.DefaultGetServidorEfetivoByIdUseCase;
import com.seletivo.application.servidorEfetivo.fetch.GetServidorEfetivoByIdUseCase;
import com.seletivo.application.servidorEfetivo.fetch.custom.DefaultListServidorEfetivoByUnidadeUseCase;
import com.seletivo.application.servidorEfetivo.fetch.custom.DefaultSearchServidorEnderecoUseCase;
import com.seletivo.application.servidorEfetivo.fetch.custom.ListServidorEfetivoByUnidadeUseCase;
import com.seletivo.application.servidorEfetivo.fetch.custom.SearchServidorEnderecoUseCase;
import com.seletivo.domain.pessoa.PessoaGateway;
import com.seletivo.domain.servidorEfetivo.ServidorEfetivoGateway;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ServidorEfetivoUseCaseConfig {

    private final ServidorEfetivoGateway servidorEfetivoGateway;
    private final PessoaGateway pessoaGateway;


    public ServidorEfetivoUseCaseConfig(final ServidorEfetivoGateway servidorEfetivoGateway, final PessoaGateway pessoaGateway) {
        this.servidorEfetivoGateway = servidorEfetivoGateway;
        this.pessoaGateway= pessoaGateway;
    }

    @Bean
    public CreateServidorEfetivoUseCase createServidorEfetivoUseCase() {
        return new DefaultCreateServidorEfetivoUseCase(servidorEfetivoGateway,pessoaGateway);
    }


    @Bean
    public GetServidorEfetivoByIdUseCase getServidorEfetivoByIdUseCase() {
        return new DefaultGetServidorEfetivoByIdUseCase(servidorEfetivoGateway, pessoaGateway);
    }

    @Bean
    public SearchServidorEnderecoUseCase SearchServidorEnderecoUseCase () {
        return new DefaultSearchServidorEnderecoUseCase(servidorEfetivoGateway);
    }

    @Bean
    public ListServidorEfetivoByUnidadeUseCase SearchServidorEfetivoByUnidadeUseCase () {
        return new DefaultListServidorEfetivoByUnidadeUseCase(servidorEfetivoGateway);
    }


}
