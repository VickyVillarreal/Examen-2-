package com.iteso.sesion13_scrollabletab;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.iteso.sesion13_scrollabletab.Beans.Store;
import com.iteso.sesion13_scrollabletab.Beans.User;
import com.iteso.sesion13_scrollabletab.database.DataBaseHandler;
import com.iteso.sesion13_scrollabletab.database.StroreControl;

import java.util.Timer;
import java.util.TimerTask;

public class ActivitySplashScreen extends AppCompatActivity {
    public static int SPLASH_SCREEN_DELAY = 2000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                User user = loadUser();
                Intent intent;
                if (user.isLogged()) {
                    intent = new Intent(ActivitySplashScreen.this, ActivityMain.class);
                } else {
                    intent = new Intent(ActivitySplashScreen.this, ActivityLogin.class);
                }

                startActivity(intent);
                finish();
            }
        };
        DataBaseHandler dh= DataBaseHandler.getInstance(ActivitySplashScreen.this);
        Store store1= new Store();
        Store store2= new Store();
        Store store3= new Store();
        StroreControl sc = new StroreControl();
        if(sc.getStores(dh).isEmpty()){
            sc.addStore(store1, dh);
            sc.addStore(store2, dh);
            sc.addStore(store3, dh);


        }


        Timer timer = new Timer();
        timer.schedule(task, SPLASH_SCREEN_DELAY);

    }

    public User loadUser() {
        SharedPreferences sharedPreferences =
                getSharedPreferences(getString(R.string.preferences_file_key),
                        MODE_PRIVATE);

        User user = new User();
        user.setName(sharedPreferences.getString("NAME", null));
        user.setPassword(sharedPreferences.getString("PASS", null));
        user.setLogged(sharedPreferences.getBoolean("LOGGED", false));
        sharedPreferences = null;
        return user;
    }

}
