/*
 * Tweetable
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
 * Interface forcing tweets to have methods for getting message and date.
 *
 * @constraint getMessage()
 * @constraint getDate()
 *
 * @author thomas
 * @version 1.5
 * @see Tweet
 * @since 1.0
 *
 */
public interface Tweetable {
    public String getMessage();
    public Date getDate();
}
