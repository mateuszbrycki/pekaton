package com.springiscoming.util.comparators;

import com.springiscoming.model.purchase.PurchaseStatistic;
import com.springiscoming.util.DateFormatter;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.Comparator;
import java.util.Date;

/**
 * Created by winio_000 on 2016-06-05.
 */

@Named
public class PurchaseComparator implements Comparator<PurchaseStatistic> {

    @Inject
    private DateFormatter dateFormatter;

    @Override
    public int compare(PurchaseStatistic p1, PurchaseStatistic p2) {
        String purchaseDate1 = p1.getPurchaseDate();
        String purchaseDate2 = p2.getPurchaseDate();
        Date formattedDate1 = dateFormatter.format(purchaseDate1);
        Date formattedDate2 = dateFormatter.format(purchaseDate2);

        return formattedDate1.compareTo(formattedDate2);
    }
}
