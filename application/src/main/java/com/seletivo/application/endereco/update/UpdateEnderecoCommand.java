package com.seletivo.application.endereco.update;

public record UpdateEnderecoCommand(
        Long id,
        String tipoLogradouro,
        String logradouro,
        Integer numero,
        String bairro,
        Long cidadeId
) {

    public static UpdateEnderecoCommand with(
            final Long anId,
            final String tipoLogradouro,
            final String logradouro,
            final Integer numero,
            final String bairro,
            final Long cidadeId
    ) {
        return new UpdateEnderecoCommand(anId, tipoLogradouro, logradouro, numero,bairro,cidadeId);
    }
}
