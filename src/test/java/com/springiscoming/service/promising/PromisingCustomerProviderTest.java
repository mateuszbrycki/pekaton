package com.springiscoming.service.promising;

import com.springiscoming.exception.InvalidArgumentException;
import com.springiscoming.model.Customer;
import com.springiscoming.model.promising.PromisingCustomer;
import com.springiscoming.service.FactorCalculator;
import com.springiscoming.service.PurchaseService;
import com.springiscoming.service.SiteEntryService;
import com.springiscoming.service.builders.CustomerBuilder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;

/**
 * Created by winio_000 on 2016-06-19.
 */

@RunWith(MockitoJUnitRunner.class)
public class PromisingCustomerProviderTest {

    public static final int ONE_INT = 1;
    public static final float ONE_FLOAT = 1f;
    public static final long ONE_LONG = 1L;

    @Mock
    private FactorCalculator factorCalculator;

    @Mock
    private SiteEntryService siteEntryService;

    @Mock
    private PurchaseService purchaseService;

    @InjectMocks
    private PromisingCustomerProvider provider;

    @Test(expected = InvalidArgumentException.class)
    public void shouldThrowExceptionWhenCustomerHasNullId() throws Exception {
        provider.get(customer(null));
    }

    @Test
    public void shouldReturnPromisingCustomerFromGivenCustomer() throws Exception {
        long customerId = ONE_LONG;
        Float factor = ONE_FLOAT;
        Float averageVisitTime = ONE_FLOAT;
        Integer visitCount = ONE_INT;
        Integer directVisitCount = ONE_INT;
        Integer purchaseCount = ONE_INT;
        Float purchaseSummaryCost = ONE_FLOAT;
        when(siteEntryService.getCustomerAverageVisitTime(customerId)).thenReturn(averageVisitTime);
        when(siteEntryService.getCustomerDirectVisitsCounter(customerId)).thenReturn(directVisitCount);
        when(siteEntryService.getCustomerVisitsCounter(customerId)).thenReturn(visitCount);
        when(purchaseService.getPurchasesCounter(customerId)).thenReturn(purchaseCount);
        when(purchaseService.getPurchasesSummaryCost(customerId)).thenReturn(purchaseSummaryCost);
        when(factorCalculator.computeFactor(averageVisitTime, visitCount, directVisitCount, purchaseCount, purchaseSummaryCost)).thenReturn(factor);
        Customer customer = customer(customerId);

        PromisingCustomer promisingCustomer = provider.get(customer);

        assertNotNull(promisingCustomer);
        assertEquals(promisingCustomer.getFactor(), factor);
        assertEquals(promisingCustomer.getCustomer(), customer);
        assertEquals(promisingCustomer.getVisitsCount(), visitCount);
        assertEquals(promisingCustomer.getPurchasesCount(), purchaseCount);
        assertEquals(promisingCustomer.getAverageVisitTime(), averageVisitTime);
        assertEquals(promisingCustomer.getDirectVisitsCount(), directVisitCount);
        assertEquals(promisingCustomer.getPurchasesSummaryCost(), purchaseSummaryCost);
    }

    private Customer customer(Long customerId) {
        return CustomerBuilder.get()
                .withCustomerId(customerId)
                .build();
    }
}