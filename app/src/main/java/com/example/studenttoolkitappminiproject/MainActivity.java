package com.example.studenttoolkitappminiproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    EditText password;
    Button enter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        password = findViewById(R.id.UserInput);
        enter = findViewById(R.id.EnterPassword);

        String pass = "abcdef";
        enter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String Userpassword = password.getText().toString();
                if(Userpassword.equals(pass)){
                    Intent intent = new Intent(MainActivity.this,Homepage.class);
                    startActivity(intent);
                }else{
                    Toast.makeText(MainActivity.this, "Invalid Password", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}