package com.app.rest.services;

import java.util.List;

import com.app.rest.api.v1.model.CustomerDTO;

public interface CustomerService {
	List<CustomerDTO> getAllCustomers();
	
	CustomerDTO getCustomerById(Long id);
}
