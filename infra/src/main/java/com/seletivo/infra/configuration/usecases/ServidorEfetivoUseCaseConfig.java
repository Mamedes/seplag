package com.seletivo.infra.configuration.usecases;

import com.seletivo.application.servidor.create.CreateServidorEfetivoUseCase;
import com.seletivo.application.servidor.create.DefaultCreateServidorEfetivoUseCase;
import com.seletivo.application.servidor.fetch.DefaultGetServidorEfetivoByIdUseCase;
import com.seletivo.application.servidor.fetch.GetServidorEfetivoByIdUseCase;
import com.seletivo.domain.pessoa.PessoaGateway;
import com.seletivo.domain.servidor.ServidorEfetivoGateway;
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
