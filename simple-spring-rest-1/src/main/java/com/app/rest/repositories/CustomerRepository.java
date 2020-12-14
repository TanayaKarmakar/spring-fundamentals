package com.app.rest.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.rest.domain.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

}
