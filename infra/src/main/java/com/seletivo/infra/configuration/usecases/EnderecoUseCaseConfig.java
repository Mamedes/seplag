package com.seletivo.infra.configuration.usecases;

import com.seletivo.application.endereco.create.CreateEnderecoUseCase;
import com.seletivo.application.endereco.DefaultCreateEnderecoUseCase;
import com.seletivo.application.endereco.delete.DefaultDeleteEnderecoUseCase;
import com.seletivo.application.endereco.delete.DeleteEnderecoUseCase;
import com.seletivo.application.endereco.fetch.DefaultGetEnderecoByIdUseCase;
import com.seletivo.application.endereco.fetch.GetEnderecoByIdUseCase;
import com.seletivo.application.endereco.update.DefaultUpdateEnderecoUseCase;
import com.seletivo.application.endereco.update.UpdateEnderecoUseCase;
import com.seletivo.domain.endereco.EnderecoGateway;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EnderecoUseCaseConfig {

    private final EnderecoGateway enderecoGateway;

    public EnderecoUseCaseConfig(final EnderecoGateway enderecoGateway) {
        this.enderecoGateway = enderecoGateway;
    }

    @Bean
    public CreateEnderecoUseCase createEnderecoUseCase() {
        return new DefaultCreateEnderecoUseCase(enderecoGateway);
    }

    @Bean
    public GetEnderecoByIdUseCase getEnderecoByIdUseCase(){return  new DefaultGetEnderecoByIdUseCase(enderecoGateway);
    }

    @Bean
    public UpdateEnderecoUseCase updateEnderecoUseCase(){return  new DefaultUpdateEnderecoUseCase(enderecoGateway);
    }

    @Bean
    public DeleteEnderecoUseCase deleteEnderecoUseCase(){return  new DefaultDeleteEnderecoUseCase(enderecoGateway);
    }


}
