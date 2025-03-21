package com.seletivo.domain.servidorEfetivo;

import com.seletivo.domain.AggregateRoot;
import com.seletivo.domain.pessoa.PessoaID;
import com.seletivo.domain.validation.ValidationHandler;

public class ServidorEfetivo extends AggregateRoot<PessoaID> implements Cloneable{

    private final String matricula;

    public ServidorEfetivo(PessoaID id, String matricula) {
        super(id);
        this.matricula = matricula;
    }

    public static ServidorEfetivo newServidorEfetivo(PessoaID id, String matricula) {
        return new ServidorEfetivo(id, matricula);
    }

    public static ServidorEfetivo with(final PessoaID id,final String matricula) {
        return new ServidorEfetivo(id, matricula);
    }

    public static ServidorEfetivo with(final ServidorEfetivo aServidorEfetivo) {
        return with(aServidorEfetivo.id, aServidorEfetivo.matricula);
    }


    @Override
    public void validate(ValidationHandler handler) {
    }
    public PessoaID getId() {
        return id;
    }

    public String getMatricula() {
        return matricula;
    }
}
