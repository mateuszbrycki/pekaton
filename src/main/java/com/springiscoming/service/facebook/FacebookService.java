package com.springiscoming.service.facebook;

import com.springiscoming.model.facebook.FacebookComment;
import com.springiscoming.model.facebook.FacebookLike;
import com.springiscoming.model.facebook.FacebookReview;
import com.springiscoming.repository.FacebookRepository;
import com.springiscoming.util.DateUtils;
import com.springiscoming.util.comparators.FacebookCommentComparator;
import com.springiscoming.util.comparators.FacebookLikeComparator;
import com.springiscoming.util.comparators.FacebookReviewComparator;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.*;

@Service
public class FacebookService {

    @Inject
    private FacebookRepository facebookRepository;

    @Inject
    private FacebookLikeComparator facebookLikeComparator;

    @Inject
    private FacebookReviewComparator facebookReviewComparator;

    @Inject
    private FacebookCommentComparator facebookCommentComparator;

    public List<FacebookLike> getFacebookLikesByDay() {

        List<FacebookLike> result = new ArrayList<>();

        List<Date> dates = DateUtils.generateRandomUniqueDates(10);

        Random random = new Random();
        for (Date date : dates) {
            Integer likes = random.nextInt((800 - 600) + 1) + 600;
            FacebookLike facebookLike = new FacebookLike(date, likes);
            result.add(facebookLike);
        }

        Collections.sort(result, facebookLikeComparator);

        return result;
    }

    public List<FacebookReview> getFacebookReviews() {
        List<FacebookReview> facebookReviews = this.facebookRepository.getFacebookReviews();
        Collections.sort(facebookReviews, facebookReviewComparator);
        return facebookReviews;
    }

    public List<FacebookComment> getFacebookComments() {
        List<FacebookComment> facebookComments = this.facebookRepository.getFacebookComments();
        Collections.sort(facebookComments, facebookCommentComparator);
        return facebookComments;
    }
}
