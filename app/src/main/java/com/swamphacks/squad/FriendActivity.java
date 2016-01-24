package com.swamphacks.squad;

import android.os.Bundle;
import android.app.Activity;
import android.support.v7.app.ActionBarActivity;
import android.widget.ListView;

public class FriendActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        String[] values = new String[] { "Android", "iPhone", "WindowsMobile",
                "Blackberry", "WebOS", "Ubuntu", "Windows7", "Max OS X",
                "Linux", "OS/2" };
        setContentView(R.layout.activity_friend);
        ListView view = (ListView) findViewById(R.id.listie);
        FriendAdapter adapter = new FriendAdapter(this, values);
        view.setAdapter(adapter);
    }

}
