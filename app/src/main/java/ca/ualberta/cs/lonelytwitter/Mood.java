/*
 * Mood
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
 * Represents a mood.
 *
 * @author thomas
 * @version 1.5
 * @see HappyMood, SadMood
 * @since 1.0
 *
 */
public abstract class Mood{
    private Date date;

    /**
     * Constructs a Mood object.
     *
     */
    public Mood(){
        this.date = new Date();
    }

    /**
     * Constructs a Mood object.
     *
     * @param date mood date
     */
    public Mood(Date date){
        this.date = date;
    }

    /**
     * Sets the mood date
     *
     * @param date mood date
     */
    public void setDate(Date date){
        this.date = date;
    }

    /**
     *
     *  Gets the mood date
     *
     * @return mood date
     */
    public Date getDate(){
        return date;
    }

    public abstract String getMoodString();

}


