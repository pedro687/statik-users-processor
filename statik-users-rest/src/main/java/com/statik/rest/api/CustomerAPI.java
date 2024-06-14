package com.statik.rest.api;

import com.statik.rest.model.customer.CustomerRequest;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;


@RequestMapping(value = "/customers")
public interface CustomerAPI {


    @PostMapping
    ResponseEntity<?> create(@RequestBody @Valid @Validated CustomerRequest customerRequest);
}
