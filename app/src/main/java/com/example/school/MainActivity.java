package com.example.school;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {
    private FirebaseAuth auth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EditText username;
        EditText password;
        RadioGroup radio;
        RadioButton student;
        RadioButton teacher;
        Button reset;
        Button login;
        Button signup;
auth=FirebaseAuth.getInstance();
        ImageView image;
//       TextView textView=findViewById(R.id.textView3);
        username=findViewById(R.id.et1);
        password=(EditText) findViewById(R.id.et2);
        student=findViewById(R.id.rb1);
        teacher=findViewById(R.id.rb2);
        reset=findViewById(R.id.b1);
        login=findViewById(R.id.b2);
        image=findViewById(R.id.imageView);
        radio=findViewById(R.id.rg);
        signup=findViewById(R.id.sign);
        radio.clearCheck();
        radio.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                RadioButton radioButton=(RadioButton) radioGroup.findViewById(i);
            }
        });
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int id=radio.getCheckedRadioButtonId();
                RadioButton radioButton=(RadioButton)radio.findViewById(id);
                if(id==-1){
                    Toast.makeText(MainActivity.this,"No option selected", Toast.LENGTH_SHORT).show();
                }
                else{
//         RadioButton radioButton=(RadioButton)radio.findViewById(id);
                    Toast.makeText(MainActivity.this,"Welcome "+radioButton.getText(),Toast.LENGTH_SHORT).show();
                }



                String txt_email=username.getText().toString();
                String txt_password=password.getText().toString();
                if (TextUtils.isEmpty(txt_email) || TextUtils.isEmpty(txt_password)) {
                    Toast.makeText(MainActivity.this, "Please Fill All Credentials", Toast.LENGTH_SHORT).show();
                }
                else{
                loginUser(txt_email,txt_password,radioButton,student);
                }



            }
        });

        //RESET
        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                radio.clearCheck();
            }
        });
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(getApplicationContext(),MainActivity4.class);
                startActivity(i);
            }
        });


    }

    private void loginUser(String txt_email, String txt_password,RadioButton radioButton, RadioButton student) {
        auth.signInWithEmailAndPassword(txt_email,txt_password).addOnSuccessListener(new OnSuccessListener<AuthResult>() {
            @Override
            public void onSuccess(AuthResult authResult) {
                Toast.makeText(MainActivity.this, "Login Successful", Toast.LENGTH_SHORT).show();
//                Intent i=new Intent(getApplicationContext(),MainActivity2.class);
//                startActivity(i);
                if(radioButton==student) {
                    Intent intent = new Intent(getApplicationContext(), MainActivity2.class);
                    startActivity(intent);
                    finish();
                }
                else{
                    Intent intent2 = new Intent(getApplicationContext(), MainActivity3.class);
                    startActivity(intent2);
                }
                finish();
            }
        });
    }
}