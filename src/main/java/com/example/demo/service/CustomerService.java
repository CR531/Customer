package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Customer;
public interface CustomerService {

	public List<Customer> getCustomers(long limit);
	
	public Customer getCustomer(long customerId);
	
	public String postCustomer(Customer customer);

}
