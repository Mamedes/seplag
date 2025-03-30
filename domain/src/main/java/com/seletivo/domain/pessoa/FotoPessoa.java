package com.seletivo.domain.pessoa;


import com.seletivo.domain.AggregateRoot;
import com.seletivo.domain.validation.ValidationHandler;

import java.time.LocalDate;

public class FotoPessoa extends AggregateRoot<FotoPessoaID> implements Cloneable {
    private  PessoaID pessoaID;
    private  LocalDate data;
    private  String bucket;
    private  String hash;

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

    public FotoPessoa update(
            final PessoaID aPessoaID,
            final LocalDate aData,
            final String aBucket,
            final String aHash
    ) {
        this.pessoaID = aPessoaID;
        this.data = aData;
        this.bucket = aBucket;
        this.hash = aHash;
        return this;
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
