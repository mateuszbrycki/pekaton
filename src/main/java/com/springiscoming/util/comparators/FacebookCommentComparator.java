package com.springiscoming.util.comparators;

import com.springiscoming.model.other.facebook.FacebookComment;

import javax.inject.Named;
import java.util.Comparator;

@Named
public class FacebookCommentComparator implements Comparator<FacebookComment> {

    @Override
    public int compare(FacebookComment p1, FacebookComment p2) {
        return p1.getAddDate().compareTo(p2.getAddDate());
    }
}
