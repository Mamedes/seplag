package com.seletivo.application.lotacao.create;

import com.seletivo.domain.pessoa.PessoaID;
import com.seletivo.domain.unidade.UnidadeID;

import java.time.LocalDate;

public record CreateLotacaoCommand(
        PessoaID pessoaId,
        UnidadeID unidadeId,
        LocalDate dataLotacao,
        LocalDate dataRemocao,
        String portaria
) {

    public static CreateLotacaoCommand with(
           final PessoaID pessoaId,
           final  UnidadeID unidadeId,
           final LocalDate dataLotacao,
           final LocalDate dataRemocao,
           final String portaria
    ) {
        return new CreateLotacaoCommand( pessoaId,
                 unidadeId,
                 dataLotacao,
                 dataRemocao,
                 portaria);
    }
}