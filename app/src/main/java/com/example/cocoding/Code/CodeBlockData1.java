package com.example.cocoding.Code;

import androidx.recyclerview.widget.RecyclerView;

import com.example.cocoding.R;
import com.example.cocoding.RecyclerviewItem;

import java.util.ArrayList;

public class CodeBlockData1 extends CodeBlockData {

    public CodeBlockData1() {
        RecyclerviewItem block2 = new RecyclerviewItem(R.drawable.block2);
        RecyclerviewItem block3 = new RecyclerviewItem(R.drawable.block3);

        CodeBlocks.add(block2);
        CodeBlocks.add(block3);
    }


}

