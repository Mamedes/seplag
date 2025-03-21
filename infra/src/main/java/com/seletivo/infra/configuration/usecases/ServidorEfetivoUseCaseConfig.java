package com.seletivo.infra.configuration.usecases;

import com.seletivo.application.servidorEfetivo.create.CreateServidorEfetivoUseCase;
import com.seletivo.application.servidorEfetivo.create.DefaultCreateServidorEfetivoUseCase;
import com.seletivo.application.servidorEfetivo.fetch.DefaultGetServidorEfetivoByIdUseCase;
import com.seletivo.application.servidorEfetivo.fetch.GetServidorEfetivoByIdUseCase;
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





}
