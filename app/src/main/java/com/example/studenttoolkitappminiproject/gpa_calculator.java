package com.example.studenttoolkitappminiproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class gpa_calculator extends AppCompatActivity {

    EditText cred1,cred2,cred3,cred4,cred5,cred6,cred7,cred8,grade1,grade2,grade3,grade4,grade5,grade6,grade7,grade8;
    Button Cal, Return;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gpa_calculator);


        Cal = findViewById(R.id.Calculate);
        Cal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                cred1 = findViewById(R.id.Credit1);
                cred2 = findViewById(R.id.credit2);
                cred3 = findViewById(R.id.credit3);
                cred4 = findViewById(R.id.credit4);
                cred5 = findViewById(R.id.credit5);
                cred6 = findViewById(R.id.credit6);
                cred7 = findViewById(R.id.credit7);
                cred8 = findViewById(R.id.credit8);
                grade1 = findViewById(R.id.Grade1);
                grade2 = findViewById(R.id.Grade2);
                grade3 = findViewById(R.id.Grade3);
                grade4 = findViewById(R.id.Grade4);
                grade5 = findViewById(R.id.Grade5);
                grade6 = findViewById(R.id.Grade6);
                grade8 = findViewById(R.id.Grade7);
                grade7 = findViewById(R.id.Grade8);


                float g1,g2,g3,g4,g5,g6,g7,g8;
                g1 = gradeassign(grade1.getText().toString());
                g2 = gradeassign(grade2.getText().toString());
                g3 = gradeassign(grade3.getText().toString());
                g4 = gradeassign(grade4.getText().toString());
                g5 = gradeassign(grade5.getText().toString());
                g6 = gradeassign(grade6.getText().toString());
                g7 = gradeassign(grade7.getText().toString());
                g8 = gradeassign(grade8.getText().toString());

                float c1,c2,c3,c4,c5,c6,c7,c8;
                c1 = ifnull(cred1.getText().toString());
                c2 = ifnull(cred2.getText().toString());
                c3 = ifnull(cred3.getText().toString());
                c4 = ifnull(cred4.getText().toString());
                c5 = ifnull(cred5.getText().toString());
                c6 = ifnull(cred6.getText().toString());
                c7 = ifnull(cred7.getText().toString());
                c8 = ifnull(cred8.getText().toString());

                float GPA = ((g1*c1)+(g2*c2)+(g3*c3)+(g4*c4)+(g5*c5)+(g6*c6)+(g7*c7)+(g8*c8))/(c1+c2+c3+c4+c5+c6+c7+c8);

                Toast.makeText(gpa_calculator.this, "The calculated Gpa is" + GPA, Toast.LENGTH_SHORT).show();
            }
        });
        Return = findViewById(R.id.Return);
        Return.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(gpa_calculator.this,Homepage.class);
                startActivity(intent);
            }
        });
    }
    public int gradeassign(String Grade){
        if (Grade.equals("S") || Grade.equals("s")){
            return 10;
        } else if (Grade.equals("A") || Grade.equals("a")) {
            return 9;
        }else if (Grade.equals("B") || Grade.equals("b")) {
            return 8;
        }else if (Grade.equals("C") || Grade.equals("c")) {
            return 7;
        }else if (Grade.equals("D") || Grade.equals("d")) {
            return 6;
        }else if (Grade.equals("E") || Grade.equals("e")) {
            return 5;
        }else if (Grade == "N" || Grade == "n" || Grade == "F" || Grade == "f") {
            return 0;
        }else{
            return 0;
        }
    }
    public int  ifnull(String Credit){
        if (Credit == null){
            return 0;
        }else{
            return Integer.parseInt(Credit);
        }
    }
}