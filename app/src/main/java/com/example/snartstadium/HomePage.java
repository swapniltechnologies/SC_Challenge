package com.example.snartstadium;


import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.ui.AppBarConfiguration;
import com.shrikanthravi.customnavigationdrawer2.widget.SNavigationDrawer;

import androidx.appcompat.app.AppCompatActivity;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

public class HomePage extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        Button navigate = findViewById(R.id.navigate);
        navigate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openNavigate();
            }
        });
        Button food = findViewById(R.id.food);
        food.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openFood();
            }
        });

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.home_page, menu);
        return true;
    }
    public void openNavigate() {
        Intent intent = new Intent(this, Navigate.class);
        startActivity(intent);
    }
    public void openFood() {
        Intent intent = new Intent(this, Food.class);
        startActivity(intent);
    }
}

