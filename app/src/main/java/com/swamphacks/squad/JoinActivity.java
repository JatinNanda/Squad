package com.swamphacks.squad;

/**
 * Created by Jay on 1/24/16.
 */
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by Jay on 9/26/15.
 */
public class JoinActivity extends ActionBarActivity {
    protected Button codeButton;
    String code;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.join_activity);
        codeButton = (Button) findViewById(R.id.codebutton);
        codeButton.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                code = ((EditText)
                        findViewById(R.id.codetext)).getText().toString();
                System.out.println("CODE:" + code);

                //NEED TO CHECK IF THE CODE MATCHES A GROUP SOMEHOW
                //IF IT DOES, add current user's location to the db
                if(Database.getElements(code) != null) {
                    Database.saveUser(code, MyApplication.user);
                    MyApplication.user.setCode(code);
                    startActivity(new Intent(getApplicationContext(), CreateEvent.class));
                } else {
                    Toast.makeText(
                            getApplicationContext(),
                            "Invalid Code", Toast.LENGTH_LONG).show();
                }
                /*SMSActivity.db.putLocation(new LatLng(GPSTracker.latitude, GPSTracker.longitude));
                SMSActivity.db.putCode();*/
            }
        }));
    }
}
