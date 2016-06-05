package com.springiscoming.model;

/**
 * Created by winio_000 on 2016-06-05.
 */
public class SiteEntryStatistic {

    private final String entryDate;
    private final Integer counter;
    private final Integer activeUsers;
    private final Double averageEntryTime;

    public SiteEntryStatistic(String entryDate, Integer counter, Integer activeusers, Double averageEntryTime) {
        this.entryDate = entryDate;
        this.counter = counter;
        this.activeUsers = activeusers;
        this.averageEntryTime = averageEntryTime;
    }

    public String getEntryDate() {
        return entryDate;
    }

    public Integer getCounter() {
        return counter;
    }

    public Integer getActiveUsers() {
        return activeUsers;
    }

    public Double getAverageEntryTime() {
        return averageEntryTime;
    }

}
