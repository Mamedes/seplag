package com.seletivo.application.cidade.create;

public record CreateCidadeCommand(
        String nome,
        String uf
) {

    public static CreateCidadeCommand with(final String nome, final String uf) {
        return new CreateCidadeCommand(nome, uf);
    }
}