package com.example.cocoding.Code.Block.Operators;

import com.example.cocoding.Code.Block.BlockItem;
import com.example.cocoding.Code.Block.BlockItems;
import com.example.cocoding.R;

import java.util.concurrent.BlockingQueue;

public class Operators extends BlockItems {

    BlockItem operators_set;
    BlockItem operators_my;

    public Operators() {
        operators_set = new BlockItem(R.drawable.operators_set);
        operators_my = new BlockItem(R.drawable.operators_my);

        CodeBlocks.add(operators_set);
        CodeBlocks.add(operators_my);
    }


}

