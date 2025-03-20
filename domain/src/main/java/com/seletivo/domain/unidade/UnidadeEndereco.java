package com.seletivo.domain.unidade;

import com.seletivo.domain.endereco.EnderecoID;

public class UnidadeEndereco {

    private final  EnderecoID enderecoId;
    private final UnidadeID unidadeId;

    private UnidadeEndereco( final UnidadeID unidadeId,final  EnderecoID enderecoId) {
        this.unidadeId = unidadeId;
        this.enderecoId = enderecoId;
    }

    public static UnidadeEndereco newUnidadeEndereco( final UnidadeID unidadeId,final EnderecoID enderecoId) {
        return new UnidadeEndereco( unidadeId, enderecoId);
    }

    public static UnidadeEndereco with( final UnidadeID unidadeId, final  EnderecoID enderecoId) {
        return new UnidadeEndereco( unidadeId, enderecoId);
    }


    public static UnidadeEndereco with(final UnidadeEndereco aUnidadeEndereco) {
        return with(aUnidadeEndereco.unidadeId, aUnidadeEndereco.enderecoId);
    }

    public EnderecoID getEnderecoId() {
        return enderecoId;
    }

    public UnidadeID getUnidadeId() {
        return unidadeId;
    }
}
