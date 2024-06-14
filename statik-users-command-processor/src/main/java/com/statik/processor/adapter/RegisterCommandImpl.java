package com.statik.processor.adapter;

import com.statik.core.commands.CommandContext;
import com.statik.core.ports.inbound.commands.RegisterCustomerCommandPort;
import com.statik.core.ports.inbound.repository.CustomerRepositoryPort;
import com.statik.domain.customer.Customer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class RegisterCommandImpl implements RegisterCustomerCommandPort {

    private static final Logger log = LoggerFactory.getLogger(RegisterCommandImpl.class);

    private final CustomerRepositoryPort customerRepositoryPort;

    public RegisterCommandImpl(CustomerRepositoryPort customerRepositoryPort) {
        this.customerRepositoryPort = customerRepositoryPort;
    }

    @Override
    public Customer doProcess(CommandContext commandContext) {
        log.info("Iniciando criação de registro de Customer");
        Customer customerRequest = commandContext.getData(Customer.class);
        return customerRepositoryPort.create(customerRequest);
    }

}
