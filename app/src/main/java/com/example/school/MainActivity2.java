package com.example.school;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity2 extends AppCompatActivity {
Button log;
ImageButton science;
    ImageButton maths;
    ImageButton sst;
   ImageButton english;
ImageButton home;
ImageButton notes;
ImageButton news;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        home =(ImageButton)findViewById(R.id.imageButton);
        notes=(ImageButton)findViewById(R.id.imageButton2);
        news=(ImageButton)findViewById(R.id.imageButton3);

        log = findViewById(R.id.logout);
        science = findViewById(R.id.imageButton4);
        maths = findViewById(R.id.imageButton6);
        sst = findViewById(R.id.imageButton9);
        english = findViewById(R.id.imageButton8);
        science.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gotoUrl("https://www.youtube.com/watch?v=_kIgLRwFSFQ&list=PLcJiYBaxEj81IsxfaVxnlLvuAJGiF8A-A");
            }
        });
        maths.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gotoUrl("https://www.youtube.com/watch?v=C29IdZClwnQ&list=PLcJiYBaxEj81G8tb7obLH0TpxrvsHZXI0");
            }
        });
        sst.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gotoUrl("https://www.youtube.com/watch?v=bl9PD73xbX4&list=PLcJiYBaxEj83ZJNuVcOdo4ubZcx5m_QjS");
            }
        });
        english.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gotoUrl("https://www.youtube.com/playlist?list=PLcJiYBaxEj83OqQz5THvZWSkLlZCvLXnw");
            }
        });




        log.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirebaseAuth.getInstance().signOut();
                Toast.makeText(MainActivity2.this, "Logged Out Successfully", Toast.LENGTH_SHORT).show();
                Intent i = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(i);
            }
        });
        notes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), NotesActivity.class);
                startActivity(i);
            }
        });

        news.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gotoUrl("https://www.bbc.com/news");
            }
        });
    }





      public void gotoUrl(String s){
         Uri uri=Uri.parse(s);
           startActivity(new Intent(Intent.ACTION_VIEW,uri));

      }
    }
