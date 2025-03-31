package com.seletivo.infra.configuration.usecases;

import com.seletivo.application.cidade.fetch.list.DefaultListCidadeUseCase;
import com.seletivo.application.cidade.fetch.list.ListCidadeUseCase;
import com.seletivo.domain.cidade.CidadeGateway;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CidadeUseCaseConfig {

    private final CidadeGateway cidadeGateway;

    public CidadeUseCaseConfig(final CidadeGateway cidadeGateway ) {
        this.cidadeGateway = cidadeGateway;
    }

    @Bean
    public ListCidadeUseCase listCidadeUseCase() {
        return new DefaultListCidadeUseCase(cidadeGateway);
    }


}
