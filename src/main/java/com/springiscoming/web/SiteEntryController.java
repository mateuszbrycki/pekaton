package com.springiscoming.web;

import com.springiscoming.model.SiteEntry;
import com.springiscoming.model.SiteEntryStatistic;
import com.springiscoming.service.SiteEntryService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Inject;
import java.util.List;

/**
 * Created by winio_000 on 2016-06-05.
 */

@RestController
public class SiteEntryController {

    @Inject
    private SiteEntryService siteEntryService;

    @RequestMapping(path = "/entry", method = RequestMethod.GET)
    public List<SiteEntry> getAll() {
        return siteEntryService.findAll();
    }

    @RequestMapping(path = "/entry/statistics", method = RequestMethod.GET)
    public List<SiteEntryStatistic> getSiteEntryStatistics() {
        return siteEntryService.getSiteEntryStatistics(siteEntryService.findAll());
    }
}
