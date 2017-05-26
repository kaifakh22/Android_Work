package com.example.kakhtar.bdonor.global;

import android.app.Application;
import android.content.SharedPreferences;

/**
 * Created by kakhtar on 5/22/2017.
 */

public class GlobalClass extends Application {
    public String WELCOME_SCREEN_PREFS = "welcome_screen_prefs";
    private String B_DONOR_PREFS = "b_donor_prefs";
    private SharedPreferences.Editor editor;
    private SharedPreferences prefs;
    @Override
    public void onCreate() {
        super.onCreate();
        //wrie app initial logic here
         editor = getSharedPreferences(B_DONOR_PREFS,MODE_PRIVATE).edit();
         prefs = getSharedPreferences(B_DONOR_PREFS,MODE_PRIVATE);
    }

    public SharedPreferences.Editor setSharedPreferences(){
         return editor;
     }

    public SharedPreferences getSharedPreferences(){
        return prefs;
    }
}
