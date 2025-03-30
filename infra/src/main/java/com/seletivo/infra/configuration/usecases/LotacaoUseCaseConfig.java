package com.seletivo.infra.configuration.usecases;

import com.seletivo.application.lotacao.update.DefaultUpdateLotacaoUseCase;
import com.seletivo.application.lotacao.update.UpdateLotacaoUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.seletivo.application.lotacao.create.CreateLotacaoUseCase;
import com.seletivo.application.lotacao.create.DefaultCreateLotacaoUseCase;
import com.seletivo.application.lotacao.delete.DefaultDeleteLotacaoCase;
import com.seletivo.application.lotacao.delete.DeleteLotacaoUseCase;
import com.seletivo.application.lotacao.fetch.DefaultGetLotacaoByIdUseCase;
import com.seletivo.application.lotacao.fetch.GetLotacaoByIdUseCase;
import com.seletivo.domain.lotacao.LotacaoGateway;

@Configuration
public class LotacaoUseCaseConfig {

    private final LotacaoGateway lotacaoGateway;

    public LotacaoUseCaseConfig(final LotacaoGateway lotacaoGateway) {
        this.lotacaoGateway = lotacaoGateway;
    }

    @Bean
    public CreateLotacaoUseCase createLotacaoUseCase() {
        return new DefaultCreateLotacaoUseCase(lotacaoGateway);
    }


    @Bean
    public GetLotacaoByIdUseCase getLotacaoByIdUseCase() {
        return new DefaultGetLotacaoByIdUseCase(lotacaoGateway);
    }

    @Bean
    public DeleteLotacaoUseCase deleteLotacaoByIdUseCase() {
        return new DefaultDeleteLotacaoCase(lotacaoGateway);
    }

    @Bean
    public UpdateLotacaoUseCase updateLotacaoByIdUseCase() {
        return new DefaultUpdateLotacaoUseCase(lotacaoGateway);
    }

}
