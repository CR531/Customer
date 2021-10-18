package com.example.demo.graphql;


import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.example.demo.model.Customer;
import com.example.demo.service.db.CustomerDataService;

public class Mutation implements GraphQLMutationResolver {
    private CustomerDataService customerDataService;

    public Mutation(CustomerDataService customerDataService) {
        this.customerDataService = customerDataService;
    }

    public String createCustomer(String firstName, String lastName, String email, String phoneNumber) {
        Customer customer = new Customer();
        customer.setFirst_name(firstName);
        customer.setLast_name(lastName);
        customer.setEmail_id(email);
        
        String customerid = customerDataService.postCustomer(customer);

        return customerid;
    }
}