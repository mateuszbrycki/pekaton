package com.springiscoming.factory;

import com.springiscoming.exception.DistrictNotFound;
import com.springiscoming.model.postcode.PostCodeApi;
import com.springiscoming.model.postcode.PostCodeStatistic;
import com.springiscoming.util.DistrictUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class PostCodeStatisticFactory {

    public PostCodeStatistic create(String postCode, Long value) throws DistrictNotFound {

        RestTemplate restTemplate = new RestTemplate();
        PostCodeApi[] quote = restTemplate.getForObject("http://kodypocztoweapi.pl/" + postCode,PostCodeApi[].class);

        if(quote.length > 0) {
            String district = quote[0].getWojewodztwo();
            if(DistrictUtils.isDistrict(district)) {
                return new PostCodeStatistic(postCode, value, district);
            }
        }

        throw new DistrictNotFound();
    }
}
