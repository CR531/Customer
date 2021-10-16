package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Customer;
import com.example.demo.service.CustomerService;

import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.parameters.RequestBody;



@RestController
@RequestMapping("")
public class CustomerController {
	
	@Autowired
	CustomerService customerService;
	
	@GetMapping("/v1/customers/")
	public ResponseEntity<List<Customer>> getCustomers( @RequestParam(defaultValue = "10", required = true) long limit,
			@RequestHeader Map<String, String> headers) {
		List<Customer> customers = new ArrayList<Customer>();

		if (headers.get("authorization") == null)
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(customers);
		System.out.println(headers.get("authorization"));
		
		try {
			customers = customerService.getCustomers(limit);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ResponseEntity.ok(customers);
	}

	@GetMapping("/v1/customers/{customerId}")
	public ResponseEntity<Customer> getCustomerbyCustomerId( 
			@Parameter(description = "id of book to be searched") @PathVariable long customerId,
			@RequestHeader Map<String, String> headers) {
			Customer customer = new Customer();

		if (headers.get("authorization") == null)
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(customer);
		System.out.println(headers.get("authorization"));
		
		try {
			customer = customerService.getCustomer(customerId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ResponseEntity.ok(customer);
	}

	@PostMapping("/customers/")
	public ResponseEntity<String> Customers( 
			@RequestBody  Customer customer,
			@RequestHeader Map<String, String> headers) {
			String customerId = "";

		if (headers.get("authorization") == null)
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(customerId);
		System.out.println(headers.get("authorization"));
		
		try {
			customerId = customerService.postCustomer(customer);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ResponseEntity.ok(customerId);
	}

}