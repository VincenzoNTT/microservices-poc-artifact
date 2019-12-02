package it.nttdata.ecosystem.customerservices.services;

import org.springframework.stereotype.Service;

import it.nttdata.ecosystem.customerservices.dtos.Customer;
import it.nttdata.ecosystem.customerservices.dtos.Customers;

import java.util.Arrays;
import java.util.List;

@Service
public class CustomerService {

    public Customers getAll() {
        List<Customer> customers = Arrays.asList(new Customer(1, "Andrea Como"), new Customer(2, "Mario Rossi"), new Customer(3, "Paolo Verdi"));
        return new Customers(customers);
    }
}
