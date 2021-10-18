package com.example.demo.graphql;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.demo.service.db.CustomerDataService;

@Configuration
public class GraphqlConfiguration {
   



    @Bean
    public Query query(CustomerDataService customerDataService) {
        return new Query(customerDataService);
    }

    @Bean
    public Mutation mutation(CustomerDataService customerDataService) {
        return new Mutation(customerDataService);
    }
}
