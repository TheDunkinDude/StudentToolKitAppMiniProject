package com.example.studenttoolkitappminiproject;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.SearchManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.reflect.Array;

public class event_planner extends AppCompatActivity {

    EditText EventName;
    Button Add;
    ImageButton Return, Edit;
    int count = 0;
    TextView t1, t2, t3, t4, t5;
    String m_Text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_planner);

        EventName = findViewById(R.id.editTextText);
        Add = findViewById(R.id.Add);
        Return = findViewById(R.id.Return);
        Edit = findViewById(R.id.Edit);

        String[] keys = {"0", "1", "2", "3", "4"};
        String[] values = new String[5];



        Add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String event = EventName.getText().toString();
                if (count < 5) {
                    values[count] = event;
                    display(count, event);

                    count++;

                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                        NotificationChannel channel = new NotificationChannel("check", "check", NotificationManager.IMPORTANCE_DEFAULT);
                        NotificationManager manager = getSystemService(NotificationManager.class);
                        manager.createNotificationChannel(channel);
                    }
                    NotificationCompat.Builder builder = new NotificationCompat.Builder(event_planner.this, "check");
                    builder.setContentTitle("The Following Event Has Been Added");
                    builder.setContentText(event);
                    builder.setSmallIcon(R.drawable.ic_launcher_background);
                    builder.setAutoCancel(true);

                    NotificationManagerCompat managerCompat = NotificationManagerCompat.from(event_planner.this);
                    if (ActivityCompat.checkSelfPermission(event_planner.this, android.Manifest.permission.POST_NOTIFICATIONS) != PackageManager.PERMISSION_GRANTED) {
                        // TODO: Consider calling
                        //    ActivityCompat#requestPermissions
                        // here to request the missing permissions, and then overriding
                        //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                        //                                          int[] grantResults)
                        // to handle the case where the user grants the permission. See the documentation
                        // for ActivityCompat#requestPermissions for more details.
                        return;
                    }
                    managerCompat.notify(1, builder.build());
               }
               else Toast.makeText(event_planner.this, "Schedule is Currently Full.", Toast.LENGTH_SHORT).show();

           }
       });

       Return.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               finish();
           }
       });

       Edit.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Intent intent  = new Intent(event_planner.this,edit.class);
               startActivityForResult(intent,1);
           }
       });
    }
    public void display(int cnt,String event){

            if(cnt == 0) {
                t1 = findViewById(R.id.EventView);
                t1.setText(event);
            }
            else if (cnt == 1) {
                t2 = findViewById(R.id.eventView);
                t2.setText(event);
            }

            else if (cnt == 2){
                t3 = findViewById(R.id.eventView2);
                t3.setText(event);
            }
            else if (cnt == 3) {
                t4 = findViewById(R.id.eventView3);
                t4.setText(event);
            }
            else if (cnt == 4) {
                t5 = findViewById(R.id.eventView4);
                t5.setText(event);
            }

    }
    public void deleteEvent(int cnt){
        if(cnt == 0) {
            t1 = findViewById(R.id.EventView);
            t1.setText(" ");
        }
        else if (cnt == 1) {
            t2 = findViewById(R.id.eventView);
            t2.setText(" ");
        }

        else if (cnt == 2){
            t3 = findViewById(R.id.eventView2);
            t3.setText(" ");
        }
        else if (cnt == 3) {
            t4 = findViewById(R.id.eventView3);
            t4.setText(" ");
        }
        else if (cnt == 4) {
            t5 = findViewById(R.id.eventView4);
            t5.setText(" ");
        }
    }
    protected void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==1)
        {
            String del =data.getStringExtra("count");
            int delint = Integer.parseInt(del);
            deleteEvent(delint);
        }
    }

}