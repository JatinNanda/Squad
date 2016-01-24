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

    //TODO change input to Squad instead of List<Friend> friends to take into account user.
    public void formSquad(String name, List<Friend> friends) {
           writeDatabase("squads", name, friends);
    }
    public void formEvent(String name, Event event) {
            event.setOwner(currUser);
           writeDatabase("events", name, event.getFriends());
    }

    public void writeDatabase(String child, String key, Object value) {
        myFirebaseRef.child(child).child(key).setValue(value);
    }

    public Squad getSquad(String name) {
        Squad squad = myFirebaseRef.child("squads").equalto(name);
        return squad;
    }

    public Event getEvent(String name) {
        Event event = myFirebaseRef.child("events").equalto(name);
        return event;
    }
 }
