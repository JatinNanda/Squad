package com.swamphacks.squad;

/**
 * Created by manavdutta1 on 1/24/16.
 */
import java.util.List;

public class Squad {
    private SquadEntry entry;
    private String name;
    public Squad(String user, List<String> bros, String name) {
        this.name = name;
        this.entry = new SquadEntry(user, bros);
    }
    public List<String> getFriends() {
        return entry.getFriends();
    }
    public String getName() {
        return this.name;
    }
}
