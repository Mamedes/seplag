package com.seletivo.domain.pessoa;

import com.seletivo.domain.Identifier;
import java.util.Objects;

public final class PessoaID extends Identifier {
    private final Long value;

    private PessoaID(final Long value) {
        this.value = value;
    }

    public static PessoaID from(final Long anId) {
        return new PessoaID(anId);
    }

    public Long getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PessoaID that = (PessoaID) o;
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
