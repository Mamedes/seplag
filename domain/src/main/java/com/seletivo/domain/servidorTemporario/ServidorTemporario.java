package com.seletivo.domain.servidorTemporario;

import com.seletivo.domain.AggregateRoot;
import com.seletivo.domain.pessoa.PessoaID;
import com.seletivo.domain.validation.ValidationHandler;

import java.time.LocalDate;

public class ServidorTemporario extends AggregateRoot<PessoaID> implements Cloneable{
    private final LocalDate dataAdmissao;
    private final LocalDate dataDemissao;


    public ServidorTemporario(PessoaID id, LocalDate dataAdmissao, LocalDate dataDemissao) {
        super(id);
        this.dataAdmissao = dataAdmissao;
        this.dataDemissao = dataDemissao;
    }

    public static ServidorTemporario newServidorTemporario(PessoaID id ,final LocalDate dataAdmissao, final LocalDate dataDemissao) {

        return new ServidorTemporario(id, dataAdmissao, dataDemissao);
    }

    public static ServidorTemporario with(
            final PessoaID anId,
            final LocalDate dataAdmissao,
            final LocalDate dataDemissao
    ) {
        return new ServidorTemporario(
                anId,
                dataAdmissao,
                dataDemissao
        );
    }

    public static ServidorTemporario with(final ServidorTemporario aServidorTemporario) {
        return with(
                aServidorTemporario.getId(),
                aServidorTemporario.dataAdmissao,
                aServidorTemporario.dataDemissao
        );
    }

    @Override
    public void validate(ValidationHandler handler) {

    }

    public PessoaID getId() {
        return id;
    }

    public LocalDate getDataAdmissao() {
        return dataAdmissao;
    }

    public LocalDate getDataDemissao() {
        return dataDemissao;
    }
}