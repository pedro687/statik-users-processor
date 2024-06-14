package com.statik.mysql.adapter;

import com.statik.core.ports.inbound.repository.CustomerRepositoryPort;
import com.statik.domain.customer.Customer;
import com.statik.mysql.entity.CustomerEntity;
import com.statik.mysql.mapper.CustomerMysqlMapper;
import com.statik.mysql.repository.CustomerRepositoryMysql;
import org.springframework.stereotype.Component;

@Component
public class CustomerRepositoryImpl implements CustomerRepositoryPort {

    private final CustomerRepositoryMysql customerRepositoryMysql;

    public CustomerRepositoryImpl(CustomerRepositoryMysql customerRepositoryMysql) {
        this.customerRepositoryMysql = customerRepositoryMysql;
    }

    @Override
    public Customer create(Customer customer) {
        CustomerEntity customerEntity = CustomerMysqlMapper.INSTANCE.mapFrom(customer);
        CustomerEntity createdCustomer = customerRepositoryMysql.save(customerEntity);
        return CustomerMysqlMapper.INSTANCE.mapFrom(createdCustomer);
    }
}
