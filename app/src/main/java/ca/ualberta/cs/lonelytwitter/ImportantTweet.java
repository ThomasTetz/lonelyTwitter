/*
 * ImportantTweet
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

package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * Created by thomas on 2017-09-13.
 */

/**
 * Represents an important tweet.
 *
 * @author thomas
 * @version 1.5
 * @see Tweet
 * @since 1.0
 */
public class ImportantTweet extends Tweet {
    /**
     * Constructs an ImportantTweet object.
     *
     * @param message tweet message
     */
    public ImportantTweet(String message){
        super(message);
    }

    /**
     * Constructs an ImportantTweet object.
     *
     * @param message tweet message
     * @param date tweet date
     */
    public ImportantTweet(String message, Date date){
        super(message, date);
    }


    /**
     * Returns if the tweet is important
     *
     * @return boolean if important. Should be true.
     */
    @Override
    public Boolean isImportant(){
        return Boolean.TRUE;
    }
}
