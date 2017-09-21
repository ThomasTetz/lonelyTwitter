package ca.ualberta.cs.lonelytwitter;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class LonelyTwitterActivity extends Activity {

	private static final String FILENAME = "file.sav";
	private EditText bodyText;
	private ListView oldTweetsList;

	private ArrayList<Tweet> tweets = new ArrayList<Tweet>();
	private ArrayAdapter<Tweet> adapter;
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		bodyText = (EditText) findViewById(R.id.body);
		Button saveButton = (Button) findViewById(R.id.save);
		Button clearButton = (Button) findViewById(R.id.clear);
		oldTweetsList = (ListView) findViewById(R.id.oldTweetsList);

		saveButton.setOnClickListener(new View.OnClickListener() {

			public void onClick(View v) {
				setResult(RESULT_OK);
				String text = bodyText.getText().toString();

                tweets.add(new NormalTweet(text));
                adapter.notifyDataSetChanged();
                saveInFile();

//				List moods = new ArrayList(););
//				moods.add(sadMood.getMoodString());

//				saveInFile(text, new Date(System.currentTimeMillis()), moods);
//                saveInFile(text, new Date(System.currentTimeMillis()));
//                saveInFile(text, new Date(System.currentTimeMillis()));

//                finish();

//              In-lab exercises
////				Tweet tweet = new Tweet(""); // abstract, cannot be instantiated
//				Tweet tweet = new ImportantTweet("");
//                Tweet tweet1 = new NormalTweet("Hi");
//				try {
//					tweet.setMessage("Hello");
//				} catch (TweetTooLongException e) {
////					e.printStackTrace();
//                }
////                Log.d("", "The isImportant method on tweet returns " + tweet.isImportant());
////                Log.d("", "The isImportant method on tweet1 returns " + tweet1.isImportant());
//
//                Tweetable tweet3 = new ImportantTweet("");
//                ArrayList<Tweet> tweetList = new ArrayList<Tweet>();
//                tweetList.add(tweet);
//                tweetList.add(tweet1);

            }
		});

		clearButton.setOnClickListener(new View.OnClickListener() {
			  public void onClick(View v) {
				  setResult(RESULT_OK);

                  tweets.clear();
                  adapter.notifyDataSetChanged();
                  clearFile();
              }
		  }

		);
	}

	@Override
	protected void onStart() {
		// TODO Auto-generated method stub
		super.onStart();
//		String[] tweets = loadFromFile();
        loadFromFile();
		adapter = new ArrayAdapter<Tweet>(this, R.layout.list_item, tweets);
		oldTweetsList.setAdapter(adapter);
	}

//	private String[] loadFromFile() {
    private void loadFromFile() {
//		ArrayList<String> tweets = new ArrayList<String>();
		try {
			FileInputStream fis = openFileInput(FILENAME);
			BufferedReader in = new BufferedReader(new InputStreamReader(fis));

            // add dependency: File > Project Structure > app < Dependencies < + < dependency
            Gson gson = new Gson();
            Type listType = new TypeToken<ArrayList<NormalTweet>>() {}.getType();
            tweets = gson.fromJson(in, listType);

//            String line = in.readLine();
//			while (line != null) {
//				tweets.add(line);
//				line = in.readLine();
//			}

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
            tweets = new ArrayList<Tweet>();
		} catch (IOException e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
            throw new RuntimeException(e);
		}
//		return tweets.toArray(new String[tweets.size()]);
	}

//    private void saveInFile(String text, Date date, List moods) {
//    private void saveInFile(String text, Date date) {
    private void saveInFile() {
		try {
//			FileOutputStream fos = openFileOutput(FILENAME, Context.MODE_APPEND);
//
            FileOutputStream fos = openFileOutput(FILENAME,
                    Context.MODE_PRIVATE);
            OutputStreamWriter writer = new OutputStreamWriter(fos);
            Gson gson = new Gson();
            gson.toJson(tweets, writer);
            writer.flush();
// fos.write(new String(date.toString() + " | " + text+"\n")
//					.getBytes());
			fos.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
            throw new RuntimeException();
		} catch (IOException e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
            throw new RuntimeException();
		}
	}

	private void clearFile(){
            deleteFile(FILENAME);
    }

}