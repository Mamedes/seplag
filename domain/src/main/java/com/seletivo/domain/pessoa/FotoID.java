package com.seletivo.domain.pessoa;


import com.seletivo.domain.Identifier;

import java.util.Objects;

public final class FotoID extends Identifier {
    private final Long value;

    private FotoID(final Long value) {
        this.value = value;
    }

    public static FotoID from(final Long anId) {
        return new FotoID(anId);
    }

    public Long getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FotoID that = (FotoID) o;
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
