package com.springiscoming.service;

import com.springiscoming.model.entity.SiteEntry;
import com.springiscoming.model.other.statistic.SiteEntryStatistic;
import com.springiscoming.repository.SiteEntryRepository;
import com.springiscoming.util.comparators.SiteEntryComparator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.Collections;
import java.util.List;

@Service
public class SiteEntryService {

    private static final Logger LOGGER = LoggerFactory.getLogger(SiteEntryService.class);

    @Inject
    private SiteEntryRepository siteEntryRepository;

    @Inject
    private SiteEntryStatisticsService siteEntryStatisticsService;

    @Inject
    private SiteEntryComparator siteEntryComparator;

    public void save(SiteEntry siteEntry) {
        try {
            this.siteEntryRepository.save(siteEntry);
        } catch (Exception e) {
            LOGGER.error("Could not save given entity [{}].", siteEntry);
            throw e;
        }
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