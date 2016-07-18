package com.springiscoming.util.comparators;

import com.springiscoming.model.other.facebook.FacebookLike;

import javax.inject.Named;
import java.util.Comparator;

@Named
public class FacebookLikeComparator implements Comparator<FacebookLike> {

    @Override
    public int compare(FacebookLike p1, FacebookLike p2) {
        return p1.getDay().compareTo(p2.getDay());
    }
}
