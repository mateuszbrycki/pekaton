package com.springiscoming.service;

import com.springiscoming.model.Customer;
import com.springiscoming.model.SiteEntry;
import com.springiscoming.model.SiteEntryStatistic;
import com.springiscoming.util.DateFormatter;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by winio_000 on 2016-06-05.
 */

@Service
public class SiteEntryStatisticsService {

    @Inject
    private DateFormatter dateFormatter;

    private static Map<String, Integer> entriesCounter = new HashMap<>();
    private static Map<String, HashSet<Customer>> activeUsersCounter = new HashMap<>();
    private static Map<String, List<Integer>> averageTimeCounter = new HashMap<>();

    public List<SiteEntryStatistic> getStatistics(List<SiteEntry> siteEntries) {
        for (SiteEntry siteEntry : siteEntries) {

            Date orderDate = siteEntry.getEntryDate();
            String formattedDate = formatDate(orderDate);
            Integer visitTime = siteEntry.getVisitTime();
            Customer customer = siteEntry.getCustomer();
            if (entriesCounter.containsKey(formattedDate)) {
                incrementSiteEntries(formattedDate);
                incrementVisitTimes(formattedDate, visitTime);
                incrementActiveUsers(formattedDate, customer);
            } else {
                entriesCounter.put(formattedDate, 1);
                initializeActiveCustomers(formattedDate, customer);
                initializeTimes(formattedDate, visitTime);
            }
        }
        return entriesCounter.keySet().stream().map(s -> new SiteEntryStatistic(s, entriesCounter.get(s), activeUsersCounter.get(s).size(), getAverageTime(s))).collect(Collectors.toList());
    }

    private void incrementActiveUsers(String formattedDate, Customer customer) {
        HashSet<Customer> customers = activeUsersCounter.get(formattedDate);
        customers.add(customer);
        activeUsersCounter.put(formattedDate, customers);
    }

    private void initializeTimes(String formattedDate, Integer visitTime) {
        ArrayList<Integer> times = new ArrayList<>();
        times.add(visitTime);
        averageTimeCounter.put(formattedDate, times);
    }

    private void initializeActiveCustomers(String formattedDate, Customer customer) {
        HashSet<Customer> customers = new HashSet<>();
        customers.add(customer);
        activeUsersCounter.put(formattedDate, customers);
    }

    private void incrementSiteEntries(String formattedDate) {
        Integer counter = entriesCounter.get(formattedDate);
        entriesCounter.put(formattedDate, ++counter);
    }

    private Double getAverageTime(String formattedDate) {
        List<Integer> timesPerDate = averageTimeCounter.get(formattedDate);
        int result = 0;

        for (Integer visitTime : timesPerDate) {
            result += visitTime;
        }
        return (double) (result / timesPerDate.size());
    }

    private void incrementVisitTimes(String formattedDate, Integer visitTime) {
        List<Integer> times = averageTimeCounter.get(formattedDate);
        times.add(visitTime);
        averageTimeCounter.put(formattedDate, times);
    }

    private String formatDate(Date orderDate) {
        return dateFormatter.formatDate(orderDate);
    }
}
