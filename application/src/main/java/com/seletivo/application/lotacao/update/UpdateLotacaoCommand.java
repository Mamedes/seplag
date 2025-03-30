package com.seletivo.application.lotacao.update;

import com.seletivo.domain.pessoa.PessoaID;
import com.seletivo.domain.unidade.UnidadeID;

import java.time.LocalDate;

public record UpdateLotacaoCommand(
        Long id,
        PessoaID pessoaId,
        UnidadeID unidadeId,
        LocalDate dataLotacao,
        LocalDate dataRemocao,
        String portaria
) {

    public static UpdateLotacaoCommand with(
            Long id,
            final PessoaID pessoaId,
            final UnidadeID unidadeId,
            final LocalDate dataLotacao,
            final LocalDate dataRemocao,
            final String portaria
    ) {
        return new UpdateLotacaoCommand(id, pessoaId, unidadeId, dataLotacao, dataRemocao, portaria);
    }
}