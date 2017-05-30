package com.example.kakhtar.bdonor.activities;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.kakhtar.bdonor.R;

public class MainScreen extends AppCompatActivity {
    EditText email;
    EditText password;
    TextView registration;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();


        setContentView(R.layout.activity_main_screen);
        email = (EditText)findViewById(R.id.et_email);
        password = (EditText)findViewById(R.id.et_password);
        registration = (TextView) findViewById(R.id.tv_registration);

        registration.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    public void onLoginClick(View v){
        String strEmail = email.getText().toString();
        String strPass = password.getText().toString();
        email.setError(null);
        password.setError(null);

        if(strEmail.isEmpty() || strEmail.trim().length() == 0 || !Patterns.EMAIL_ADDRESS.matcher(strEmail).matches()){
            email.setError("Enter valid Email");
        }

        if(strPass.isEmpty() || strPass.trim().length() == 0 || strPass.length()<3 || strPass.length()>10){
            password.setError("Password between 4 and 10 characters");
        }
    }
}
