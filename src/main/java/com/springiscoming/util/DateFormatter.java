package com.springiscoming.util;

import org.joda.time.DateTime;

import javax.inject.Named;
import java.util.Date;

@Named
public class DateFormatter {

    public String formatDate(Date orderDate) {
        return new DateTime(orderDate).toString("yyyy/MM/dd");
    }

    public Date format(String date) {
        return new Date(date);
    }
}