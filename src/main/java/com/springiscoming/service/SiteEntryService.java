package com.springiscoming.service;

import com.springiscoming.model.SiteEntry;
import com.springiscoming.model.SiteEntryStatistic;
import com.springiscoming.repository.SiteEntryRepository;
import com.springiscoming.util.SiteEntryComparator;
import org.springframework.stereotype.Service;


import javax.inject.Inject;
import java.util.Collections;
import java.util.List;

@Service
public class SiteEntryService {

    @Inject
    private SiteEntryRepository siteEntryRepository;

    @Inject
    private SiteEntryStatisticsService siteEntryStatisticsService;

    @Inject
    private SiteEntryComparator siteEntryComparator;

    public void save(SiteEntry siteEntry) {
        this.siteEntryRepository.save(siteEntry);
    }

    public List<SiteEntry> findAll() {
        return this.siteEntryRepository.findAll();
    }

    public Float getCustomerAverageVisitTime(Long customerId) {
        return this.siteEntryRepository.getCustomerAverageVisitTime(customerId);
    }

    public Integer getCustomerVisitsCounter(Long customerId) {
        return this.siteEntryRepository.getCustomerVisitsCounter(customerId);
    }

    public Integer getCustomerDirectVisitsCounter(Long customerId) {
        return this.siteEntryRepository.getCustomerDirectVisitsCounter(customerId);
    }

    public List<SiteEntryStatistic> getSiteEntryStatistics(List<SiteEntry> siteEntries) {
        List<SiteEntryStatistic> statistics = siteEntryStatisticsService.getStatistics(siteEntries);
        Collections.sort(statistics, siteEntryComparator);
        return statistics;
    }
}