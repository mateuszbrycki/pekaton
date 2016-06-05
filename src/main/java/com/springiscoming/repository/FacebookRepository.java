package com.springiscoming.repository;

import com.springiscoming.model.facebook.FacebookComment;
import com.springiscoming.model.facebook.FacebookReview;
import com.springiscoming.util.DateUtils;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class FacebookRepository {

    public List<FacebookComment> getFacebookComments() {
        List<FacebookComment> facebookComments = new ArrayList<>();

        facebookComments.add(new FacebookComment("Awesome idea!", 1, 2, "Noah Barton",DateUtils.generateRandomDate()));
        facebookComments.add(new FacebookComment("Great guys! Keep going!", 3, 0, "Glorinda Lamia",DateUtils.generateRandomDate()));
        facebookComments.add(new FacebookComment("It sucks", 0, 0, "Alejandro Mason", DateUtils.generateRandomDate()));
        facebookComments.add(new FacebookComment("U sure U wanna show it?", 5, 2, "Leah Baldwin",DateUtils.generateRandomDate()));
        facebookComments.add(new FacebookComment("Pizza time!", 10, 2, "Leon Yates",DateUtils.generateRandomDate()));

        return facebookComments;
    }

    public List<FacebookReview> getFacebookReviews() {
        List<FacebookReview> facebookReviews = new ArrayList<>();

        facebookReviews.add(new FacebookReview("I hope you succeed!", DateUtils.generateRandomDate(), 5, "Candace Mcbride"));
        facebookReviews.add(new FacebookReview("Nice looking but features aren't useful", DateUtils.generateRandomDate(), 2, "Olga Spencer"));
        facebookReviews.add(new FacebookReview("Very nice guys. 1/5!", DateUtils.generateRandomDate(), 1, "Ernest Harrington"));
        facebookReviews.add(new FacebookReview("Too expensive for my business.", DateUtils.generateRandomDate(), 3, "Saul Jacobs"));
        facebookReviews.add(new FacebookReview("I want you leave!", DateUtils.generateRandomDate(), 1, "Ronnie Ortiz"));

        return facebookReviews;
    }


}
