package com.springiscoming.web;

import com.springiscoming.model.siteEntry.SiteEntry;
import com.springiscoming.model.siteEntry.SiteEntryStatistic;
import com.springiscoming.service.siteentry.SiteEntryService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Inject;
import java.util.List;

/**
 * Created by winio_000 on 2016-06-05.
 */

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/entry")
public class SiteEntryController {

    @Inject
    private SiteEntryService siteEntryService;

    @RequestMapping(method = RequestMethod.GET)
    public List<SiteEntry> getAll() {
        return siteEntryService.findAll();
    }

    @RequestMapping(path = "/statistics", method = RequestMethod.GET)
    public List<SiteEntryStatistic> getSiteEntryStatistics() {
        return siteEntryService.getSiteEntryStatistics(siteEntryService.findAll());
    }
}
