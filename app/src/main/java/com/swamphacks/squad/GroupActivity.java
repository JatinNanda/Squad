package com.swamphacks.squad;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.transition.Slide;
import android.view.Window;

public class GroupActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().requestFeature(Window.FEATURE_CONTENT_TRANSITIONS);
        Slide sliding = new Slide();
        sliding.setDuration((long) 15000.0);
        getWindow().setEnterTransition(sliding);
        setContentView(R.layout.activity_group);
    }

}
