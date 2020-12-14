package com.app.rest.controllers.v1;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.app.rest.api.v1.model.CustomerDTO;
import com.app.rest.api.v1.model.CustomerListDTO;
import com.app.rest.services.CustomerService;

@Controller
@RequestMapping("/api/v1/customers/")
public class CustomerController {
	private final CustomerService customerService;

	public CustomerController(CustomerService customerService) {
		this.customerService = customerService;
	}

	@GetMapping
	public ResponseEntity<CustomerListDTO> getListOfCustomers() {
		return new ResponseEntity<CustomerListDTO>(new CustomerListDTO(customerService.getAllCustomers()),
				HttpStatus.OK);
	}

	@GetMapping("{id}")
	public ResponseEntity<CustomerDTO> getCustomerById(@PathVariable Long id) {
		return new ResponseEntity<CustomerDTO>(customerService.getCustomerById(id), HttpStatus.OK);
	}
}
