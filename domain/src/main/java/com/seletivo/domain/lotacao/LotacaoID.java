package com.seletivo.domain.lotacao;

import com.seletivo.domain.Identifier;

import java.util.Objects;

public class LotacaoID extends Identifier {
    private final Long value;

    private LotacaoID(final Long value) {
        this.value = value;
    }

    public static LotacaoID from(final Long anId) {
        return new LotacaoID(anId);
    }

    public Long getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LotacaoID that = (LotacaoID) o;
        return Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public String toString() {
        return String.valueOf(getValue());
    }
}
