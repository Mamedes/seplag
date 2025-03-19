package com.seletivo.infra.configuration.usecases;


import com.seletivo.application.unidade.CreateUnidadeUseCase;
import com.seletivo.application.unidade.DefaultCreateUnidadeUseCase;
import com.seletivo.application.unidade.fetch.DefaultGetUnidadeByIdUseCase;
import com.seletivo.domain.unidade.UnidadeGateway;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UnidadeUseCaseConfig {

    private final UnidadeGateway unidadeGateway;

    public UnidadeUseCaseConfig(final UnidadeGateway unidadeGateway) {
        this.unidadeGateway = unidadeGateway;
    }

    @Bean
    public CreateUnidadeUseCase createUnidadeUseCase() {
        return new DefaultCreateUnidadeUseCase(unidadeGateway);
    }

    @Bean
    public DefaultGetUnidadeByIdUseCase getUnidadeByIdUseCase(){return  new DefaultGetUnidadeByIdUseCase(unidadeGateway);
    }


}
