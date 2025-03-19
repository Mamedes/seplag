package com.seletivo.infra.configuration.usecases;

import com.seletivo.application.pessoa.create.CreatePessoaUseCase;
import com.seletivo.application.pessoa.create.DefaultCreatePessoaUseCase;
import com.seletivo.application.pessoa.fetch.get.DefaultGetPessoaByIdUseCase;
import com.seletivo.application.pessoa.fetch.get.GetPessoaByIdUseCase;
import com.seletivo.domain.pessoa.PessoaGateway;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PessoaUseCaseConfig {

    private final PessoaGateway pessoaGateway;

    public PessoaUseCaseConfig(final PessoaGateway pessoaGateway) {
        this.pessoaGateway = pessoaGateway;
    }

    @Bean
    public CreatePessoaUseCase createPessoaUseCase() {
        return new DefaultCreatePessoaUseCase(pessoaGateway);
    }

    @Bean
    public GetPessoaByIdUseCase getPessoaByIdUseCase(){return  new DefaultGetPessoaByIdUseCase(pessoaGateway);
    }


}
