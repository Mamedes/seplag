package com.seletivo.application.cidade.update;

public record UpdateCidadeCommand(
        Long id,
        String nome,
        String uf
) {

    public static UpdateCidadeCommand with(final Long id, final String nome, final String uf) {
        return new UpdateCidadeCommand(id, nome, uf);
    }
}