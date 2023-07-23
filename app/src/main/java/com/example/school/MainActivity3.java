package com.example.school;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;

import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Objects;

public class MainActivity3 extends AppCompatActivity {
 //   ImageView image=findViewById(R.id.imageViewTeacher);
    TextView txt;
Button mark;
RadioGroup attendance;
RadioButton absent;
RadioButton present;
EditText st_name;
ImageButton logout;
EditText date;
ImageButton view;
    EditText st_roll;
    FirebaseDatabase db;
    DatabaseReference reference;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        txt=findViewById(R.id.textViewTeacher);
        st_name=findViewById(R.id.st_name);
        st_roll=findViewById(R.id.st_roll);
      mark=findViewById(R.id.mark);
      date=findViewById(R.id.editTextDate);
      attendance=findViewById(R.id.rga);
    absent=findViewById(R.id.ab);
    present=findViewById(R.id.pr);
    view=findViewById(R.id.imageButton2);
logout=findViewById(R.id.logout);
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirebaseAuth.getInstance().signOut();
                Toast.makeText(MainActivity3.this, "Logged Out Successfully", Toast.LENGTH_SHORT).show();
                Intent i = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(i);
            }
        });

        attendance.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                RadioButton radioButton=(RadioButton) radioGroup.findViewById(i);

            }
        });

        mark.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {



                int id=attendance.getCheckedRadioButtonId();
                RadioButton radioButton=(RadioButton)attendance.findViewById(id);
                String Date=date.getText().toString();
                String student_name=st_name.getText().toString();
                String student_roll=st_roll.getText().toString();
               String student_attendance=radioButton.getText().toString();
              if(Date.isEmpty()|| student_name.isEmpty() || student_roll.isEmpty() || student_attendance.isEmpty() || id==-1) {
                  Toast.makeText(MainActivity3.this, "Please Fill All Credentials", Toast.LENGTH_SHORT).show();
//                  .addOnCompleteListener(new OnCompleteListener<Void>() {
//                      @Override
//                      public void onComplete(@NonNull Task<Void> task) {
//                       student_name.setText("");
//                      }
//                  });
              }
              else {

                  Users users = new Users(Date,  student_attendance,student_roll, student_name);
                  db = FirebaseDatabase.getInstance();
                  reference = db.getReference("Users");

                  reference.child(student_name).setValue(users);
                  Toast.makeText(MainActivity3.this,"marked"+ radioButton.getText(), Toast.LENGTH_SHORT).show();

              }


//                FirebaseDatabase.getInstance().getReference().child("SchoolData").child("Name").push().setValue(student_name);
//
//                FirebaseDatabase.getInstance().getReference().child("SchoolData").child("Roll No.").push().setValue(student_roll);
//
//               FirebaseDatabase.getInstance().getReference().child("SchoolData").child("Attendance").push().setValue(student_attendance);

            }
        });

view.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        Intent i=new Intent(getApplicationContext(),CheckActivity.class);
        startActivity(i);
    }
});
    }
}