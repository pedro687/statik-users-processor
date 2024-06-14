package com.statik.domain.customer;

import com.statik.domain.AggregateRoot;

import java.util.UUID;

public class Customer extends AggregateRoot<UUID> {

    private  String email;

    private  String password;

    private  Boolean isActive;


    public Customer(UUID id, String email, String password, Boolean isActive) {
        super(id);
        this.email = email;
        this.password = password;
        this.isActive = Boolean.TRUE;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }
}
