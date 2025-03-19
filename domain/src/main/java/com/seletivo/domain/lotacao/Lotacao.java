package com.seletivo.domain.lotacao;

import com.seletivo.domain.AggregateRoot;
import com.seletivo.domain.endereco.EnderecoID;
import com.seletivo.domain.pessoa.PessoaID;
import com.seletivo.domain.unidade.UnidadeID;
import com.seletivo.domain.validation.ValidationHandler;

import java.time.LocalDate;

public class Lotacao  extends AggregateRoot<LotacaoID> implements Cloneable {

    private final PessoaID pessoaId;
    private final UnidadeID unidadeId;
    private final LocalDate dataLotacao;
    private LocalDate dataRemocao;
    private String portaria;

    private Lotacao(LotacaoID id, PessoaID pessoaId, UnidadeID unidadeId, LocalDate dataLotacao, LocalDate dataRemocao, String portaria) {
        super(id);
        this.pessoaId = pessoaId;
        this.unidadeId = unidadeId;
        this.dataLotacao = dataLotacao;
        this.dataRemocao = dataRemocao;
        this.portaria = portaria;
    }

    public static Lotacao newLotacao(PessoaID pessoaId, UnidadeID unidadeId, LocalDate dataLotacao, LocalDate dataRemocao, String portaria) {
        return new Lotacao(null, pessoaId, unidadeId, dataLotacao, dataRemocao, portaria);
    }

    public static Lotacao with(final LotacaoID id, final PessoaID pessoaId, final UnidadeID unidadeId, final LocalDate dataLotacao, final LocalDate dataRemocao, final String portaria) {
        return new Lotacao(id, pessoaId, unidadeId, dataLotacao, dataRemocao, portaria);
    }

    public static Lotacao with(final Lotacao aLotacao) {
        return with(aLotacao.id, aLotacao.pessoaId, aLotacao.unidadeId, aLotacao.dataLotacao, aLotacao.dataRemocao, aLotacao.portaria);
    }

    @Override
    public void validate(ValidationHandler handler) {

    }
    public LotacaoID getId() {
        return id;
    }

    public PessoaID getPessoaId() {
        return pessoaId;
    }

    public UnidadeID getUnidadeId() {
        return unidadeId;
    }

    public LocalDate getDataLotacao() {
        return dataLotacao;
    }

    public LocalDate getDataRemocao() {
        return dataRemocao;
    }

    public String getPortaria() {
        return portaria;
    }
}
