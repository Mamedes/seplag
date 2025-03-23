package com.seletivo.domain.servidorEfetivo;

import java.time.LocalDate;

public record ServidorEfetivoPorUnidade(
        String nome,
        LocalDate dataNascimento,
        String nomeUnidade,
        String bucketFoto
) {
}