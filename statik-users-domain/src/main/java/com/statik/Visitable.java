package com.statik;

public interface Visitable<T> {
    void visit(final Visit<T, ?> accept);
}
