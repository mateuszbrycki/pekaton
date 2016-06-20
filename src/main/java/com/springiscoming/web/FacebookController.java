package com.springiscoming.web;

import com.springiscoming.model.facebook.FacebookComment;
import com.springiscoming.model.facebook.FacebookLike;
import com.springiscoming.model.facebook.FacebookReview;
import com.springiscoming.service.facebook.FacebookService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Inject;
import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(path = "/facebook")
public class FacebookController {

    @Inject
    private FacebookService facebookService;

    @RequestMapping(path = "/likes", method = RequestMethod.GET)
    public List<FacebookLike> facebookLikes() {

        return facebookService.getFacebookLikesByDay();
    }

    @RequestMapping(path = "/comments", method = RequestMethod.GET)
    public List<FacebookComment> facebookComments() {
        return facebookService.getFacebookComments();
    }

    @RequestMapping(path = "/reviews", method = RequestMethod.GET)
    public List<FacebookReview> facebookReviews() {
        return facebookService.getFacebookReviews();
    }
}
