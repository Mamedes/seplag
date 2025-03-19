package com.seletivo.domain.unidade;

import com.seletivo.domain.Identifier;

import java.util.Objects;

public class UnidadeID extends Identifier {
    private final Long value;

    private UnidadeID(final Long value) {
        this.value = value;
    }

    public static UnidadeID from(final Long anId) {
        return new UnidadeID(anId);
    }

    public Long getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UnidadeID that = (UnidadeID) o;
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
