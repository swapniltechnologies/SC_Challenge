package com.example.snartstadium;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity {
    EditText phno2;
    EditText password;
    Button next_login;
    DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        db = new DatabaseHelper(this);
        phno2 = (EditText) findViewById(R.id.phno2);
        password = (EditText) findViewById(R.id.password);
        next_login = (Button) findViewById(R.id.next_login);

        next_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String phno = phno2.getText().toString().trim();
                String pwd = password.getText().toString().trim();
                Boolean res = db.checkUser(phno,pwd);
                if(res== true){
                    Toast.makeText(Login.this,"Successfully Logged In",Toast.LENGTH_SHORT).show();
                    open();
                }
                else{
                    Toast.makeText(Login.this,"Login Error",Toast.LENGTH_SHORT).show();
                }

            }
        });

    }
    public void open() {
        Intent intent = new Intent(this, HomePage.class);
        startActivity(intent);
    }
}
