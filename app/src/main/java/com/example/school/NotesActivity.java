package com.example.school;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class NotesActivity extends AppCompatActivity {
ImageButton mathematics;
ImageButton science;
ImageButton sst;
ImageButton english;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notes);
        mathematics =(ImageButton)findViewById(R.id.MATHEMATICS);
        science=(ImageButton)findViewById(R.id.SCIENCE);
        sst=(ImageButton)findViewById(R.id.SST);
        english=(ImageButton)findViewById(R.id.ENGLISH);
        mathematics.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                gotoUrl("https://ncert.nic.in/ncerts/l/jemh110.pdf");

            }
        });
        science.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gotoUrl("https://www.drishtiias.com/images/pdf/NCERT-Class-10-Science.pdf");
            }
        });
        sst.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gotoUrl("https://www.drishtiias.com/images/pdf/NCERT-Class-10-History.pdf");
            }
        });
        english.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gotoUrl("https://ncert.nic.in/textbook/pdf/jeff101.pdf");
            }
        });




    }
    public void gotoUrl(String s) {
        Uri uri=Uri.parse(s);
        startActivity(new Intent(Intent.ACTION_VIEW,uri));
}
    }
