package com.statik.core.commands;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Objects;
import java.util.Optional;

public class CommandContext extends HashMap<String, Object> implements Serializable {
    private static final String DATA = "data";

    private static final String RESULT = "result";

    public CommandContext() {
        super();
    }

    public CommandContext(Object object) {
        super.put(DATA, object);
    }

    public <T extends Object> T getData(Class<T> clazz) {
        return getProperty(DATA, clazz);
    }

    private <R> R getProperty(String data, Class<R> clazz) {
        return Optional.ofNullable(get(data)).map(clazz::cast).orElse(null);
    }
}
