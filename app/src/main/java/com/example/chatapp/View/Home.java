package com.example.chatapp.View;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.chatapp.R;
import com.example.chatapp.controller.Controller;
import com.example.chatapp.data_base.SqlProvider;
import com.example.chatapp.module.MyThread;
import com.example.chatapp.module.user;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Objects;

public class Home extends AppCompatActivity {

    EditText add, pass;
    Button log, sign;
    Controller controller;
    MyThread thread = new MyThread();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        controller = Controller.getInstance(this);

        init();
        Signup();
        login();
    }

    void init(){
        add = findViewById(R.id.addressMailLog);
        pass = findViewById(R.id.passwordLog);
        log = findViewById(R.id.login);
        sign = findViewById(R.id.signInlog);
    }

    void Signup(){
        sign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Home.this, signup.class);
                startActivity(intent);
            }
        });
    }


    void login(){
        log.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                add = findViewById(R.id.addressMailLog);
                pass = findViewById(R.id.passwordLog);

                String email = add.getText().toString();
                String password = pass.getText().toString();
                if(TextUtils.isEmpty(email) || TextUtils.isEmpty(password)){
                    Toast.makeText(Home.this, "All fields are required!", Toast.LENGTH_SHORT).show();
                }else {
                    String mes = email +"%"+password;
                    thread.sendMessage(mes);
                    String[] t = thread.getName().split(" ");
                    if(t[0].equals("welcome")){
                        Toast.makeText(Home.this, thread.getName(), Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                        intent.putExtra("name", t[1]);
                        startActivity(intent);
                    }else{
                        Toast.makeText(Home.this, "Login Failed!", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }

}