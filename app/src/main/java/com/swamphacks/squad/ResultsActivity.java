package com.swamphacks.squad;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.Reader;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class ResultsActivity extends Activity {

    private String outputPath;
    private TextView tv;
    private static String result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        tv = new TextView(this);
        setContentView(tv);

        String imageUrl = "unknown";

        Bundle extras = getIntent().getExtras();
        if( extras != null) {
            imageUrl = extras.getString("IMAGE_PATH" );
            outputPath = extras.getString( "RESULT_PATH" );
        }

        // Starting recognition process
        new AsyncProcessTask(this).execute(imageUrl, outputPath);
    }

    public void updateResults(Boolean success) {
        if (!success)
            return;
        try {
            StringBuffer contents = new StringBuffer();

            FileInputStream fis = openFileInput(outputPath);
            try {
                Reader reader = new InputStreamReader(fis, "UTF-8");
                BufferedReader bufReader = new BufferedReader(reader);
                String text = null;
                while ((text = bufReader.readLine()) != null) {
                    contents.append(text).append(System.getProperty("line.separator"));
                }
            } finally {
                fis.close();
            }
            result = contents.toString();
            System.out.println("THE TOTAL BILL IS: " + findTotalAmount());
            displayMessage("Your receipt has been processed successfully!");
        } catch (Exception e) {
            displayMessage("Error scanning receipt, re-take picture and try again.");
            Intent myIntent = new Intent(this, CreateEvent.class);
            startActivity(myIntent);
        }
    }

    public void displayMessage( String text ) {
        tv.post(new MessagePoster( text ) );
    }

    class MessagePoster implements Runnable {
        public MessagePoster( String message )
        {
            _message = message;
        }

        public void run() {
            tv.append( _message + "\n" );
            setContentView( tv );
        }

        private final String _message;
    }

    public static String getResults() {
        return result;
    }

    public float findTotalAmount() {
        String answer = "";
        int j = 0;
        for (int i = result.length() - 1; i >= j; i--) {
            if (Character.isDigit(result.charAt(i))) {
                j = 0;
                while (Character.isDigit(result.charAt(i - j)) || result.charAt(i - j) == '.' || result.charAt(i - j) == ',') {
                   answer = result.charAt(i - j) + answer;
                    j++;
                }
                break;
            }
        }
        if (answer == "") {
            System.out.println("Couldn't find a number...");
        }
        System.out.println(result);

        return Float.parseFloat(answer);
    }
}
