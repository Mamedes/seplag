package com.seletivo.infra.configuration.usecases;

import com.seletivo.application.servidorTemporario.create.CreateServidorTemporarioUseCase;
import com.seletivo.application.servidorTemporario.create.DefaultCreateServidorTemporarioUseCase;
import com.seletivo.application.servidorTemporario.fetch.DefaultGetServidorTemporarioByIdUseCase;
import com.seletivo.application.servidorTemporario.fetch.GetServidorTemporarioByIdUseCase;
import com.seletivo.domain.pessoa.PessoaGateway;
import com.seletivo.domain.servidorTemporario.ServidorTemporarioGateway;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ServidorTemporarioUseCaseConfig {

    private final ServidorTemporarioGateway servidorTemporarioGateway;
    private final PessoaGateway pessoaGateway;


    public ServidorTemporarioUseCaseConfig(final ServidorTemporarioGateway servidorTemporarioGateway, final PessoaGateway pessoaGateway) {
        this.servidorTemporarioGateway = servidorTemporarioGateway;
        this.pessoaGateway= pessoaGateway;
    }

    @Bean
    public CreateServidorTemporarioUseCase createServidorTemporarioUseCase() {
        return new DefaultCreateServidorTemporarioUseCase(servidorTemporarioGateway,pessoaGateway);
    }


    @Bean
    public GetServidorTemporarioByIdUseCase getServidorTemporarioByIdUseCase() {
        return new DefaultGetServidorTemporarioByIdUseCase(servidorTemporarioGateway, pessoaGateway);
    }





}
