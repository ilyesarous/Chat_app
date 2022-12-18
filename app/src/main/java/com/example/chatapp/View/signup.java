package com.example.chatapp.View;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.chatapp.R;
import com.example.chatapp.controller.Controller;
import com.example.chatapp.module.MyThread;
import com.example.chatapp.module.user;

public class signup extends AppCompatActivity {

    EditText fname, lname, add, pass;
    Button signIn;
    Controller controller;
    com.example.chatapp.module.user user;
    String firstName, lastName, email, password;
    MyThread thread = new MyThread();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        controller = Controller.getInstance(this);
        init();

        signIN();
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);


    }

    void init(){
        add = findViewById(R.id.addressMailSign);
        pass = findViewById(R.id.passwordSign);
        fname = findViewById(R.id.fname);
        lname = findViewById(R.id.lname);
        signIn = findViewById(R.id.sing);
    }


    void signIN(){
        signIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                firstName = fname.getText().toString();
                lastName = lname.getText().toString();
                email = add.getText().toString();
                password = pass.getText().toString();


                if(TextUtils.isEmpty(firstName) || TextUtils.isEmpty(lastName) || TextUtils.isEmpty(email) || TextUtils.isEmpty(password)){
                    Toast.makeText(signup.this, "All fields are required!", Toast.LENGTH_SHORT).show();
                }else{
                    user = new user(firstName,lastName,email,password);

                    String name = user.getFirstName()+"%"+user.getLastName()+"%"+user.getEmail()+"%"+user.getPassword();
                    thread.sendMessage(name);
                    if(thread.getName().equals("user added")){
                        Toast.makeText(signup.this, thread.getName(), Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(getApplicationContext(), Home.class);
                        startActivity(intent);
                    }else {
                        Toast.makeText(signup.this, thread.getName(), Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });
    }
}