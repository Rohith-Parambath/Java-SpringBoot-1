package com.rohith.jpaCustomQuery.controller;

import com.rohith.jpaCustomQuery.model.Customer;
import com.rohith.jpaCustomQuery.service.CustomerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CustomerController {
    private CustomerService service;

    public CustomerController(CustomerService service) {
        this.service = service;
    }

    @GetMapping("/customer")
    public List<Customer> getAllCustomer() {
        return service.getAllCustomers();
    }

    @GetMapping("/customer/by-city/{city}")
    public List<Customer> getCustomerByCity(@PathVariable String city) {
        return service.getCustomerByCity(city);
    }

    @GetMapping("/customer/by-initial/{prefix}")
    public List<Customer> getCustomerWithInitial(@PathVariable String prefix) {
        return service.getCustomerWithInitial(prefix);
    }

    @GetMapping("/customer/domain/{domain}")
    public List<Customer> getCustomerWithDomain(@PathVariable String domain) {
        return service.getCustomerWithDomain(domain);
    }

    @GetMapping("/customer/totalCustomer/{domain}")
    public Long getCustomerCountByDomain(@PathVariable String domain) {
        return service.getCustomerCountbyDomain(domain);
    }

    @GetMapping("/customer/not-in/{city}")
    public List<Customer> getCustomerNotIn(@PathVariable String city) {
        return service.getCustomerNotIn(city);
    }

    @PostMapping("/customer")
    public void addCustomer(@RequestBody Customer customer) {
        service.addCustomer(customer);
    }
}
