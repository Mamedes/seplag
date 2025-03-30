package com.seletivo.infra.configuration.usecases;

import com.seletivo.application.pessoaFoto.create.CreatePessoaFotoUseCase;
import com.seletivo.application.pessoaFoto.create.DefaultCreatePessoaFotoUseCase;
import com.seletivo.application.pessoaFoto.fetch.DefaultGetPessoaFotoByIdUseCase;
import com.seletivo.application.pessoaFoto.fetch.GetPessoaFotoByIdUseCase;
import com.seletivo.application.pessoaFoto.list.DefaultListPessoaFotoUseCase;
import com.seletivo.application.pessoaFoto.list.ListPessoaFotoUseCase;
import com.seletivo.application.pessoaFoto.update.DefaultUpdatePessoaFotoUseCase;
import com.seletivo.application.pessoaFoto.update.UpdatePessoaFotoUseCase;
import com.seletivo.domain.arquivo.ArquivoStorageGateway;
import com.seletivo.domain.pessoa.FotoPessoaGateway;
import com.seletivo.domain.pessoa.PessoaGateway;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FotoPessoaUseCaseConfig {

    private final FotoPessoaGateway fotoPessoaGateway;
    private final PessoaGateway pessoaGateway;
    private final ArquivoStorageGateway arquivoStorageGateway;


    public FotoPessoaUseCaseConfig(final FotoPessoaGateway fotoPessoaGateway, final PessoaGateway pessoaGateway,final ArquivoStorageGateway arquivoStorageGateway) {
        this.fotoPessoaGateway = fotoPessoaGateway;
        this.pessoaGateway = pessoaGateway;
        this.arquivoStorageGateway =arquivoStorageGateway;
    }

    @Bean
    public CreatePessoaFotoUseCase createPessoaFotoUseCase() {
        return new DefaultCreatePessoaFotoUseCase(fotoPessoaGateway, pessoaGateway,arquivoStorageGateway);
    }

    @Bean
    public ListPessoaFotoUseCase listFotosUseCase() {
        return new DefaultListPessoaFotoUseCase(fotoPessoaGateway);
    }

    @Bean
    public GetPessoaFotoByIdUseCase getFotosByIdUseCase() {
        return new DefaultGetPessoaFotoByIdUseCase(fotoPessoaGateway);
    }

    @Bean
    public UpdatePessoaFotoUseCase updatePessoaFotoUseCase() {
        return new DefaultUpdatePessoaFotoUseCase(fotoPessoaGateway, pessoaGateway, arquivoStorageGateway);
    }
}