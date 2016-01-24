package com.swamphacks.squad;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Random;

import cz.msebera.android.httpclient.Header;

public class FriendActivity extends Activity implements View.OnClickListener {
    AsyncHttpClient client;
    ListView view;
    ArrayAdapter<String> adapter;
    Context context=this;
    public static int groupSize;
    static final String AB = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    static Random rnd;
    ArrayList list;
    ArrayList phones;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_friend);
        view = (ListView) findViewById(R.id.listie);
        client = new AsyncHttpClient();
        getID();
        findViewById(R.id.okayButton).setOnClickListener(this);
    }
    private void getID(){
        Uri builtUri = Uri.parse(MyApplication.BASE_URL).buildUpon()
                .appendPath("me")
                .appendQueryParameter("access_token", MyApplication.token)
                .build();
        Log.d("TAG",builtUri.toString());
        client.get(builtUri.toString(), null, new JsonHttpResponseHandler() {
            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                // If the response is JSONObject instead of expected JSONArray
                try {
                    MyApplication.user_id = response.getJSONObject("data").getJSONObject("user").getString("id");
                    Log.d("TAG", MyApplication.user_id);
                    MyApplication.user = new User(MyApplication.user_id, MyApplication.token);
                    getFriends();
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }

        });

    }

    private void getFriends(){
        Uri builtUri = Uri.parse(MyApplication.BASE_URL).buildUpon()
                .appendPath("users")
                .appendPath(MyApplication.user_id)
                .appendPath("friends")
                .appendQueryParameter("access_token", MyApplication.token)
                .build();
        Log.d("TAG",builtUri.toString());
        client.get(builtUri.toString(), null, new JsonHttpResponseHandler() {

            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                // If the response is JSONObject instead of expected JSONArray
                try {
                    JSONArray array = response.getJSONArray("data");
                    list = new ArrayList<String>();
                    phones = new ArrayList<String>();
                    for (int i = 0; i < array.length(); i++) {
                        list.add(array.getJSONObject(i).getString("username"));
                        phones.add(array.getJSONObject(i).getString("phone"));
                        Log.d("TAG", array.getJSONObject(i).getString("username"));
                    }
                    String str[] = new String[list.size()];
                    Log.d("TAG", str.toString());
                    adapter = new ArrayAdapter<String>(context, R.layout.row_file, R.id.teView, list);
                    view.setAdapter(adapter);

                } catch (Exception e) {
                    e.printStackTrace();
                }

            }

        });
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

        for(Object phoneNumber : phones) {
            try {
                SmsManager.getDefault().sendTextMessage((String) phoneNumber, null,
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
        startActivity(new Intent(getApplicationContext(), CreateEvent.class));
    }
}
