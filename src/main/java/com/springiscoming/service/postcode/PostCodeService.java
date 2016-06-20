package com.springiscoming.service.postcode;

import com.springiscoming.model.postcode.PostCodeApi;
import org.springframework.web.client.RestTemplate;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

import static java.util.Arrays.asList;

/**
 * Created by winio_000 on 2016-06-09.
 */

@Named
public class PostCodeService {

    public static final String POSTCODE_PATH = "http://kodypocztoweapi.pl/";
    public static final Class<PostCodeApi[]> POST_CODE_API_ARRAY_CLASS = PostCodeApi[].class;

    @Inject
    private RestTemplate restTemplate;

    public List<PostCodeApi> retrievePostcodes(String postCode) {
        return asList(restTemplate.getForObject(POSTCODE_PATH + postCode, POST_CODE_API_ARRAY_CLASS));
    }
}