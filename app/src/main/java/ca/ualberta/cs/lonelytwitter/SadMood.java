package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * Created by thomas on 2017-09-13.
 */

public class SadMood extends Mood{
    public SadMood(){
        super();
    }

    public SadMood(Date date){
        super(date);
    }

    @Override
    public String getMoodString(){
        return "Sad";
    }
}
