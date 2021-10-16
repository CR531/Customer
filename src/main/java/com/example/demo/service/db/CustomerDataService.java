package com.example.demo.service.db;

import java.util.List;

import com.example.demo.model.Customer;
public interface CustomerDataService {

	public List<Customer> getCustomers(long limit);
	
	public Customer getCustomer(long customerId);
	
	public String postCustomer(Customer customer);
	
	

}
