package com.seletivo.infra.persistence.servidorEfetivo;

import java.time.LocalDate;
import java.time.Period;

public interface ServidorEfetivoByUnidadeProjection {
    String getNome();
    LocalDate getDataNascimento();
    String getNomeUnidade();
    String getBucketFoto();
    default int getIdade() {
        LocalDate dataNascimento = getDataNascimento();
        if (dataNascimento == null) {
            return 0;
        }
        return Period.between(dataNascimento, LocalDate.now()).getYears();
    }
}