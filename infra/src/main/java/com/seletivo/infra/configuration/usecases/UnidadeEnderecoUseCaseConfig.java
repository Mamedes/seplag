package com.seletivo.infra.configuration.usecases;


import com.seletivo.application.unidade.unidadeEndereco.CreateUnidadeEnderecoUseCase;
import com.seletivo.application.unidade.unidadeEndereco.DefaultCreateUnidadeEnderecoUseCase;
import com.seletivo.domain.unidade.UnidadeEnderecoGateway;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UnidadeEnderecoUseCaseConfig {

    private final UnidadeEnderecoGateway unidadeEnderecoGateway;

    public UnidadeEnderecoUseCaseConfig(final UnidadeEnderecoGateway unidadeEnderecoGateway) {
        this.unidadeEnderecoGateway = unidadeEnderecoGateway;
    }

    @Bean
    public CreateUnidadeEnderecoUseCase createUnidadeEnderecoUseCase() {
        return new DefaultCreateUnidadeEnderecoUseCase(unidadeEnderecoGateway);
    }




}
