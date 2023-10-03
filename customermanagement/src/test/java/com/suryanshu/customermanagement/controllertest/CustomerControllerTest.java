package com.suryanshu.customermanagement.controllertest;

import com.suryanshu.customermanagement.controller.CustomerController;
import com.suryanshu.customermanagement.entity.Customer;
import com.suryanshu.customermanagement.service.CustomerService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

class CustomerControllerTest {

    @Mock
    private CustomerService customerService;

    @Mock
    private BindingResult bindingResult;

    @InjectMocks
    private CustomerController customerController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetAllCustomers() {
        when(customerService.getAllCustomers()).thenReturn(Arrays.asList(new Customer(), new Customer()));

        ResponseEntity<List<Customer>> response = customerController.getAllCustomers();

        verify(customerService).getAllCustomers();
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
        assertEquals(2, response.getBody().size());
    }

    @Test
    void testGetCustomerById() {
        Long customerId = 1L;
        Customer customer = new Customer();
        when(customerService.getCustomerById(customerId)).thenReturn(customer);

        ResponseEntity<Customer> response = customerController.getCustomerById(customerId);

        verify(customerService).getCustomerById(customerId);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
    }

    @Test
    void testCreateCustomer() {
        Customer customer = new Customer();
        when(customerService.createCustomer(customer)).thenReturn(customer);

        ResponseEntity<?> response = customerController.createCustomer(customer, bindingResult);

        verify(customerService).createCustomer(customer);
        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals(customer, response.getBody());
    }

    @Test
    void testUpdateCustomer() {
        Long customerId = 1L;
        Customer updatedCustomer = new Customer();
        when(customerService.updateCustomer(customerId, updatedCustomer)).thenReturn(updatedCustomer);

        ResponseEntity<?> response = customerController.updateCustomer(customerId, updatedCustomer, bindingResult);

        verify(customerService).updateCustomer(customerId, updatedCustomer);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(updatedCustomer, response.getBody());
    }

    @Test
    void testDeleteCustomer() {
        Long customerId = 1L;
        Customer deletedCustomer = new Customer();
        when(customerService.deleteCustomer(customerId)).thenReturn(deletedCustomer);

        ResponseEntity<Customer> response = customerController.deleteCustomer(customerId);

        verify(customerService).deleteCustomer(customerId);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(deletedCustomer, response.getBody());
    }
}
