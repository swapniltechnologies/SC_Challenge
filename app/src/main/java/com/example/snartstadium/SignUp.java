package com.example.snartstadium;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SignUp extends AppCompatActivity {
    EditText name;
    EditText phno1;
    EditText pass;
    EditText confirmpass;
    Button next_signup;
    DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        db = new DatabaseHelper(this);

        name = (EditText) findViewById(R.id.name);
        phno1 = (EditText) findViewById(R.id.phno1);
        pass = (EditText) findViewById(R.id.pass);
        confirmpass = (EditText) findViewById(R.id.confirmpass);

        next_signup = (Button) findViewById(R.id.next_signup);

        next_signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String fullname = name.getText().toString().trim();
                String phno = phno1.getText().toString().trim();
                String pwd = pass.getText().toString().trim();
                String confirmpwd = confirmpass.getText().toString().trim();


                if(pwd.equals(confirmpwd)){
                    long val = db.addUser(fullname,phno,pwd);
                    if(val>0) {
                        Toast.makeText(SignUp.this, "Successfully registered", Toast.LENGTH_SHORT).show();
                        open();
                    }
                    else{
                        Toast.makeText(SignUp.this, "Registration Error", Toast.LENGTH_SHORT).show();
                    }
                }
                 else{
                    Toast.makeText(SignUp.this,"Password and Confirm Passwords are different",Toast.LENGTH_SHORT).show();
                }

            }
        });
    }
    public void open() {
        Intent intent = new Intent(this, HomePage.class);
        startActivity(intent);
    }
}
