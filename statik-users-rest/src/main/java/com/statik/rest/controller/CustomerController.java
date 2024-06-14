package com.statik.rest.controller;

import com.statik.core.annotation.Encrypt;
import com.statik.core.commands.CommandContext;
import com.statik.core.ports.inbound.commands.RegisterCustomerCommandPort;
import com.statik.domain.customer.Customer;
import com.statik.rest.api.CustomerAPI;
import com.statik.rest.mapper.CustomerRequestMapper;
import com.statik.rest.model.customer.CustomerRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class CustomerController implements CustomerAPI {

    private static final Logger log = LoggerFactory.getLogger(CustomerController.class);

    private final RegisterCustomerCommandPort registerCustomerCommandPort;

    public CustomerController(RegisterCustomerCommandPort registerCustomerCommandPort) {
        this.registerCustomerCommandPort = registerCustomerCommandPort;
    }

    @Override
    @Encrypt(values = {"password"})
    public ResponseEntity<?> create(CustomerRequest customerRequest) {
        log.info("Recebendo solicitação de criação de customer");
        Customer customer = CustomerRequestMapper.INSTANCE.mapFrom(customerRequest);
        CommandContext commandContext = new CommandContext(customer);
        registerCustomerCommandPort.doProcess(commandContext);
        return ResponseEntity.noContent().build();
    }
}
