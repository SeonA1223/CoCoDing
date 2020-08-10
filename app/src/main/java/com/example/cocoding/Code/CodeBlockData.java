package com.example.cocoding.Code;

import com.example.cocoding.RecyclerviewItem;
import com.example.cocoding.R;

import java.util.ArrayList;

public class CodeBlockData {

    ArrayList<RecyclerviewItem> CodeBlocks = new ArrayList<>();

    RecyclerviewItem cshape1 = new RecyclerviewItem(R.drawable.cshape1);
    RecyclerviewItem cshape2 = new RecyclerviewItem(R.drawable.cshape2);
    RecyclerviewItem cshape3 = new RecyclerviewItem(R.drawable.cshape3);

    public ArrayList<RecyclerviewItem> getCodeBlocks(){
        return CodeBlocks;
    }
}
