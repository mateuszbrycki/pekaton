package com.springiscoming.service.promising;


import com.springiscoming.exception.InvalidArgumentException;
import org.apache.log4j.Logger;

import javax.inject.Named;
import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

import static java.lang.Math.pow;
import static java.util.Arrays.asList;

@Named
public class FactorCalculator {

    private static final Logger LOGGER = Logger.getLogger(FactorCalculator.class);
    public static final int POWER_EXPONENT = 2;
    public static final float VISIT_COUNT_FACTOR = 0.1f;
    public static final float VISIT_TIME_FACTOR = 0.2f;
    public static final float PURCHASE_COUNT_FACTOR = 0.4f;
    public static final float PURCHASE_PROPORTION_FACTOR = 0.5f;

    public Float computeFactor(Float averageVisitTime, Integer visitCount, Integer directVisitCount, Integer purchaseCount, Float purchaseSummaryCost) {
        checkNullArguments(averageVisitTime, visitCount, directVisitCount, purchaseCount, purchaseSummaryCost);
        Float visitCountFactor = visitCounterFactor(visitCount);
        Float directVisitFactor = directVisitFactor(directVisitCount);
        Float averageVisitFactor = averageVisitFactor(averageVisitTime);
        Float purchaseCountFactor = purchaseCountFactor(purchaseCount);
        Float purchaseProportionFactor = purchaseProportionFactor(purchaseCount, purchaseSummaryCost);

        return (purchaseCountFactor * directVisitFactor * purchaseProportionFactor * averageVisitFactor) / (visitCountFactor * 100);
    }

    private void checkNullArguments(Float averageVisitTime, Integer visitCount, Integer directVisitCount, Integer purchaseCount, Float purchaseSummaryCost) {
        List<Object> nulls = getNulls(averageVisitTime, visitCount, directVisitCount, purchaseCount, purchaseSummaryCost);
        if (!nulls.isEmpty()) {
            String msg = "Error while computing factor. Given arguments are null : " + nulls;
            LOGGER.error(msg);
            throw new InvalidArgumentException(msg);
        }
    }

    private List<Object> getNulls(Object... objects) {
        return asList(objects).stream().filter(o -> o == null).collect(Collectors.toList());
    }

    private float visitCounterFactor(Integer visitCount) {
        BigDecimal poweredVisitCount = new BigDecimal(toThePower(visitCount, POWER_EXPONENT));
        return poweredVisitCount.floatValue() * VISIT_COUNT_FACTOR;
    }

    private float directVisitFactor(Integer directVisitCount) {
        return directVisitCount * VISIT_COUNT_FACTOR;
    }

    private float averageVisitFactor(Float averageVisitTime) {
        return averageVisitTime * VISIT_TIME_FACTOR;
    }

    private float purchaseCountFactor(Integer purchaseCount) {
        return purchaseCount * PURCHASE_COUNT_FACTOR;
    }

    private float purchaseProportionFactor(Integer purchaseCount, Float purchaseSummaryCost) {
        return (purchaseSummaryCost / purchaseCount) * PURCHASE_PROPORTION_FACTOR;
    }

    private double toThePower(Integer visitCount, int powerExponent) {
        return pow(visitCount.doubleValue(), powerExponent);
    }
}