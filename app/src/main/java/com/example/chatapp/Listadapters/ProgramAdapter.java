package com.example.chatapp.Listadapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Toast;


import com.example.chatapp.R;

public class ProgramAdapter extends ArrayAdapter<String> {

    int[] images;
    Context context;
    String[] name;
    String[] message;

    public ProgramAdapter(Context context, String[] name, int[] images, String[] message) {
        super(context, R.layout.exemple, R.id.name, name);
        this.context = context;
        this.images = images;
        this.name = name;
        this.message = message;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View singleItem = convertView;
        ProgramViewHolder holder;

        if(singleItem == null){
            LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            singleItem = layoutInflater.inflate(R.layout.exemple, parent, false);
            holder = new ProgramViewHolder(singleItem);
            singleItem.setTag(holder);
        }else{
            holder = (ProgramViewHolder) singleItem.getTag();
        }

        holder.itemImage.setImageResource(images[position]);
        holder.name.setText(name[position]);
        holder.message.setText(message[position]);

        singleItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), "you clicked: "+ name[position], Toast.LENGTH_SHORT).show();
            }
        });

        return singleItem;
    }
}
