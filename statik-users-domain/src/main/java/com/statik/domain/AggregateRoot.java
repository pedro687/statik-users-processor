package com.statik.domain;

import com.statik.Identifier;

import java.util.UUID;

public abstract class AggregateRoot<T> extends Identifier<T> {

    public AggregateRoot(T id) {
        super(id);
    }
}
