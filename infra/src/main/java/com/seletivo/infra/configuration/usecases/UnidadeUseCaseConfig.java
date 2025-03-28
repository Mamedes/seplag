package com.seletivo.infra.configuration.usecases;

import com.seletivo.application.unidade.create.CreateUnidadeUseCase;
import com.seletivo.application.unidade.create.DefaultCreateUnidadeUseCase;
import com.seletivo.application.unidade.delete.DefaultDeleteUnidadeUseCase;
import com.seletivo.application.unidade.delete.DeleteUnidadeUseCase;
import com.seletivo.application.unidade.fetch.get.DefaultGetUnidadeByIdUseCase;
import com.seletivo.application.unidade.fetch.get.GetUnidadeByIdUseCase;
import com.seletivo.application.unidade.fetch.list.DefaultListUnidadeUseCase;
import com.seletivo.application.unidade.fetch.list.ListUnidadeUseCase;
import com.seletivo.application.unidade.update.DefaultUpdateUnidadeUseCase;
import com.seletivo.application.unidade.update.UpdateUnidadeUseCase;
import com.seletivo.domain.endereco.EnderecoGateway;
import com.seletivo.domain.unidade.UnidadeGateway;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UnidadeUseCaseConfig {

    private final UnidadeGateway unidadeGateway;
    private final EnderecoGateway enderecoGateway;

    public UnidadeUseCaseConfig(final UnidadeGateway unidadeGateway,
            final EnderecoGateway enderecoGateway) {
        this.unidadeGateway = unidadeGateway;
        this.enderecoGateway = enderecoGateway;
    }

    @Bean
    public CreateUnidadeUseCase createUnidadeUseCase() {
        return new DefaultCreateUnidadeUseCase(unidadeGateway, enderecoGateway);
    }

    @Bean
    public GetUnidadeByIdUseCase getUnidadeByIdUseCase() {
        return new DefaultGetUnidadeByIdUseCase(unidadeGateway);
    }

    @Bean
    public UpdateUnidadeUseCase UpdateUnidadeByIdUseCase() {
        return new DefaultUpdateUnidadeUseCase(unidadeGateway, enderecoGateway);
    }

    @Bean
    public DeleteUnidadeUseCase deleteUnidadeEnderecoUseCase() {
        return new DefaultDeleteUnidadeUseCase(unidadeGateway);
    }

    @Bean
    public ListUnidadeUseCase listUnidadeEnderecoUseCase() {
        return new DefaultListUnidadeUseCase(unidadeGateway);
    }


}
