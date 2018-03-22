package com.iteso.sesion13_scrollabletab;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.iteso.sesion13_scrollabletab.Beans.User;

public class ActivityLogin extends AppCompatActivity {
    EditText username, password;
    Button login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        username = findViewById(R.id.activity_login_user);
        password = findViewById(R.id.activity_login_password);
        login = findViewById(R.id.activity_login_save);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                saveUser();
                Intent intent = new Intent(ActivityLogin.this, ActivityMain.class);
                startActivity(intent);
                finish();
            }
        });

    }

    public void saveUser(){
        User user = new User();
        user.setName(username.getText().toString());
        user.setPassword(password.getText().toString());
        user.setLogged(true);

        SharedPreferences sharedPreferences =
                getSharedPreferences(getString(R.string.preferences_file_key),
                        MODE_PRIVATE);

        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("NAME", username.getText().toString());
        editor.putString("PASS", password.getText().toString());
        editor.putBoolean("LOGGED", true);
        //apply es síncrono, commit es asincrono.
        editor.apply();

    }

}
