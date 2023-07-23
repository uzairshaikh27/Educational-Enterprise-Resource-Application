package com.example.school;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class CheckActivity extends AppCompatActivity {

    TextView heading;
    EditText attendance_name;
    Button att_button;
TextView tv_Name;
        TextView tv_Roll;
    TextView tv_Attendance;
    DatabaseReference reference;

            TextView tv_Date;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check);
attendance_name=findViewById(R.id.att_name);
        heading=findViewById(R.id.heading);
        att_button=findViewById(R.id.att_button);
        tv_Name=findViewById(R.id.tvName);
        tv_Attendance=findViewById(R.id.tvAttendance);
        tv_Roll=findViewById(R.id.tvRoll);
        tv_Date=findViewById(R.id.tvDate);


        att_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               String st_name=attendance_name.getText().toString();
                if(!st_name.isEmpty()){
                  //  Toast.makeText(CheckActivity.this, "fine", Toast.LENGTH_SHORT).show();
                    readData(st_name);
                }
                else{
                    Toast.makeText(CheckActivity.this, "Please Enter the Name", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public void readData(String st_name) {
        reference = FirebaseDatabase.getInstance().getReference("Users");
        reference.child(st_name).get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DataSnapshot> task) {
                if(task.isSuccessful()){
                    //Toast.makeText(CheckActivity.this, "Successful", Toast.LENGTH_SHORT).show();
                    if(task.getResult().exists()){
                       // Toast.makeText(CheckActivity.this, "Got the Data", Toast.LENGTH_SHORT).show();

                        DataSnapshot snapshot=task.getResult();
                        String att_name=String.valueOf(snapshot.child("student_name").getValue());
                        String att_roll=String.valueOf(snapshot.child("student_roll").getValue());
                        String att_attendance=String.valueOf(snapshot.child("student_attendance").getValue());
                        String att_date=String.valueOf(snapshot.child("today_date").getValue());
                       tv_Name.setText(att_name);
                        tv_Roll.setText(att_roll);
                        tv_Attendance.setText(att_attendance);
                      tv_Date.setText(att_date);
                    }
                    else {
                        tv_Name.setText("");
                        tv_Roll.setText("");
                        tv_Attendance.setText("");
                        tv_Date.setText("");
                        Toast.makeText(CheckActivity.this, "User Does Not Exists", Toast.LENGTH_SHORT).show();
                    }
                }
                else{
                    Toast.makeText(CheckActivity.this, "Failed to Read Data", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

}
