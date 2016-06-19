package com.springiscoming.factory;

import com.springiscoming.model.postcode.PostCodeApi;
import com.springiscoming.model.postcode.PostCodeStatistic;
import com.springiscoming.service.PostCodeService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static java.util.Arrays.asList;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertSame;
import static org.mockito.Mockito.when;

/**
 * Created by winio_000 on 2016-06-09.
 */

@RunWith(MockitoJUnitRunner.class)
public class PostCodeStatisticFactoryTest {

    @Mock
    private PostCodeService postCodeService;

    @InjectMocks
    private PostCodeStatisticFactory postCodeStatisticFactory;

    @Test
    public void shouldReturnProperPostCodeStatistics() throws Exception{
        Long value = 1L;
        String postCode = "31-312";
        String city = "Kraków";
        String adress = "Lentza 6";
        String commune = "Kraków";
        String county = "Krakowski";
        String province = "Małopolskie";
        PostCodeApi postCodeApi = postCodeApi(postCode, city, adress, commune, county, province);
        when(postCodeService.retrievePostcodes(postCode)).thenReturn(asList(postCodeApi));

        PostCodeStatistic postCodeStatistic = postCodeStatisticFactory.createStatistic(postCode, value);

        assertNotNull(postCodeStatistic);
        assertEquals(postCodeStatistic.getDistrict(), province);
        assertEquals(postCodeStatistic.getPostCode(), postCode);
        assertEquals(postCodeStatistic.getValue(), value);
    }

    private PostCodeApi postCodeApi(String postCode, String city, String adress, String commune, String county, String province) {
        return new PostCodeApi(postCode, city, adress, commune, county, province);
    }
}