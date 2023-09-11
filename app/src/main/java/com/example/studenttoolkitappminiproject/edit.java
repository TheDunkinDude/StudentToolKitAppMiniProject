package com.example.studenttoolkitappminiproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.ButtonBarLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class edit extends AppCompatActivity {

    EditText e1;
    Button b1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);

        e1 = findViewById(R.id.Deleteinp);
        b1 = findViewById(R.id.Send);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String mes = e1.getText().toString();
                Intent intent = new Intent();
                intent.putExtra("count",mes);
                setResult(1,intent);
                finish();
            }
        });
    }
}