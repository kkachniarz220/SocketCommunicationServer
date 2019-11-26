package com.meme3321.serverscommunication.serverscommunication.models;

import org.json.simple.JSONObject;

import java.util.UUID;

public class SocketPlayer {
    private UUID uuid;
    private String name;

    public void setUUID(JSONObject jsonObject) {
        String uuid =  jsonObject.get("uuid").toString();
        this.uuid = UUID.fromString(uuid);
    }

    public void setName(JSONObject jsonObject) {
        String name = jsonObject.get("playerName").toString();
        this.name = name;
    }

    public UUID getUUID() {
        return uuid;
    }

    public String getName() {
        return name;
    }

}
