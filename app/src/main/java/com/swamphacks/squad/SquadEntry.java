package com.swamphacks.squad;

import java.util.List;

public class SquadEntry {
    private List<String> friends;
    private String owner;
    public SquadEntry() {

    }

    public SquadEntry(String owner, List<String> friends) {
        this.owner = owner;
        this.friends = friends;
    }

    public List<String> getFriends() {
        return this.friends;
    }

    public String getOwner() {
        return this.owner;
    }

    public void setOwner(String name) {
        this.owner = name;
    }

    public void setFriends(List<String> friends) {
        this.friends = friends;
    }

    public void addFriend(String friend) {
        friends.add(friend);
    }
    public void deleteFriend(String friend) {
        friends.remove(friend);
    }
}