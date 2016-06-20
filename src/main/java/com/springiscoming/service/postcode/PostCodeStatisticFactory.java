package com.springiscoming.service.postcode;

import com.springiscoming.exception.DistrictNotFound;
import com.springiscoming.model.postcode.PostCodeApi;
import com.springiscoming.model.postcode.PostCodeStatistic;
import org.springframework.stereotype.Component;

import javax.inject.Inject;
import java.util.List;

import static com.springiscoming.util.DistrictUtils.isDistrict;

@Component
public class PostCodeStatisticFactory {

    public static final int FIRST_ONE = 0;

    @Inject
    private PostCodeService postCodeService;

    public PostCodeStatistic createStatistic(String postCode, Long value) throws DistrictNotFound {
        List<PostCodeApi> postCodeApi = postCodeService.retrievePostcodes(postCode);

        if (isNotEmpty(postCodeApi)) {
            String district = district(postCodeApi);
            if (isDistrict(district)) {
                return new PostCodeStatistic(postCode, value, district);
            }
        }

        throw new DistrictNotFound();
    }

    private boolean isNotEmpty(List<PostCodeApi> postCodeApi) {
        return (!postCodeApi.isEmpty());
    }

    private String district(List<PostCodeApi> postCodeApi) {
        return postCodeApi.get(FIRST_ONE).getWojewodztwo();
    }
}
