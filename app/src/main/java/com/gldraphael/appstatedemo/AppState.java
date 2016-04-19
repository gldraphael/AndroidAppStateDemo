package com.gldraphael.appstatedemo;

import com.google.gson.Gson;
import com.google.gson.JsonParseException;

/**
 * Created by gldraphael on 19/04/16.
 */
public class AppState {

    private static AppState instance;
    public static AppState getInstance() {
        if(instance == null) {
            instance = new AppState();
        }
        return instance;
    }

    private AppState() {

    }

    // State variables follows
    public boolean milk;
    public boolean laundry;
    public boolean bed;
    public String description;

    /**
     * Serializes the appstate
     * @return JSON representation of the AppState
     */
    private String serialize() {
        try {
            return new Gson().toJson(this);
        } catch (JsonParseException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Deserializes the appstate string
     * @param appStateJsonString the JSON representation of the AppState
     */
    private AppState deserialize(String appStateJsonString) {
        try {
            return new Gson().fromJson(appStateJsonString, AppState.class);
        } catch (JsonParseException e) {
            e.printStackTrace();
            return null;
        }
    }


}
