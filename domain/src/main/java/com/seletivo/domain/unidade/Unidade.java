package com.seletivo.domain.unidade;

import com.seletivo.domain.AggregateRoot;
import com.seletivo.domain.endereco.EnderecoID;
import com.seletivo.domain.pessoa.PessoaID;
import com.seletivo.domain.validation.ValidationHandler;

public class Unidade extends AggregateRoot<UnidadeID> implements Cloneable{
    private final String nome;
    private final String sigla;

    public Unidade(final UnidadeID unidadeID, final String nome, final String sigla) {
        super(unidadeID);
        this.nome = nome;
        this.sigla = sigla;
    }

    public static Unidade newUnidade(String nome, String sigla) {
        return new Unidade(null, nome, sigla);
    }

    public static Unidade with(final UnidadeID anId, final String nome, final String sigla) {
        return new Unidade(anId, nome, sigla);
    }
    public static Unidade with(final Unidade aUnidade) {
        return new Unidade(aUnidade.getId(), aUnidade.nome, aUnidade.sigla);
    }

    @Override
    public void validate(ValidationHandler handler) {

    }
    public UnidadeID getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getSigla() {
        return sigla;
    }
}
