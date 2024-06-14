package com.statik;

public interface Visit<T, R> {

    R visit(final T argument);
}
