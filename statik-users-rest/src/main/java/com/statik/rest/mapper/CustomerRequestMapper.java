package com.statik.rest.mapper;

import com.statik.domain.customer.Customer;
import com.statik.rest.model.customer.CustomerRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import java.util.UUID;

@Mapper
public interface CustomerRequestMapper {

    CustomerRequestMapper INSTANCE = Mappers.getMapper(CustomerRequestMapper.class);
    public static String GENERATE_UUID_EXPRESSION = "java(UUID.randomUUID())";

    @Mappings({
            @Mapping(source = "email", target = "email"),
            @Mapping(target = "id", expression = GENERATE_UUID_EXPRESSION)
    })
    public abstract Customer mapFrom(CustomerRequest customerRequest);
}
