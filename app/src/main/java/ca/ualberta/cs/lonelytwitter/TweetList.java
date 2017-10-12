package ca.ualberta.cs.lonelytwitter;

import java.util.ArrayList;

/**
 * Created by thomas on 2017-10-11.
 */

public class TweetList {
    private ArrayList<Tweet> tweets = new ArrayList<Tweet>();

    public TweetList(){};

    public void add(Tweet tweet){
        if (tweets.contains(tweet)){
            throw new IllegalArgumentException("trying to add a duplicate tweet");
        }
        tweets.add(tweet);
    }

    public boolean hasTweet(Tweet tweet){
        return tweets.contains(tweet);
    }

    public void delete(Tweet tweet){
        tweets.remove(tweet);
    }

    public Tweet getTweet(int index) {
        return tweets.get(index);
    }

    public ArrayList<Tweet> getTweets(){
        // very inefficient but this is only for participation marks in CMPUT 301
        ArrayList<Tweet> sortedTweets = new ArrayList<Tweet>();
        Tweet t = new NormalTweet("");
        long prevDate = tweets.get(0).getDate().getTime();
        for (int i=0; i<tweets.size(); i++){
            for (int j = 0; j<tweets.size(); j++){
                if (tweets.get(j).getDate().getTime() <= prevDate && !sortedTweets.contains(tweets.get(j))){
                    t = tweets.get(j);
                }
            }
            sortedTweets.add(t);
            prevDate = t.getDate().getTime();
        }
        return sortedTweets;
    }

    public int getCount(){
        return tweets.size();
    }
}
