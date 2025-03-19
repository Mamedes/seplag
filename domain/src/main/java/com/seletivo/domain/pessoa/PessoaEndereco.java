package com.seletivo.domain.pessoa;

import com.seletivo.domain.AggregateRoot;
import com.seletivo.domain.endereco.EnderecoID;
import com.seletivo.domain.validation.ValidationHandler;

public class PessoaEndereco extends AggregateRoot<PessoaID> {

    private final PessoaID pessoaId;
    private final EnderecoID enderecoId;

    private PessoaEndereco( PessoaID pessoaId, EnderecoID enderecoId) {
        super(pessoaId);
        this.pessoaId = pessoaId;
        this.enderecoId = enderecoId;
    }

    public static PessoaEndereco newPessoaEndereco(PessoaID pessoaId, EnderecoID enderecoId) {
        return new PessoaEndereco( pessoaId, enderecoId);
    }

    public static PessoaEndereco with( final PessoaID pessoaId, final EnderecoID enderecoId) {
        return new PessoaEndereco( pessoaId, enderecoId);
    }

    public static PessoaEndereco with(final PessoaEndereco aPessoaEndereco) {
        return with( aPessoaEndereco.pessoaId, aPessoaEndereco.enderecoId);
    }

    public PessoaID getPessoaId() {
        return pessoaId;
    }

    public EnderecoID getEnderecoId() {
        return enderecoId;
    }

    @Override
    public void validate(ValidationHandler handler) {

    }

}