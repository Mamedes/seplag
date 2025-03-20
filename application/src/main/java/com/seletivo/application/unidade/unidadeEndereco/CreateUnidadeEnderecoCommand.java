package com.seletivo.application.unidade.unidadeEndereco;

import com.seletivo.domain.endereco.EnderecoID;
import com.seletivo.domain.unidade.UnidadeID;

import java.util.List;

public record CreateUnidadeEnderecoCommand(
        UnidadeID unidadeID,
       EnderecoID enderecoId

) {

    public static CreateUnidadeEnderecoCommand with(
            final  UnidadeID unidadeID,
            final EnderecoID enderecoId
    ) {
        return new CreateUnidadeEnderecoCommand(unidadeID, enderecoId);
    }
}
