package com.springiscoming.util.comparators;

import com.springiscoming.model.other.facebook.FacebookComment;
import org.junit.Before;
import org.junit.Test;

import java.util.Date;
import java.util.Random;

import static org.junit.Assert.assertEquals;

/**
 * Created by winio_000 on 2016-06-05.
 */
public class FacebookCommentComparatorTest {

    public static final int ZERO = 0;
    public static final int MINUS_ONE = -1;
    public static final int ONE = 1;
    private FacebookCommentComparator facebookCommentComparator;

    @Before
    public void setUp() throws Exception {
        facebookCommentComparator = new FacebookCommentComparator();
    }

    @Test
    public void shouldReturnMinusOneWhenFirstCommentHasEarlierDate() throws Exception {
        FacebookComment comment1 = givenComment("comment1", new Date(2016, 5, 5), "user1");
        FacebookComment comment2 = givenComment("comment1", new Date(2016, 6, 6), "user1");

        int result = facebookCommentComparator.compare(comment1, comment2);

        assertEquals(result, MINUS_ONE);
    }

    @Test
    public void shouldReturnZeroWhenGivenCommentsHasEqualDates() throws Exception {
        Date givenDate = new Date(2016, 5, 5);
        FacebookComment comment1 = givenComment("comment1", givenDate, "user1");
        FacebookComment comment2 = givenComment("comment2", givenDate, "user2");

        int result = facebookCommentComparator.compare(comment1, comment2);

        assertEquals(result, ZERO);
    }

    @Test
    public void shouldReturnOneWhenFirstCommentHasLatterDate() throws Exception {
        FacebookComment comment1 = givenComment("comment1", new Date(2016, 5, 5), "user1");
        FacebookComment comment2 = givenComment("comment1", new Date(2016, 2, 2), "user1");

        int result = facebookCommentComparator.compare(comment1, comment2);

        assertEquals(result, ONE);
    }

    private FacebookComment givenComment(String comment, Date givenDate, String userName) {
        Random random = new Random();
        return new FacebookComment(comment, random.nextInt(100), random.nextInt(100), userName, givenDate);
    }
}