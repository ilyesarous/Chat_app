package com.example.chatapp.tools;

import android.graphics.Rect;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.jetbrains.annotations.NotNull;

public class ItemSpacing extends RecyclerView.ItemDecoration {

    private final int spacing;


    public ItemSpacing(int spacing) {
        this.spacing = spacing;
    }

    public void getItemOffsets(@NonNull Rect outRect, @NonNull View view, @NotNull RecyclerView parent, @NonNull RecyclerView.State state){
        outRect.bottom = spacing;
    }
}
