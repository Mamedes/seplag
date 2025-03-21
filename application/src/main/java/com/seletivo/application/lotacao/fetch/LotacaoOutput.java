package com.seletivo.application.lotacao.fetch;

import com.seletivo.domain.lotacao.Lotacao;
import com.seletivo.domain.lotacao.LotacaoID;
import com.seletivo.domain.pessoa.PessoaID;
import com.seletivo.domain.unidade.UnidadeID;

import java.time.LocalDate;

public record LotacaoOutput(
          LotacaoID lotacaoID,
          PessoaID pessoaId,
          UnidadeID unidadeId,
          LocalDate dataLotacao,
          LocalDate dataRemocao,
          String portaria
) {

    public static LotacaoOutput from(final Lotacao aLotacao) {
        return new LotacaoOutput(
                aLotacao.getId(),
                aLotacao.getPessoaId(),
                aLotacao.getUnidadeId(),
                aLotacao.getDataLotacao(),
                aLotacao.getDataRemocao(),
                aLotacao.getPortaria()
        );
    }
}