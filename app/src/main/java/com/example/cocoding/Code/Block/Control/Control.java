package com.example.cocoding.Code.Block.Control;

import com.example.cocoding.Code.Block.BlockItem;
import com.example.cocoding.Code.Block.BlockItems;
import com.example.cocoding.R;

public class Control extends BlockItems {

    BlockItem control_if;
    BlockItem control_ifelse;
    BlockItem control_repeat;
    BlockItem control_wait;

    public Control() {
        //  BlockItem block5 = new BlockItem(R.drawable.block5);
        control_if = new BlockItem(R.drawable.control_if);
        control_ifelse = new BlockItem(R.drawable.control_ifelse);
        control_repeat = new BlockItem(R.drawable.control_repeat);
        control_wait = new BlockItem(R.drawable.control_wait);

          CodeBlocks.add(control_if);
        CodeBlocks.add(control_ifelse);
        CodeBlocks.add(control_repeat);
        CodeBlocks.add(control_wait);
    }


}
