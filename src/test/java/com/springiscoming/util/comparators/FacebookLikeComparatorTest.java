package com.springiscoming.util.comparators;

import com.springiscoming.model.other.facebook.FacebookLike;
import org.junit.Before;
import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.assertEquals;

/**
 * Created by winio_000 on 2016-06-05.
 */

public class FacebookLikeComparatorTest {

    public static final int MINUS_ONE = -1;
    public static final int ZERO = 0;
    public static final int ONE = 1;
    private FacebookLikeComparator facebookLikeComparator;

    @Before
    public void setUp() throws Exception {
        facebookLikeComparator = new FacebookLikeComparator();
    }

    @Test
    public void shouldReturnMinusOneWhenFirstLikeHasEarlierDate() throws Exception {
        FacebookLike like1 = givenLike(new Date(2016, 2, 2));
        FacebookLike like2 = givenLike(new Date(2016, 4, 4));

        int result = facebookLikeComparator.compare(like1, like2);

        assertEquals(result, MINUS_ONE);
    }

    @Test
    public void shouldReturnZeroWhenGivenLikesHasEqualDate() throws Exception {
        Date date = new Date(2016, 2, 2);
        FacebookLike like1 = givenLike(date);
        FacebookLike like2 = givenLike(date);

        int result = facebookLikeComparator.compare(like1, like2);

        assertEquals(result, ZERO);
    }

    @Test
    public void shouldReturnOneWhenFirstLikeHasLatterDate() throws Exception {
        FacebookLike like1 = givenLike(new Date(2016, 5, 5));
        FacebookLike like2 = givenLike(new Date(2016, 1, 1));

        int result = facebookLikeComparator.compare(like1, like2);

        assertEquals(result, ONE);
    }

    private FacebookLike givenLike(Date date) {
        return new FacebookLike(date, 100);
    }
}