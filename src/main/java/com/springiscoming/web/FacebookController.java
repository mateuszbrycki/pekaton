package com.springiscoming.web;

import org.springframework.social.connect.ConnectionRepository;
import org.springframework.social.facebook.api.Facebook;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.inject.Inject;

/**
 * Created by Mateusz on 04.06.2016.
 */
@Controller
public class FacebookController {

    //    @Inject
    private Facebook facebook;

    //    @Inject
    private ConnectionRepository connectionRepository;

    @Inject
    public FacebookController(Facebook facebook, ConnectionRepository connectionRepository) {
        this.facebook = facebook;
        this.connectionRepository = connectionRepository;
    }


    @RequestMapping(path ="/facebook", method = RequestMethod.GET)
    public String facebook() {
        if (connectionRepository.findPrimaryConnection(Facebook.class) == null) {
            return "redirect:/connect/facebook";
        }

        String firstName = facebook.userOperations().getUserProfile().getFirstName();
        return firstName;

    }
}
