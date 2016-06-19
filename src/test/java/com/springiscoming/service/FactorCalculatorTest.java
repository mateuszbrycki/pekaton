package com.springiscoming.service;

import com.springiscoming.exception.InvalidArgumentException;
import org.junit.Test;

/**
 * Created by winio_000 on 2016-06-19.
 */
public class FactorCalculatorTest {

    @Test(expected = InvalidArgumentException.class)
    public void shouldThrowInvalidArgumentExceptionWhenGivenAverageVisitTimeIsNull() throws Exception {
        FactorCalculator factorCalculator = new FactorCalculator();

        factorCalculator.computeFactor(null, 1, 1, 1, 1f);
    }

    @Test(expected = InvalidArgumentException.class)
    public void shouldThrowInvalidArgumentExceptionWhenGivenVisitCountIsNull() throws Exception {
        FactorCalculator factorCalculator = new FactorCalculator();

        factorCalculator.computeFactor(1f, null, 1, 1, 1f);
    }

    @Test(expected = InvalidArgumentException.class)
    public void shouldThrowInvalidArgumentExceptionWhenGivenDirectVisitCountIsNull() throws Exception {
        FactorCalculator factorCalculator = new FactorCalculator();

        factorCalculator.computeFactor(1f, 1, null, 1, 1f);
    }

    @Test(expected = InvalidArgumentException.class)
    public void shouldThrowInvalidArgumentExceptionWhenGivenPurchaseCountIsNull() throws Exception {
        FactorCalculator factorCalculator = new FactorCalculator();

        factorCalculator.computeFactor(1f, 1, 1, null, 1f);
    }

    @Test(expected = InvalidArgumentException.class)
    public void shouldThrowInvalidArgumentExceptionWhenGivenPurchaseSummaryCostIsNull() throws Exception {
        FactorCalculator factorCalculator = new FactorCalculator();

        factorCalculator.computeFactor(1f, 1, 1, 1, null);
    }
}