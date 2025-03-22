package com.seletivo.domain.pessoa;

import com.seletivo.domain.Identifier;

import java.util.Objects;

public final class FotoPessoaID extends Identifier {
    private final Long value;

    private FotoPessoaID(final Long value) {
        this.value = value;
    }

    public static FotoPessoaID from(final Long anId) {
        return new FotoPessoaID(anId);
    }

    public Long getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FotoPessoaID that = (FotoPessoaID) o;
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
