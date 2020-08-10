package com.example.cocoding.Code;

import com.example.cocoding.RecyclerviewItem;
import com.example.cocoding.R;

import java.util.ArrayList;

public class CodeBlockData {

    ArrayList<RecyclerviewItem> CodeBlocks = new ArrayList<>();

    RecyclerviewItem shape1 = new RecyclerviewItem(R.drawable.shape1);
    RecyclerviewItem shape2 = new RecyclerviewItem(R.drawable.shape2);
    RecyclerviewItem shape3 = new RecyclerviewItem(R.drawable.shape3);

    public ArrayList<RecyclerviewItem> getCodeBlocks(){
        return CodeBlocks;
    }
}
