package com.statik.core.ports.inbound.commands;

import com.statik.core.commands.CommandProcesor;
import com.statik.domain.customer.Customer;

public interface RegisterCustomerCommandPort extends CommandProcesor<Customer> {
}
