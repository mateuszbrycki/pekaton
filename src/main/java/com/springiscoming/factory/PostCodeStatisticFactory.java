package com.springiscoming.factory;

import com.springiscoming.exception.DistrictNotFound;
import com.springiscoming.model.postcode.PostCodeApi;
import com.springiscoming.model.postcode.PostCodeStatistic;
import com.springiscoming.repository.PostCodeRepository;
import com.springiscoming.util.DistrictUtils;
import org.springframework.stereotype.Component;

import javax.inject.Inject;

@Component
public class PostCodeStatisticFactory {

    @Inject
    private PostCodeRepository postCodeRepository;

    public PostCodeStatistic create(String postCode, Long value) throws DistrictNotFound {

        PostCodeApi[] quote = postCodeRepository.getCodeInformation(postCode);

        if(quote.length > 0) {
            String district = quote[0].getWojewodztwo();
            if(DistrictUtils.isDistrict(district)) {
                return new PostCodeStatistic(postCode, value, district);
            }
        }

        throw new DistrictNotFound();
    }
}
