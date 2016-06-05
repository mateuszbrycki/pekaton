package com.springiscoming.util;

import java.util.*;

/**
 * Created by Mateusz on 05.06.2016.
 */
public class DateUtils {

    public static Date generateRandomDate() {
        Random call = new Random();
        int month = call.nextInt(Calendar.FEBRUARY) + Calendar.JANUARY;
        int year = 2016;
        int day = call.nextInt(5) + 0;
        GregorianCalendar calendar = new GregorianCalendar(year, month, day);
        return calendar.getTime();
    }

    public static List<Date> generateRandomUniqueDates(Integer n) {
        List<Date> result = new ArrayList<>();

        Integer i = 0;
        while(i < n) {
            Date date = generateRandomDate();
            if(!result.contains(date)) {
                result.add(date);
                i++;
            }
        }

        return result;
    }
}
