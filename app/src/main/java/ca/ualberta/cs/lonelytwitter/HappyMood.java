package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * Created by thomas on 2017-09-13.
 */

public class HappyMood extends Mood{
    public HappyMood(){
        super();
    }

    public HappyMood(Date date){
        super(date);
    }

    @Override
    public String getMoodString(){
        return "Happy";
    }
}
