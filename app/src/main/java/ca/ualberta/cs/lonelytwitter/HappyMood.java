/*
 * HappyMood
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
 * Represents a happy mood.
 *
 * @author thomas
 * @version 1.5
 * @see HappyMood, SadMood
 * @since 1.0
 *
 */
public class HappyMood extends Mood{
    /**
     * Constructs a HappyMood object.
     *
     */
    public HappyMood(){
        super();
    }

    /**
     * Constructs a HappyMood object.
     *
     * @param date mood date
     */
    public HappyMood(Date date){
        super(date);
    }

    /**
     * Returns string representation of mood.
     *
     * @return string of mood
     */
    @Override
    public String getMoodString(){
        return "Happy";
    }
}
