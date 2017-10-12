package ca.ualberta.cs.lonelytwitter;
import android.test.ActivityInstrumentationTestCase2;

import java.util.ArrayList;

/**
 * Created by thomas on 2017-10-11.
 */

public class TweetListTest extends ActivityInstrumentationTestCase2{
    public TweetListTest(){
        super(ca.ualberta.cs.lonelytwitter.LonelyTwitterActivity.class);
    }

    public void testAddTweet(){
        TweetList tweets = new TweetList();
        Tweet tweet = new NormalTweet("adding tweet");
        tweets.add(tweet);
        assertTrue(tweets.hasTweet(tweet));
    }

    public void testDelete(){
        TweetList tweets = new TweetList();
        Tweet tweet = new NormalTweet("test");
        tweets.add(tweet);
        tweets.delete(tweet); // do you have to assert that it was properly added first?
        assertFalse(tweets.hasTweet(tweet));
    }

    public void testHasTweet(){
        TweetList list = new TweetList();
        Tweet tweet = new NormalTweet("test");
        list.add(tweet);
        assertTrue(list.hasTweet(tweet));
    }

    public void testGetTweet(){
        TweetList list = new TweetList();
        Tweet tweet = new NormalTweet("test");
        list.add(tweet);
        Tweet returnedTweet = list.getTweet(0);
        assertEquals(returnedTweet.getMessage(), tweet.getMessage());
    }

    public void testAddDuplicateTweet(){
        TweetList list = new TweetList();
        Tweet tweet = new NormalTweet("adding tweet");
        list.add(tweet);
        list.add(tweet);
//        assertTrue(tweets.hasTweet(tweet));
//        assertTrue(tweets.); // exception is thrown so this line doesn't matter and is not necessarily the right assertion anyways
    }

    public void testGetTweets(){
        TweetList list = new TweetList();
        Tweet tweet1 = new NormalTweet("First");
        Tweet tweet2 = new NormalTweet("Second");
        list.add(tweet2);
        list.add(tweet1);
        ArrayList<Tweet> returnedList = list.getTweets();
        ArrayList<Tweet> correctType = new ArrayList<Tweet>();

        assertEquals(returnedList.getClass().getName(), correctType.getClass().getName());

        long prevDate = returnedList.get(0).getDate().getTime();
        for (int i = 0; i<returnedList.size();i++){
            assertTrue(returnedList.get(i).getDate().getTime()<=prevDate);
            prevDate = returnedList.get(i).getDate().getTime();
        }

        assertFalse(returnedList.get(0).getDate().getTime() > returnedList.get(1).getDate().getTime());
    }

    public void testGetCount(){
        TweetList list = new TweetList();
        Tweet tweet1 = new NormalTweet("1");
        Tweet tweet2 = new NormalTweet("2");
        list.add(tweet1);
        list.add(tweet2);
        int count = 2;
        assertEquals(count, list.getCount());
    }
}
