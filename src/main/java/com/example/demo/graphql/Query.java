package com.example.demo.graphql;

import java.util.List;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.example.demo.model.Customer;
import com.example.demo.service.db.CustomerDataService;

public class Query implements GraphQLQueryResolver {
    private CustomerDataService customerDataService;

    public Query(CustomerDataService customerDataService) {
        this.customerDataService = customerDataService;
    }

    public List<Customer> getCustomerDetails(long limit) {
        return customerDataService.getCustomers(limit);
    }
    public Customer getCustomerDetailsById(long customerId) {
        return customerDataService.getCustomer(customerId);
    }
}