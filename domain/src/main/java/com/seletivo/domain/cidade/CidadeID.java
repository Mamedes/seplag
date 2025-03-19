package com.seletivo.domain.cidade;

import com.seletivo.domain.Identifier;

import java.util.Objects;

public class CidadeID extends Identifier {
    private final Long value;

    private CidadeID(final Long value) {
        this.value = value;
    }

    public static CidadeID from(final Long anId) {
        return new CidadeID(anId);
    }

    public Long getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CidadeID that = (CidadeID) o;
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
