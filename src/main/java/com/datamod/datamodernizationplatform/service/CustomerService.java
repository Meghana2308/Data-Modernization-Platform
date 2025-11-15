package com.datamod.datamodernizationplatform.service;


import com.datamod.datamodernizationplatform.model.Customer;
import com.datamod.datamodernizationplatform.repository.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {
    private final CustomerRepository repo;

    public CustomerService(CustomerRepository repo) {
        this.repo = repo;
    }

    public Customer create(Customer c) {
        return repo.save(c);
    }

    public Optional<Customer> getById(String id) {
        return repo.findById(id);
    }

    public List<Customer> listAll() {
        return repo.findAll();
    }
}
