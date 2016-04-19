package com.gldraphael.appstatedemo;

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
}
