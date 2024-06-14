package com.statik.mysql.mapper;

import com.statik.domain.customer.Customer;
import com.statik.mysql.entity.CustomerEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

@Mapper
public abstract class CustomerMysqlMapper {
    public static final CustomerMysqlMapper INSTANCE = Mappers.getMapper(CustomerMysqlMapper.class);

    @Mappings({
            @Mapping(target = "email", source = "email"),
            @Mapping(target = "password", source = "password"),
            @Mapping(target = "uuid", source = "id"),
    })
    public abstract CustomerEntity mapFrom(Customer customer);

    @InheritInverseConfiguration
    public abstract Customer mapFrom(CustomerEntity customerEntity);
}
