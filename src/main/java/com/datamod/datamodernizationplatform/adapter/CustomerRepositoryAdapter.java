package com.datamod.datamodernizationplatform.adapter;

import com.datamod.datamodernizationplatform.dto.CustomerDTO;
import com.datamod.datamodernizationplatform.legacy.LegacyCustomerRepository;
import com.datamod.datamodernizationplatform.model.Customer;
import com.datamod.datamodernizationplatform.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Stream;

@Service
@RequiredArgsConstructor
public class CustomerRepositoryAdapter {

    private final CustomerRepository postgresRepo;
    private final LegacyCustomerRepository legacyRepo;

    public List<CustomerDTO> getAllCustomers() {
        List<CustomerDTO> legacyCustomers = legacyRepo.findAll();
        List<CustomerDTO> postgresCustomers = postgresRepo.findAll()
                .stream().map(this::toDto).toList();

        return Stream.concat(legacyCustomers.stream(), postgresCustomers.stream())
                .toList();
    }

    private CustomerDTO toDto(Customer customer) {
        return new CustomerDTO(customer.getId(), customer.getName(), customer.getEmail());
    }
}

