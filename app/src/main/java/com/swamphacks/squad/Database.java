package com.swamphacks.squad;


import android.content.Context;

import java.util.List;

public class Database {
    private User currUser;
    public Database(Context context) {
    }
    public void setCurrUser(User user) {
        this.currUser = user;
    }
    public User getCurrUser() {
        return this.currUser;
    }

    //TODO change input to Squad instead of List<Friend> friends to take into account user.
    public void formSquad(String name, List<String> friends) {
           writeDatabase("squads", name, friends);
    }
    public void formEvent(String name, Event event) {
        event.setOwner(name);
        writeDatabase("events", name, event.getFriends());
    }
    public void updateSquad(Squad squad) {
           writeDatabase("squads", squad.getName(), squad.getFriends());
    }
    public void updateEvent(Event event) {
           writeDatabase("events", event.getName(), event.getFriends());
    }

    public void writeDatabase(String child, String key, Object value) {
        MyApplication.mFirebaseRef.child(child).child(key).setValue(value);
    }

//    public Squad getSquad(String name) {
//        Squad squad = myFirebaseRef.child("squads").equals(name);
//        return squad;
//    }
//
//    public Event getEvent(String name) {
//        Event event = myFirebaseRef.child("events").equals(name);
//        return event;
//    }
 }
