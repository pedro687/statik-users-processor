package com.statik.mysql.repository;

import com.statik.mysql.entity.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepositoryMysql extends JpaRepository<CustomerEntity, String> {
}
