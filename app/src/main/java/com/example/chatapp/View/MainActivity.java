package com.example.chatapp.View;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.example.chatapp.Listadapters.ProgramAdapter;
import com.example.chatapp.R;
import com.example.chatapp.controller.Controller;
import com.example.chatapp.module.user;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    String[] name = {"ilyes", "ahmed"};
    String[] message = {"jdnjkcndknkenedjnlk", "hdbfiufuhzekufhezuhfuezhfiuezuieu"};
    int[] pic = {R.drawable.pic, R.drawable.pic};
    TextView textHeader;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        recieveName();
        messages();

    }

    void init(){
        textHeader = findViewById(R.id.headerName);
    }

    void recieveName(){
        Intent intent = getIntent();
        textHeader.setText(intent.getStringExtra("name"));
        System.out.println("le nom est: "+ intent.getStringExtra("name"));
    }

    void messages(){
        listView = findViewById(R.id.listView);
        ProgramAdapter programAdapter = new ProgramAdapter(this, name, pic, message);
        listView.setAdapter(programAdapter);
    }
}