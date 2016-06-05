package com.springiscoming.service;

import com.springiscoming.model.facebook.FacebookComment;
import com.springiscoming.model.facebook.FacebookLike;
import com.springiscoming.model.facebook.FacebookReview;
import com.springiscoming.repository.FacebookRepository;
import com.springiscoming.util.DateUtils;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

@Service
public class FacebookService {

    @Inject
    private FacebookRepository facebookRepository;

    public List<FacebookLike> getFacebookLikesByDay() {

        List<FacebookLike> result = new ArrayList<>();

        List<Date> dates = DateUtils.generateRandomUniqueDates(10);

        Random random = new Random();
        for(Date date : dates) {
            Integer likes = random.nextInt((800 - 600) + 1) + 600;
            FacebookLike facebookLike = new FacebookLike(date, likes);
            result.add(facebookLike);
        }

        return result;
    }

    public List<FacebookReview> getFacebookReviews() {
        return this.facebookRepository.getFacebookReviews();
    }

    public List<FacebookComment> getFacebookComments() {
        return this.facebookRepository.getFacebookComments();
    }
}
