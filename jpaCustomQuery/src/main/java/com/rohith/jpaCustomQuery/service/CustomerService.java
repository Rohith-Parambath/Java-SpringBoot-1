package com.rohith.jpaCustomQuery.service;

import com.rohith.jpaCustomQuery.model.Customer;
import com.rohith.jpaCustomQuery.repository.CustomerRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {
    private CustomerRepo customerRepo;

    public CustomerService(CustomerRepo customerRepo) {
        this.customerRepo = customerRepo;
    }

    public List<Customer> getAllCustomers() {
        return customerRepo.findAll();
    }

    public List<Customer> getCustomerByCity(String city) {
        return customerRepo.getCustomerByCity(city);
    }

    public void addCustomer(Customer customer) {
        customerRepo.save(customer);
    }

    public List<Customer> getCustomerWithInitial(String prefix) {
        return customerRepo.getCustomerByInitial(prefix);
    }

    public List<Customer> getCustomerWithDomain(String domain) {
        return customerRepo.getCustomerByemailDomain(domain);
    }

    public Long getCustomerCountbyDomain(String domain) {
        return customerRepo.countOfTotalCustomersByDomain(domain);
    }

    public List<Customer> getCustomerNotIn(String city) {
        return customerRepo.customerNotInCity(city);
    }
}
