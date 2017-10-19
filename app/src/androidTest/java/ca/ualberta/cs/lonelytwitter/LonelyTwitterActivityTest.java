package ca.ualberta.cs.lonelytwitter;

import android.app.Activity;
import android.test.ActivityInstrumentationTestCase2;
import android.widget.EditText;

import com.robotium.solo.Solo;

import junit.framework.TestCase;

public class LonelyTwitterActivityTest extends ActivityInstrumentationTestCase2<LonelyTwitterActivity> {

    private Solo solo;


    public LonelyTwitterActivityTest() {
        super(ca.ualberta.cs.lonelytwitter.LonelyTwitterActivity.class);
    }

    /**
     * Runs at the beginning of the tests
     * @throws Exception
     */
    public void setUp() throws Exception {
        solo = new Solo(getInstrumentation(), getActivity());
    }

    public void testStart() throws Exception {
        Activity activity = getActivity();
    }


    public void testTweet() {
        // checks that activity is LonelyTwitterActivity
        solo.assertCurrentActivity("Wrong Activity", LonelyTwitterActivity.class);
        // adds text  to EditText
        solo.enterText((EditText) solo.getView(R.id.body), "Test Tweet!");
        solo.clickOnButton("Save");
        solo.enterText((EditText) solo.getView(R.id.body), "");

        assertTrue(solo.waitForText("Test Tweet!"));

        solo.clickOnButton("Clear");
//        solo.enterText((EditText) solo.getView(R.id.body), "Test Tweet!");

    }

    public void testClickTweetList(){
        // checks tht in LonelyTwitter activity
        solo.assertCurrentActivity("WrongActivity", LonelyTwitterActivity.class);
        solo.clickOnButton("Clear");

        solo.enterText((EditText) solo.getView(R.id.body), "Test Tweet!");
        solo.clickOnButton("Save");
        // wait for it to appear in list after save
        solo.waitForText("Test Tweet!");

        solo.clickInList(0); // first item in list
        solo.assertCurrentActivity("Wrong Activity", EditTweetActivity.class);
    }

    public void testClickTweetListExercise(){
        // checks tht in LonelyTwitter activity
        solo.assertCurrentActivity("WrongActivity", LonelyTwitterActivity.class);
        solo.clickOnButton("Clear");
        String testTweetString = "Test Tweet!";
        solo.enterText((EditText) solo.getView(R.id.body), testTweetString);
        solo.clickOnButton("Save");
        // wait for it to appear in list after save
        solo.waitForText(testTweetString);

        solo.clickInList(0); // first item in list
        solo.assertCurrentActivity("Wrong Activity", EditTweetActivity.class);
//        assertEquals(testTweetString, solo.getEditText(R.id.editBody).getText().toString());
//        private EditText editText;
//        editText = (EditText) findViewById(R.id.editBody);
//        String currentText =
        assertTrue(solo.searchText(testTweetString));
    }

    /**
     * Runs at the end of the tests
     * @throws Exception
     */
    public void tearDown() throws Exception {
        solo.finishOpenedActivities();
    }

}