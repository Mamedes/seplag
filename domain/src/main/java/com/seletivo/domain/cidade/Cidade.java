package com.seletivo.domain.cidade;

import com.seletivo.domain.AggregateRoot;
import com.seletivo.domain.pessoa.PessoaID;
import com.seletivo.domain.validation.ValidationHandler;

public class Cidade extends AggregateRoot<CidadeID> implements Cloneable{
    private final String nome;
    private final String uf;

    public Cidade(final CidadeID id, final String nome, final String uf) {
        super(id);
        this.nome = nome;
        this.uf = uf;
    }

    public Cidade newCidade( final String nome, final String uf) {
        return new Cidade(null, nome, uf);
    }

    public static Cidade with(final CidadeID anId, final String nome, final String uf) {
        return new Cidade(anId, nome, uf);
    }

    public static Cidade with(final Cidade aCidade) {
        return with(aCidade.getId(), aCidade.nome, aCidade.uf);
    }

    @Override
    public void validate(ValidationHandler handler) {

    }
    public CidadeID getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getUf() {
        return uf;
    }
}
