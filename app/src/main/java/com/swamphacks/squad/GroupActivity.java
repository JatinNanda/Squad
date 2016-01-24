package com.swamphacks.squad;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.transition.Slide;
import android.view.View;
import android.view.Window;

public class GroupActivity extends ActionBarActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().requestFeature(Window.FEATURE_CONTENT_TRANSITIONS);
        Slide sliding = null;
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
            sliding = new Slide();
            sliding.setDuration((long) 15000.0);
            getWindow().setEnterTransition(sliding);
        }
        setContentView(R.layout.activity_group);
        findViewById(R.id.imageButton).setOnClickListener(this);
        findViewById(R.id.imageButton2).setOnClickListener(this);

    }



    public void onClick(View v)
    {
        switch (v.getId())
        {
            case R.id.imageButton:
                System.out.println("I'm clicking the join bubtton");
                startActivity(new Intent(getApplicationContext(), JoinActivity.class));
                break;
            case R.id.imageButton2:
                System.out.println("I'm clicking the friend bubtton");
                startActivity(new Intent(getApplicationContext(), FriendActivity.class));
                break;
        }
    }
}
