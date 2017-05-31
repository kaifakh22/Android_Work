package com.example.kakhtar.bdonor;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import com.example.kakhtar.bdonor.activities.LoginScreen;
import com.example.kakhtar.bdonor.activities.WelcomeScreen;
import com.example.kakhtar.bdonor.global.GlobalClass;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        final GlobalClass global = (GlobalClass)getApplicationContext();
     //   global.setSharedPreferences().clear();
     //   global.setSharedPreferences().commit();
        Boolean showWelcomeScreen = global.getSharedPreferences().getBoolean(global.WELCOME_SCREEN_PREFS,true);
        Intent intent;


        if(showWelcomeScreen){
            
            intent = new Intent(this, WelcomeScreen.class);


        }else{
            intent = new Intent(this, LoginScreen.class);


        }
        startActivity(intent);
        finish(); // it will remove present activity from back stack


    }
}
