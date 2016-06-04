package com.springiscoming.service;

import com.springiscoming.model.SiteEntry;
import com.springiscoming.repository.SiteEntryRepository;
import org.jvnet.hk2.annotations.Service;

import javax.inject.Inject;
import java.util.List;

@Service
public class SiteEntryService {

    @Inject
    private SiteEntryRepository siteEntryRepository;

    public List<SiteEntry> findAll() {
        return this.siteEntryRepository.findAll();
    }

}
