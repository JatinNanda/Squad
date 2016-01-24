package com.swamphacks.squad;

/**
 * Created by manavdutta1 on 1/24/16.
 */
import java.util.List;

public class Squad {
    private List<String> friends;
    private String name;
    public Squad(List<String> bros, String name) {
        this.friends = bros;
        this.name = name;
    }
    public List<String> getFriends() {
        return this.friends;
    }
    public String getName() {
        return this.name;
    }
}
