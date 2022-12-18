package com.example.chatapp.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.chatapp.R;
import com.example.chatapp.tools.ItemSpacing;
import com.example.chatapp.tools.MessageAdapter;

import java.util.ArrayList;

public class Message extends AppCompatActivity{

    ArrayList<String> messages;
    EditText mes;
    ImageButton send;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message);
        mes = findViewById(R.id.textMessage);
        send = findViewById(R.id.sendBtn);
        RecyclerView recycleView = (RecyclerView) findViewById(R.id.recycleView);
        messages = new ArrayList<String>();
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (messages.size()!= 0){
                    recycleView.setVisibility(View.VISIBLE);
                }
                messages.add(mes.getText().toString());
                MessageAdapter adapter = new MessageAdapter(messages);

                adapter.notifyItemInserted(messages.size());
                recycleView.setAdapter(adapter);
                recycleView.setLayoutManager(new LinearLayoutManager(Message.this));
                ItemSpacing space = new ItemSpacing(10);
                recycleView.addItemDecoration(space);

            }
        });

    }
}