package com.statik.rest.model.customer;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;


public class CustomerRequest {

    @Email
    @NotNull
    @NotBlank
    private String email;

    @NotNull
    @NotBlank
    @Size(min = 10, max = 50)
    private String password;

    public CustomerRequest(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public @Email @NotNull @NotBlank String getEmail() {
        return email;
    }

    public @NotNull @NotBlank @Size(min = 10, max = 50) String getPassword() {
        return password;
    }

    public void setEmail(@Email @NotNull @NotBlank String email) {
        this.email = email;
    }

    public void setPassword(@NotNull @NotBlank @Size(min = 10, max = 50) String password) {
        this.password = password;
    }
}
