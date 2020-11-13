package com.example.cocoding.Code.Block.Looks;

import com.example.cocoding.Code.Block.BlockItem;
import com.example.cocoding.Code.Block.BlockItems;
import com.example.cocoding.R;

public class Looks extends BlockItems {

    BlockItem looks_change_scale;

    BlockItem looks_go_backward;

    BlockItem looks_go_forward;

    BlockItem looks_go_very_front;

    BlockItem looks_hide;

    BlockItem looks_say;

    BlockItem looks_set_scale;

    BlockItem looks_show;

    BlockItem looks_stop;

    public Looks() {
//        BlockItem block2 = new BlockItem(R.drawable.block2);
//        BlockItem block3 = new BlockItem(R.drawable.block3);
//
//        CodeBlocks.add(block2);
//        CodeBlocks.add(block3);

        looks_change_scale = new Change_Scale(R.drawable.looks_change_scale);

        looks_go_backward = new Go_Backward(R.drawable.looks_go_backward);

        looks_go_forward = new Go_Forward(R.drawable.looks_go_forward);

        looks_go_very_front = new Go_Very_Front(R.drawable.looks_go_very_front);

        looks_hide = new Hide(R.drawable.looks_hide);

        looks_say = new Say(R.drawable.looks_say);

        looks_set_scale = new Set_Scale(R.drawable.looks_set_scale);

        looks_show = new Show(R.drawable.looks_show);

        looks_stop = new Show(R.drawable.looks_stop);

        CodeBlocks.add(looks_show);
        CodeBlocks.add(looks_hide);
        CodeBlocks.add(looks_change_scale);
        CodeBlocks.add(looks_go_backward);
        CodeBlocks.add(looks_go_forward);
        CodeBlocks.add(looks_go_very_front);
        CodeBlocks.add(looks_say);
        CodeBlocks.add(looks_set_scale);
        CodeBlocks.add(looks_stop);

        for(BlockItem blockItem : CodeBlocks){
            blockItem.setType("Looks");
        }
    }


}

