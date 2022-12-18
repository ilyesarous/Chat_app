package com.example.chatapp.Listadapters;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.chatapp.R;

public class ProgramViewHolder {

    ImageView itemImage;
    TextView name;
    TextView message;

    ProgramViewHolder(View v){
        itemImage = v.findViewById(R.id.imageView);
        name = v.findViewById(R.id.name);
        message = v.findViewById(R.id.message);
    }

}
