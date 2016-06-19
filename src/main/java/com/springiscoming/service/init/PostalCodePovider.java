package com.springiscoming.service.init;

import javax.inject.Named;
import java.util.List;

import static java.util.Arrays.asList;

/**
 * Created by winio_000 on 2016-06-05.
 */

@Named
public class PostalCodePovider {
    private List<String> postalCodes = asList("52-019", "54-406", "02-169", "39-400", "51-126",
            "70-509", "26-700", "61-502", "04-359", "41-100", "03-632", "36-205", "80-052", "30-613",
            "10-536", "35-060", "40-583", "26-601", "42-400", "31-332", "61-679", "04-744", "80-042",
            "37-430", "02-808", "41-219", "70-789", "91-002", "01-184", "85-479", "85-106", "80-821",
            "04-849", "45-307", "33-340", "41-219", "33-105", "91-480", "83-403", "33-300", "50-028",
            "54-517", "50-971", "39-124");

    public List<String> postalCodes() {
        return postalCodes;
    }
}
