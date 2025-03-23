package com.seletivo.application.servidorEfetivo;

import java.time.LocalDate;

public record ServidorEfetivoByUnidadeOutput(
        String nome,
        LocalDate dataNascimento,
        String nomeUnidade,
        String bucketFoto
) {
}