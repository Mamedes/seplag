package com.seletivo.domain.unidade;

import com.seletivo.domain.AggregateRoot;
import com.seletivo.domain.endereco.EnderecoID;
import com.seletivo.domain.validation.ValidationHandler;

public class UnidadeEndereco extends AggregateRoot<UnidadeID> {
    private final EnderecoID enderecoId;

    private UnidadeEndereco( UnidadeID unidadeId, EnderecoID enderecoId) {
        super(unidadeId);
        this.enderecoId = enderecoId;
    }

    public static UnidadeEndereco newUnidadeEndereco(UnidadeID unidadeId, EnderecoID enderecoId) {
        return new UnidadeEndereco( unidadeId, enderecoId);
    }

    public static UnidadeEndereco with( final UnidadeID unidadeId, final EnderecoID enderecoId) {
        return new UnidadeEndereco( unidadeId, enderecoId);
    }

    public static UnidadeEndereco with(final UnidadeEndereco aUnidadeEndereco) {
        return with(aUnidadeEndereco.id, aUnidadeEndereco.enderecoId);
    }

    @Override
    public void validate(ValidationHandler handler) {

    }
    public UnidadeID getId() {
        return id;
    }

    public EnderecoID getEnderecoId() {
        return enderecoId;
    }
}
