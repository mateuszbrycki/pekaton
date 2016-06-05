package com.springiscoming.util.comparators;

import com.springiscoming.model.SiteEntryStatistic;
import com.springiscoming.util.DateFormatter;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.Comparator;
import java.util.Date;

/**
 * Created by winio_000 on 2016-06-05.
 */

@Named
public class SiteEntryComparator implements Comparator<SiteEntryStatistic>{

    @Inject
    private DateFormatter dateFormatter;

    @Override
    public int compare(SiteEntryStatistic s1, SiteEntryStatistic s2) {

        String s1Date = s1.getEntryDate();
        String s2Date = s2.getEntryDate();

        Date formattedDate1 = dateFormatter.format(s1Date);
        Date formattedDate2 = dateFormatter.format(s2Date);
        return formattedDate1.compareTo(formattedDate2);
    }
}
