package com.seletivo.domain.pessoa;


import com.seletivo.domain.AggregateRoot;
import com.seletivo.domain.validation.ValidationHandler;

import java.time.LocalDate;

public class FotoPessoa extends AggregateRoot<FotoPessoaID> implements Cloneable {
    private final PessoaID pessoaID;
    private final LocalDate data;
    private final String bucket;
    private final String hash;

    public FotoPessoa(final FotoPessoaID FotoPessoaID, final PessoaID pessoaID, LocalDate data, final String bucket, final String hash) {
        super(FotoPessoaID);
        this.pessoaID = pessoaID;
        this.data = data;
        this.bucket = bucket;
        this.hash = hash;
    }

    public static FotoPessoa newFotoPessoa(final PessoaID pessoaID, final LocalDate data, final String bucket, final String hash) {
        return new FotoPessoa(null, pessoaID, data, bucket, hash);
    }

    public static FotoPessoa with(final FotoPessoaID fotoPessoaID, final PessoaID pessoaID, final LocalDate data, final String bucket, final String hash) {
        return new FotoPessoa(fotoPessoaID, pessoaID, data, bucket, hash);
    }

    public static FotoPessoa with(final FotoPessoa aFotoPessoa) {
        return with(aFotoPessoa.id, aFotoPessoa.pessoaID, aFotoPessoa.data, aFotoPessoa.bucket, aFotoPessoa.hash);
    }

    @Override
    public void validate(ValidationHandler handler) {

    }

    public FotoPessoaID getId() {
        return id;
    }

    public PessoaID getPessoaID() {
        return pessoaID;
    }

    public LocalDate getData() {
        return data;
    }

    public String getBucket() {
        return bucket;
    }

    public String getHash() {
        return hash;
    }
}
