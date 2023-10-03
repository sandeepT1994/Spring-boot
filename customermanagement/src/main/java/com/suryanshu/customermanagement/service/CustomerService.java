package com.suryanshu.customermanagement.service;

import com.suryanshu.customermanagement.entity.Customer;
import com.suryanshu.customermanagement.exception.ResourceNotFoundException;
import com.suryanshu.customermanagement.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    public Customer getCustomerById(Long id) {
        Customer customer = customerRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Customer not found with id:" + id));
        return customer;
    }

    public Customer createCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    public Customer updateCustomer(Long id, Customer customer) {
        customerRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Customer not found with id:" + id));
        customer.setId(id);
        return customerRepository.save(customer);
    }

    public Customer deleteCustomer(Long id) {
        Customer customer = customerRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Customer not found with id:" + id));
        customerRepository.deleteById(id);
        return customer;
    }
}
