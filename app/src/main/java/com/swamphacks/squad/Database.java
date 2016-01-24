package com.swamphacks.squad;


import com.firebase.client.Firebase;

import java.util.HashMap;
import java.util.Map;
import java.util.List;
import android.content.Context;

public class Database {
    private Firebase myFirebaseRef;
    private User currUser;
    public Database(Context context) {
        /* Create the Firebase ref that is used for all authentication with Firebase */
        myFirebaseRef = new Firebase(context.getResources().getString(R.string.firebase_url));
    }
    public void setCurrUser(User user) {
        this.currUser = user;
    }
    public User getCurrUser() {
        return this.currUser;
    }
    public void updateSquad(Squad squad) {
           writeDatabase("squads", squad.getName(), squad.getFriends());
    }
    public void updateEvent(Event event) {
           writeDatabase("events", event.getName(), event.getFriends());
    }
    public void storeAffiliation(User user, Squad squad) {

    }
    public void writeDatabase(String child, String key, Object value) {
        myFirebaseRef.child(this.currUser.getUsername()).child(child).child(key).setValue(value);
    }
    public void ge
}
