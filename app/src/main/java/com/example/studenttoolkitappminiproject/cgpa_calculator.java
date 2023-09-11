package com.example.studenttoolkitappminiproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class cgpa_calculator extends AppCompatActivity {

    EditText cred1,cred2,cred3,cred4,cred5,cred6,cred7,cred8,grade1,grade2,grade3,grade4,grade5,grade6,grade7,grade8;
    Button Cal, Return;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cgpa_calculator);

        Cal = findViewById(R.id.Calculate);
        Cal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                cred1 = findViewById(R.id.Credit1);
                cred2 = findViewById(R.id.Credit2);
                cred3 = findViewById(R.id.Credit3);
                cred4 = findViewById(R.id.Credit4);
                cred5 = findViewById(R.id.Credit5);
                cred6 = findViewById(R.id.Credit6);
                cred7 = findViewById(R.id.Credit7);
                cred8 = findViewById(R.id.Credit8);
                grade1 = findViewById(R.id.Grade1);
                grade2 = findViewById(R.id.Grade2);
                grade3 = findViewById(R.id.Grade3);
                grade4 = findViewById(R.id.Grade4);
                grade5 = findViewById(R.id.Grade5);
                grade6 = findViewById(R.id.Grade6);
                grade8 = findViewById(R.id.Grade7);
                grade7 = findViewById(R.id.Grade8);


                float g1,g2,g3,g4,g5,g6,g7,g8;
                g1 = ifnull(grade1.getText().toString());
                g2 = ifnull(grade2.getText().toString());
                g3 = ifnull(grade3.getText().toString());
                g4 = ifnull(grade4.getText().toString());
                g5 = ifnull(grade5.getText().toString());
                g6 = ifnull(grade6.getText().toString());
                g7 = ifnull(grade7.getText().toString());
                g8 = ifnull(grade8.getText().toString());

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

                Toast.makeText(cgpa_calculator.this, "The calculated Gpa is" + GPA, Toast.LENGTH_SHORT).show();
            }
        });
        Return = findViewById(R.id.Return);
        Return.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(cgpa_calculator.this,Homepage.class);
                startActivity(intent);
            }
        });
    }
    public float  ifnull(String Credit){
        if (Credit == null){
            return 0;
        }else{
            return Float.parseFloat(Credit);
        }
    }
}
