package com.springiscoming.util.comparators;

import com.springiscoming.model.other.facebook.FacebookReview;

import javax.inject.Named;
import java.util.Comparator;

@Named
public class FacebookReviewComparator implements Comparator<FacebookReview> {

    @Override
    public int compare(FacebookReview p1, FacebookReview p2) {
        return p1.getReviewAddDate().compareTo(p2.getReviewAddDate());
    }
}