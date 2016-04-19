package com.gldraphael.appstatedemo;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

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

    /**
     * Saves the AppState data in SharedPreferences
     * @param context
     * @return Returns true if success, else returns false
     */
    public boolean commit(Context context) {
        try {
            String serializedString = serialize();
            SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(context);
            SharedPreferences.Editor editor = preferences.edit();
            editor.putString("MYPREFERENCENAME", serializedString); // TODO: convert preference name to a static final field
            return editor.commit();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * Restores the AppState data from SharedPreferences
     * @param context
     */
    public void restore(Context context) {
        String prefString = PreferenceManager.getDefaultSharedPreferences(context).getString("MYPREFERENCENAME", "");  // TODO: convert preference name to a static final field
        AppState as = deserialize(prefString);
        if (as != null) {
            this.milk = as.milk;
            this.laundry = as.laundry;
            this.bed = as.bed;
            this.description = as.description;
            // Assign additional state variables here
        } /*else {
            // TODO: handle this
        }*/
    }

}
