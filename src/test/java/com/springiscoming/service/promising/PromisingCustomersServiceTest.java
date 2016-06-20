package com.springiscoming.service.promising;

import com.springiscoming.builder.CustomerBuilder;
import com.springiscoming.model.customer.Customer;
import com.springiscoming.model.promising.PromisingCustomer;
import com.springiscoming.service.customer.CustomerService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static java.util.Arrays.asList;
import static java.util.Collections.emptyList;
import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by winio_000 on 2016-06-19.
 */

@RunWith(MockitoJUnitRunner.class)
public class PromisingCustomersServiceTest {

    public static final float ZERO = 0f;
    public static final float ONE = 1f;

    @Mock
    private CustomerService customerService;

    @Mock
    private PromisingCustomerProvider promisingCustomerProvider;

    @InjectMocks
    private PromisingCustomersService promisingCustomersService;

    @Test
    public void shouldReturnEmptyListWhenNoneCustomerGiven() throws Exception {
        when(customerService.findAll()).thenReturn(emptyList());

        List<PromisingCustomer> promisingCustomers = promisingCustomersService.findPromisingCustomers();

        assertTrue(promisingCustomers.isEmpty());
    }

    @Test
    public void shouldReturnEmptyListWhenNoneOfTheCustomersHasPositiveFactor() throws Exception {
        Customer customer1 = customer(1L);
        Customer customer2 = customer(2L);
        PromisingCustomer promisingCustomer1 = mock(PromisingCustomer.class);
        PromisingCustomer promisingCustomer2 = mock(PromisingCustomer.class);
        when(promisingCustomer1.getFactor()).thenReturn(ZERO);
        when(promisingCustomer2.getFactor()).thenReturn(ZERO);
        when(customerService.findAll()).thenReturn(customers(customer1, customer2));
        when(promisingCustomerProvider.get(customer1)).thenReturn(promisingCustomer1);
        when(promisingCustomerProvider.get(customer2)).thenReturn(promisingCustomer2);

        List<PromisingCustomer> promisingCustomers = promisingCustomersService.findPromisingCustomers();

        assertTrue(promisingCustomers.isEmpty());
    }

    @Test
    public void shouldReturnOneTheOnlyOnePromisingCustomerWithPositiveFactor() throws Exception {
        Customer customer1 = customer(1L);
        Customer customer2 = customer(2L);
        PromisingCustomer promisingCustomer1 = mock(PromisingCustomer.class);
        PromisingCustomer promisingCustomer2 = mock(PromisingCustomer.class);
        when(promisingCustomer1.getFactor()).thenReturn(ZERO);
        when(promisingCustomer2.getFactor()).thenReturn(ONE);
        when(customerService.findAll()).thenReturn(customers(customer1, customer2));
        when(promisingCustomerProvider.get(customer1)).thenReturn(promisingCustomer1);
        when(promisingCustomerProvider.get(customer2)).thenReturn(promisingCustomer2);

        List<PromisingCustomer> promisingCustomers = promisingCustomersService.findPromisingCustomers();

        assertEquals(promisingCustomers.size(), 1);
        assertTrue(promisingCustomers.contains(promisingCustomer2));
        assertFalse(promisingCustomers.contains(promisingCustomer1));
    }

    @Test
    public void shouldPromisingCustomersForAllCustomersWhenAllHavePositiveFactor() throws Exception {
        Customer customer1 = customer(1L);
        Customer customer2 = customer(2L);
        PromisingCustomer promisingCustomer1 = mock(PromisingCustomer.class);
        PromisingCustomer promisingCustomer2 = mock(PromisingCustomer.class);
        when(promisingCustomer1.getFactor()).thenReturn(ONE);
        when(promisingCustomer2.getFactor()).thenReturn(ONE);
        when(customerService.findAll()).thenReturn(customers(customer1, customer2));
        when(promisingCustomerProvider.get(customer1)).thenReturn(promisingCustomer1);
        when(promisingCustomerProvider.get(customer2)).thenReturn(promisingCustomer2);

        List<PromisingCustomer> promisingCustomers = promisingCustomersService.findPromisingCustomers();

        assertEquals(promisingCustomers.size(), 2);
        assertTrue(promisingCustomers.contains(promisingCustomer2));
        assertTrue(promisingCustomers.contains(promisingCustomer1));
    }

    private Customer customer(Long customerId) {
        return CustomerBuilder.get()
                .withCustomerId(customerId)
                .build();
    }

    private List<Customer> customers(Customer... customers) {
        return new ArrayList<>(asList(customers));
    }
}