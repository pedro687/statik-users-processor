package com.statik;

import java.util.Objects;
import java.util.UUID;

public abstract class Identifier<T> {
    private final T id;

    public Identifier(T id) {
        this.id = id;
    }

    public T getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Identifier<?> that = (Identifier<?>) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
