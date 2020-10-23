package com.example.cocoding.Code.Block.Object;

import com.example.cocoding.Code.Block.BlockItem;
import com.example.cocoding.Code.Block.BlockItems;
import com.example.cocoding.R;

public class Object extends BlockItems {

    BlockItem character1;
    BlockItem character2;
    BlockItem character3;
    BlockItem one;
    BlockItem two;
    BlockItem three;
    BlockItem final_line;

    public Object() {
        character1 =  new BlockItem(R.drawable.character1);
        character2 = new BlockItem(R.drawable.character2);
        character3 = new BlockItem(R.drawable.character3);
        one = new BlockItem(R.drawable.one);
        two = new BlockItem(R.drawable.two);
        three = new BlockItem(R.drawable.three);
        final_line = new BlockItem(R.drawable.final_line);

        character1.setID("character1");
        character2.setID("character2");
        final_line.setID("final_line");



        CodeBlocks.add(one);
        CodeBlocks.add(two);
        CodeBlocks.add(three);

        CodeBlocks.add(final_line);

        CodeBlocks.add(character1);
        CodeBlocks.add(character2);
        CodeBlocks.add(character3);

    }


}

