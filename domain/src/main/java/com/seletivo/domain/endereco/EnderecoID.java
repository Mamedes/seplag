package com.seletivo.domain.endereco;

import com.seletivo.domain.Identifier;

import java.util.Objects;

public class EnderecoID extends Identifier {
    private final Long value;

    private EnderecoID(final Long value) {
        this.value = value;
    }

    public static EnderecoID from(final Long anId) {
        return new EnderecoID(anId);
    }

    public Long getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EnderecoID that = (EnderecoID) o;
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
