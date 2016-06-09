package com.springiscoming.repository;

import com.springiscoming.model.postcode.PostCodeApi;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

/**
 * Created by Mateusz on 09.06.2016.
 */
@Repository
public class PostCodeRepository {

    private RestTemplate restTemplate;

    public PostCodeRepository() {
        this.restTemplate = new RestTemplate();
    }

    public PostCodeApi[] getCodeInformation(String postCode) {
        PostCodeApi[] result = restTemplate.getForObject("http://kodypocztoweapi.pl/" + postCode,PostCodeApi[].class);
        return result;
    }

}
