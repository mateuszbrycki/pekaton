package com.springiscoming.service.customer;

import com.springiscoming.model.customer.Customer;
import com.springiscoming.repository.CustomerRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static com.springiscoming.builder.CustomerBuilder.get;
import static org.mockito.Mockito.verify;

/**
 * Created by winio_000 on 2016-06-20.
 */

@RunWith(MockitoJUnitRunner.class)
public class CustomerServiceTest {

    @Mock
    private CustomerRepository customerRepository;

    @InjectMocks
    private CustomerService customerService;

    @Test
    public void shouldSaveCustomerInCustomerRepository() throws Exception {
        Customer customer = get().withCustomerId(1L).build();

        customerService.save(customer);

        verify(customerRepository).save(customer);
    }

    @Test
    public void shouldFindCustomerByIdInCustomerRepository() throws Exception {
        Customer customer = get().withCustomerId(1L).build();
        Long customerId = customer.getCustomerId();

        customerService.findOneById(customerId);

        verify(customerRepository).findOneByCustomerId(customerId);
    }

    @Test
    public void shouldFindAllCustomersInCustomerRepository() throws Exception {
        customerService.findAll();

        verify(customerRepository).findAll();
    }
}