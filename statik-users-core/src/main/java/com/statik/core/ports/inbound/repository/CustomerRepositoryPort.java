package com.statik.core.ports.inbound.repository;

import com.statik.domain.customer.Customer;

public interface CustomerRepositoryPort {
    Customer create(Customer customer);
}
