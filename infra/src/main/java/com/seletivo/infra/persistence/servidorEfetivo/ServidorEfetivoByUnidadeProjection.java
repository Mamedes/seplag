package com.seletivo.infra.persistence.servidorEfetivo;

import java.time.LocalDate;

public interface ServidorEfetivoByUnidadeProjection {
    String getNome();
    LocalDate getDataNascimento();
    String getNomeUnidade();
    String getBucketFoto();
}