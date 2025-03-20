package com.seletivo.application.endereco.fetch;

import com.seletivo.domain.endereco.Endereco;
import com.seletivo.domain.endereco.EnderecoID;
import com.seletivo.domain.pessoa.PessoaID;

public record EnderecoOutput(
        EnderecoID id,
        String tipoLogradouro,
        String logradouro,
        Integer numero,
        String bairro,
        Long cidadeId
) {

    public static EnderecoOutput from(final Endereco aEndereco) {
        return new EnderecoOutput(
                aEndereco.getId(),
                aEndereco.getTipoLogradouro(),
                aEndereco.getLogradouro(),
                aEndereco.getNumero(),
                aEndereco.getBairro(),
                aEndereco.getCidadeId().getValue()
        );
    }
}