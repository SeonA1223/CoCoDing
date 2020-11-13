package com.example.cocoding.Code.Block.Object;

import com.example.cocoding.Code.Block.BlockItem;
import com.example.cocoding.Code.Block.BlockItems;
import com.example.cocoding.R;

public class Object extends BlockItems {

    BlockItem object_1;
    BlockItem object_2;
    BlockItem object_3;
    BlockItem object_4;
    BlockItem object_5;
    BlockItem object_6;
    BlockItem object_7;
    BlockItem object_8;
    BlockItem object_9;

    public Object() {
        object_1 =  new BlockItem(R.drawable.objact_block1);
        object_1.setLayout(R.id.object_block);
        object_2 = new BlockItem(R.drawable.objact_block2);
        object_3 = new BlockItem(R.drawable.objact_block3);
        object_4 = new BlockItem(R.drawable.objact_block4);
        object_5 = new BlockItem(R.drawable.objact_block5);
        object_6 = new BlockItem(R.drawable.objact_block6);
        object_7 = new BlockItem(R.drawable.objact_block7);
        object_8 = new BlockItem(R.drawable.objact_block8);
        object_9 = new BlockItem(R.drawable.objact_block9);

        object_1.setID("left_beaver");
        object_2.setID("right_beaver");
        object_3.setID("win");
        object_4.setID("vs");
        object_5.setID("left_snow");
        object_6.setID("right_snow");
        object_7.setID("hp_bar");
        object_8.setID("hp");
        object_9.setID("background");

//
//

        CodeBlocks.add(object_1);
        CodeBlocks.add(object_2);
        CodeBlocks.add(object_3);

        CodeBlocks.add(object_4);

        CodeBlocks.add(object_5);
        CodeBlocks.add(object_6);
        CodeBlocks.add(object_7);

        CodeBlocks.add(object_8);
        CodeBlocks.add(object_9);

        for(BlockItem blockItem : CodeBlocks){
            blockItem.setType("Object");
        }
    }


}

