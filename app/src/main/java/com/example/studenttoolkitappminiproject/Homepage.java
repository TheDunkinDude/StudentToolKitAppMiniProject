package com.example.studenttoolkitappminiproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Homepage extends AppCompatActivity {

    Button GPA, CGPA, Event;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);

        GPA = findViewById(R.id.GPA);
        CGPA = findViewById(R.id.CGPA);
        Event = findViewById(R.id.Planner);

        GPA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Homepage.this,gpa_calculator.class);
                startActivity(intent);
            }
        });
        CGPA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Homepage.this,cgpa_calculator.class);
                startActivity(intent);
            }
        });
        Event.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Homepage.this, event_planner.class);
                startActivity(intent);
            }
        });
    }
}