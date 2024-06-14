package com.statik.domain.users;

import com.statik.domain.AggregateRoot;
import com.statik.enums.Gender;

import java.util.UUID;

public class User extends AggregateRoot<UUID> {

    private final String name;

    private final String nickname;

    private final Integer age;

    private final String description;

    private final Gender gender;

    private final UUID customerId;

    private User(UUID id, String name, String nickname, Integer age, String description, Gender gender, UUID customerId) {
        super(id);
        this.name = name;
        this.nickname = nickname;
        this.age = age;
        this.description = description;
        this.gender = gender;
        this.customerId = customerId;
    }

    public User create(String name, String nickname, Integer age, String description, Gender gender) {
        final UUID id = UUID.randomUUID();
        return new User(id, name, nickname, age, description, gender, id);
    }
}
