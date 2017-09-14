package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * Created by thomas on 2017-09-13.
 */

// can implement multiple but only extend one
public abstract class Tweet implements Tweetable{
    private String message;
    private Date date;
//    protected int i; // if class inherits Tweet it will inherit protected i, not privates

    public Tweet(String message){
        date = new Date();
//        message = message; // warning: two variables with diff scopes but same name
        this.message = message; // specifies the passed value
    }

    public Tweet(String message, Date date){
        this.date = date;
        this.message = message;
    }

    public String getMessage(){
        return message;
    }

    public void setMessage(String message) throws TweetTooLongException{
        if (message.length() < 140){
            this.message = message;
        }
        else{
            throw new TweetTooLongException();
        }
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public abstract Boolean isImportant();

}

