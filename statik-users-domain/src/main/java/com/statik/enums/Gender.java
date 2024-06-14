package com.statik.enums;

import java.util.Arrays;
import java.util.Objects;

public enum Gender {

    MALE("1"),
    WOMAN("2"),
    OTHER("3");

    private final String value;

    Gender(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public Gender entryOf(String value) {
        return Arrays.stream(Gender.values())
                .filter(x -> x.value.equalsIgnoreCase(value))
                .findFirst()
                .orElse(null);
    }
}
