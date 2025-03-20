package com.seletivo.application.endereco.create;

public record CreateEnderecoCommand(
                   String tipoLogradouro,
                   String logradouro,
                   Integer numero,
                   String bairro,
                   Long cidadeId
) {
    public static CreateEnderecoCommand with(
                 final String tipoLogradouro,
                 final String logradouro,
                 final Integer numero,
                 final String bairro,
                 final Long cidadeId
    ) {
        return new CreateEnderecoCommand( tipoLogradouro,
                 logradouro,
                 numero,
                 bairro,
                 cidadeId);
    }
}
