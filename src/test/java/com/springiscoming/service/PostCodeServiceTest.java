package com.springiscoming.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.web.client.RestTemplate;

import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by winio_000 on 2016-06-09.
 */

@RunWith(MockitoJUnitRunner.class)
public class PostCodeServiceTest {

    @Mock
    private RestTemplate restTemplate;

    @InjectMocks
    private PostCodeService postCodeService;

    @Test
    public void shouldBuildProperRestQuery() throws Exception {
        String givenPostCode = "givenPostCode";
        setUpRestTemplate();

        postCodeService.retrievePostcodes(givenPostCode);

        verify(restTemplate).getForObject(PostCodeService.POSTCODE_PATH + givenPostCode, PostCodeService.POST_CODE_API_ARRAY_CLASS);
    }

    private void setUpRestTemplate() {
        when(restTemplate.getForObject(anyString(), any())).thenReturn(new Object[]{});
    }
}