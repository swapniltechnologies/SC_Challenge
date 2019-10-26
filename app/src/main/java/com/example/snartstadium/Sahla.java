package com.example.snartstadium;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.content.Intent;

public class Sahla extends AppCompatActivity {
    private Button login;
    private Button register;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sahla);

        login = (Button) findViewById(R.id.login);
        register = (Button) findViewById(R.id.register);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                open_login();
            }
        });
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                open_signup();
            }
        });
    }

    public void open_login(){
        Intent intent = new Intent(this, Login.class);
        startActivity(intent);

    }
    public void open_signup(){
        Intent intent = new Intent(this, SignUp.class);
        startActivity(intent);

    }
}
