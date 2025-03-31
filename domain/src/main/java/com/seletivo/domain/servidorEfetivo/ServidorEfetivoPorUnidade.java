package com.seletivo.domain.servidorEfetivo;

import java.time.LocalDate;

public record ServidorEfetivoPorUnidade(
        String nome,
        Integer idade,
        String nomeUnidade,
        String bucketFoto
) {
}