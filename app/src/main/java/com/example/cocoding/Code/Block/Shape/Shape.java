package com.example.cocoding.Code.Block.Shape;

import com.example.cocoding.Code.Block.BlockItem;
import com.example.cocoding.Code.Block.BlockItems;
import com.example.cocoding.R;

public class Shape extends BlockItems {

    public Shape() {
        BlockItem block2 = new BlockItem(R.drawable.block2);
        BlockItem block3 = new BlockItem(R.drawable.block3);

        CodeBlocks.add(block2);
        CodeBlocks.add(block3);
    }


}

