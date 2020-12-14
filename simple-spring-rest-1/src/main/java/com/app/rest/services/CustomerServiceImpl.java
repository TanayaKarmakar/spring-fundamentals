package com.app.rest.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.app.rest.api.v1.mapper.CustomerMapper;
import com.app.rest.api.v1.model.CustomerDTO;
import com.app.rest.repositories.CustomerRepository;

@Service
public class CustomerServiceImpl implements CustomerService {
	private final CustomerMapper customerMapper;
	private final CustomerRepository customerRepository;
	
	public CustomerServiceImpl(CustomerMapper customerMapper, CustomerRepository customerRepository) {
		this.customerMapper = customerMapper;
		this.customerRepository = customerRepository;
	}

	@Override
	public List<CustomerDTO> getAllCustomers() {
		return customerRepository
				.findAll()
				.stream()
				.map(customer -> {
					CustomerDTO customerDTO = customerMapper.customerToCustomerDTO(customer);
					customerDTO.setCustomerUrl("/api/v1/customers/"+customer.getId());
					return customerDTO;
				}).collect(Collectors.toList());
	}
	
	@Override
	public CustomerDTO getCustomerById(Long id) {
		return customerRepository.findById(id)
				.map(customer -> {
					CustomerDTO customerDTO = customerMapper.customerToCustomerDTO(customer);
					customerDTO.setCustomerUrl("/api/v1/customers/"+customer.getId());
					return customerDTO;
				})
				.orElseThrow(RuntimeException::new);
	}

}
