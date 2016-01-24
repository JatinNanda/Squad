package com.swamphacks.squad;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.widget.ListView;

public class SquadActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        String[] values = new String[] {"Scott Veri", "Jatin Sad Boi Concert", "Adithya League", "Manav PornStar", "Tejas Swag Fest","Courtney Love"};
        setContentView(R.layout.activity_squad);
        ListView view = (ListView) findViewById(R.id.squaList);
        SquadAdapter adapter = new SquadAdapter(this, values);
        view.setAdapter(adapter);
    }

}
