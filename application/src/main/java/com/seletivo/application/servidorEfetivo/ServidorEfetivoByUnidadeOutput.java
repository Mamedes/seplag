package com.seletivo.application.servidorEfetivo;

import java.time.LocalDate;

public record ServidorEfetivoByUnidadeOutput(
        String nome,
        Integer idade,
        String nomeUnidade,
        String bucketFoto
) {
}