package com.swamphacks.squad;


import com.firebase.client.Firebase;

import java.util.HashMap;
import java.util.List;
import android.content.Context;

public class Database {
    private Firebase myFirebaseRef;
    private User currUser;
    private HashMap<String, List<String>> squads;
    private HashMap<String, Event> events;
    private HashMap<String, List<String>> groups;
    public Database(Context context) {
        /* Create the Firebase ref that is used for all authentication with Firebase */
        myFirebaseRef = new Firebase(context.getResources().getString(R.string.firebase_url));
        squads = new HashMap<>();
        events = new HashMap<>();
    }
    public void setCurrUser(User user) {
        this.currUser = user;
    }
    public User getCurrUser() {
        return this.currUser;
    }
    public void formSquad(String name, List<Friend> friends) {
           writeDatabase("squads", name, friends);
    }
    public void formEvent(String name, Event event) {
           writeDatabase("events", name, event.getFriends());
    }
    public void writeDatabase(String child, String key, Object value) {
        myFirebaseRef.child(this.currUser.getUsername()).child(child).child(key).setValue(value);
    }
    public void ge
}
