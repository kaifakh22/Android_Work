package com.example.kakhtar.bdonor.activities;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.kakhtar.bdonor.R;
import com.example.kakhtar.bdonor.adapters.WelcomePagerAdapter;
import com.example.kakhtar.bdonor.global.GlobalClass;

public class WelcomeScreen extends AppCompatActivity implements ViewPager.OnPageChangeListener, View.OnClickListener {
    int[] layouts;
    ViewPager viewPager;
    TextView[] dots;
    LinearLayout dotsLayout;
    Button skip;
    Button next;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
        // make content below status bar
        if (Build.VERSION.SDK_INT >= 21) {
            getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
        }

        if(Build.VERSION.SDK_INT>19){
            Window window = getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(Color.TRANSPARENT);
        }

        setContentView(R.layout.activity_welcome_screen);
        dotsLayout = (LinearLayout)findViewById(R.id.dotsLayout);
        skip = (Button)findViewById(R.id.btnSkip);
        next = (Button)findViewById(R.id.btnNext);

        addBottonDots(0);
        //hello
        layouts = new int[]{R.layout.welcome_screen1,R.layout.welcome_screen2,R.layout.welcome_screen3};

        viewPager = (ViewPager)findViewById(R.id.vp_welcome);
        viewPager.setOnPageChangeListener(this);
        WelcomePagerAdapter welcomePagerAdapter = new WelcomePagerAdapter(this,layouts);
        viewPager.setAdapter(welcomePagerAdapter);

        skip.setOnClickListener(this);
        next.setOnClickListener(this);
    }

    private void addBottonDots(int currentPage){
        dotsLayout.removeAllViews();
        int[] colorsActive = getResources().getIntArray(R.array.active_color);
        int[] colorsInactive = getResources().getIntArray(R.array.inactive_color);
        dots = new TextView[colorsActive.length];

        for(int i = 0 ; i<colorsActive.length;i++ ){
            dots[i] = new TextView(this);
            dots[i].setText(Html.fromHtml("&#8226;"));
            dots[i].setTextSize(40);
            dots[i].setTextColor(colorsInactive[currentPage]);
            dotsLayout.addView(dots[i]);
        }

        dots[currentPage].setTextColor(colorsActive[currentPage]);
    }



    @Override
    public void onPageSelected(int i) {
       addBottonDots(i);
    }

    @Override
    public void onPageScrollStateChanged(int i) {

    }

    @Override
    public void onPageScrolled(int i, float v, int i1) {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnNext:
                Log.d("Current Item",""+viewPager.getCurrentItem());
                if((viewPager.getCurrentItem()+1) < layouts.length){
                    viewPager.setCurrentItem(viewPager.getCurrentItem()+1);

                }else{
                    launchHomeScreen();
                }

                break;
            case R.id.btnSkip:
                launchHomeScreen();
                break;
        }
    }

    private void launchHomeScreen(){
        Intent i = new Intent(this,MainScreen.class);
        startActivity(i);
        final GlobalClass global = (GlobalClass) getApplicationContext();
        global.setSharedPreferences().putBoolean(global.WELCOME_SCREEN_PREFS,false);
        global.setSharedPreferences().commit();
        finish();
    }
}
