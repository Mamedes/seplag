package com.seletivo.infra.configuration.usecases;


import com.seletivo.application.unidade.create.CreateUnidadeUseCase;
import com.seletivo.application.unidade.create.DefaultCreateUnidadeUseCase;
import com.seletivo.application.unidade.fetch.DefaultGetUnidadeByIdUseCase;
import com.seletivo.domain.endereco.EnderecoGateway;
import com.seletivo.domain.unidade.UnidadeGateway;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UnidadeUseCaseConfig {

    private final UnidadeGateway unidadeGateway;
    private  final EnderecoGateway enderecoGateway;

    public UnidadeUseCaseConfig(final UnidadeGateway unidadeGateway,final EnderecoGateway enderecoGateway) {
        this.unidadeGateway = unidadeGateway;
        this.enderecoGateway =enderecoGateway;
    }

    @Bean
    public CreateUnidadeUseCase createUnidadeUseCase() {
        return new DefaultCreateUnidadeUseCase(unidadeGateway, enderecoGateway);
    }

    @Bean
    public DefaultGetUnidadeByIdUseCase getUnidadeByIdUseCase(){return  new DefaultGetUnidadeByIdUseCase(unidadeGateway);
    }


}
