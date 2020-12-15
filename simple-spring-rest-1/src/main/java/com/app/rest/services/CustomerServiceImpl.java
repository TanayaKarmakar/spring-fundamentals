package com.app.rest.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.app.rest.api.v1.mapper.CustomerMapper;
import com.app.rest.api.v1.model.CustomerDTO;
import com.app.rest.controllers.v1.CustomerController;
import com.app.rest.domain.Customer;
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
		return customerRepository.findAll().stream().map(customer -> {
			return populateCustomerDTO(customer);
		}).collect(Collectors.toList());
	}

	@Override
	public CustomerDTO getCustomerById(Long id) {
		return customerRepository.findById(id).map(customer -> {
			return populateCustomerDTO(customer);
		}).orElseThrow(ResourceNotFoundException::new);
	}

	@Override
	public CustomerDTO createNewCustomer(CustomerDTO customerDTO) {
		return saveAndReturnDTO(customerMapper.customerDTOToCustomer(customerDTO));
	}

	@Override
	public CustomerDTO saveCustomerByDTO(Long id, CustomerDTO customerDTO) {
		Customer customer = customerMapper.customerDTOToCustomer(customerDTO);
        customer.setId(id);

        return saveAndReturnDTO(customer);
	}
	
	@Override
	public CustomerDTO patchCustomer(Long id, CustomerDTO customerDTO) {
		
		return customerRepository.findById(id).map(customer -> {

            if(customerDTO.getFirstName() != null){
                customer.setFirstName(customerDTO.getFirstName());
            }

            if(customerDTO.getLastName() != null){
                customer.setLastName(customerDTO.getLastName());
            }

            return populateCustomerDTO(customerRepository.save(customer));
        }).orElseThrow(ResourceNotFoundException::new); //todo implement better exception handling;
	}
	
	@Override
	public void deleteCustomerById(Long id) {
		customerRepository.deleteById(id);
	}
	
	private CustomerDTO saveAndReturnDTO(Customer customer) {
        Customer savedCustomer = customerRepository.save(customer);

        return populateCustomerDTO(savedCustomer);
    }
	
	private CustomerDTO populateCustomerDTO(Customer customer) {
		CustomerDTO customerDTO = customerMapper.customerToCustomerDTO(customer);
		customerDTO.setCustomerUrl(getCustomerUrl(customer.getId()));
		return customerDTO;
	}
	
	private String getCustomerUrl(Long id) {
		return CustomerController.BASE_URL + "/" + id;
	}
}
