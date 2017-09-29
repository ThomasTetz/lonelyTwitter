/*
 * Tweet
 *
 * Version 1.0
 *
 * September 27, 2017
 *
 * Copyright (c) 2017. Thomas Tetz, CMPUT301, University of Alberta - All Rights Reserved.
 * You may use, distribute, or modify this code under terms and conditions of the Code of Student Behaviour at University of Alberta.
 * You can find a copy of the license in this project. Otherwise please contact ttetz@ualberta.ca.
 *
 */

/*
 * Javadoc:
 * classes/interfaces
 * constructors
 * methods
 *
 */

package ca.ualberta.cs.lonelytwitter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by thomas on 2017-09-13.
 */

/**
 * Represents a tweet.
 *
 * @author thomas
 * @version 1.5
 * @see NormalTweet
 * @see ImportantTweet
 * @since 1.0
 */
public abstract class Tweet implements Tweetable{
    // can implement multiple but only extend one
    private String message;
    private Date date;

    private List moods = new ArrayList();

    /**
     * Adds a mood to list of moods for tweet.
     *
     * @param mood the mood to be added
     */
    public void addMood(Mood mood){
        this.moods.add(mood);
    }

//    protected int i; // if class inherits Tweet it will inherit protected i, not privates

    /**
     * Constructs a Tweet object.
     *
     * @param message tweet message
     */
    public Tweet(String message){
        date = new Date();
//        message = message; // warning: two variables with diff scopes but same name
        this.message = message; // specifies the passed value
    }

    /**
     * Constructs a Tweet object.
     *
     * @param message tweet message
     * @param date tweet date
     */
    public Tweet(String message, Date date){
        this.date = date;
        this.message = message;
    }

    /**
     * Gets the tweet message
     *
     * @return message tweet message
     */
    public String getMessage(){
        return message;
    }

    /**
     * Sets the tweet message.
     *
     * @param message tweet message
     * @throws TweetTooLongException
     */
    public void setMessage(String message) throws TweetTooLongException{
        if (message.length() < 140){
            this.message = message;
        }
        else{
            throw new TweetTooLongException();
        }
    }

    /**
     * Gets the tweet date.
     *
     * @return date
     */
    public Date getDate() {
        return date;
    }

    /**
     * Sets the tweet date.
     *
     * @param date
     */
    public void setDate(Date date) {
        this.date = date;
    }

    public abstract Boolean isImportant();

    /**
     * Returns string representation of tweet.
     *
     * @return string of tweet
     */
    @Override
    public String toString(){
        return date.toString() + " | " + message;
    }

}

