package com.swamphacks.squad;
/**
 * Created by Jay on 9/25/15.
 */

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.Random;

public class SMSActivity extends Activity implements OnClickListener{

    Button mapScreen;
    public static int groupSize;
    static final String AB = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    static Random rnd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.smslayout);


        findViewById(R.id.sendbutton).setOnClickListener(this);

    }

    public void onClick(View v) {
        //Generate Code
        String code = "";
        StringBuilder sb = new StringBuilder(10);
        rnd = new Random();
        for( int i = 0; i < 10; i++ ) {
            sb.append(AB.charAt(rnd.nextInt(AB.length())));
            code = sb.toString();
        }
        Squad s = new Squad(code, "Squad", MyApplication.user.getUsername());
        MyApplication.user.setCode(code);
        String[] arr = ((EditText)
                findViewById(R.id.editText)).getText().toString().split(",");
        groupSize = arr.length + 1;
        for(String phoneNumber:arr) {
            try {
                SmsManager.getDefault().sendTextMessage(phoneNumber, null,
                        "Your Squad Code is: " + code
                        , null, null);
            } catch (Exception e) {
                AlertDialog.Builder alertDialogBuilder = new
                        AlertDialog.Builder(this);
                AlertDialog dialog = alertDialogBuilder.create();
                dialog.setMessage(e.getMessage());
                dialog.show();

            }
        }
        startActivity(new Intent(getApplicationContext(), SquadActivity.class));
    }

    public ArrayList<String> parseNumbers(String numbers) {
        SmsManager s = SmsManager.getDefault();
        return s.divideMessage(numbers);
    }

}
