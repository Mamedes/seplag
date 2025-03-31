package com.seletivo.infra.configuration.usecases;

import com.seletivo.application.cidade.create.CreateCidadeUseCase;
import com.seletivo.application.cidade.create.DefaultCreateCidadeUseCase;
import com.seletivo.application.cidade.delete.DefaultDeleteCidadeUseCase;
import com.seletivo.application.cidade.delete.DeleteCidadeUseCase;
import com.seletivo.application.cidade.fetch.get.DefaultGetCidadeByIdUseCase;
import com.seletivo.application.cidade.fetch.get.GetCidadeByIdUseCase;
import com.seletivo.application.cidade.fetch.list.DefaultListCidadeUseCase;
import com.seletivo.application.cidade.fetch.list.ListCidadeUseCase;
import com.seletivo.application.cidade.update.DefaultUpdateCidadeUseCase;
import com.seletivo.application.cidade.update.UpdateCidadeUseCase;
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

    @Bean
    public GetCidadeByIdUseCase getCidadeUseCase() {
        return new DefaultGetCidadeByIdUseCase(cidadeGateway);
    }

    @Bean
    public CreateCidadeUseCase createCidadeUseCase() {
        return new DefaultCreateCidadeUseCase(cidadeGateway);
    }

    @Bean
    public DeleteCidadeUseCase deleteCidadeUseCase() {
        return new DefaultDeleteCidadeUseCase(cidadeGateway);
    }

    @Bean
    public UpdateCidadeUseCase UPDATECidadeUseCase() { return new DefaultUpdateCidadeUseCase(cidadeGateway);
    }





}
