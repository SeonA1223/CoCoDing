package com.example.cocoding.Code.Block.Motion;

import com.example.cocoding.Code.Block.BlockItem;
import com.example.cocoding.Code.Block.BlockItems;
import com.example.cocoding.R;

public class Motion extends BlockItems {


    BlockItem motion_change;
    BlockItem motion_rotate_left;
    BlockItem motion_rotate_right;
    BlockItem motion_set;

    public Motion() {
        motion_rotate_left = new Rotate_Left(R.drawable.motion_rotate_left);
        motion_rotate_right = new Rotate_Right(R.drawable.motion_rotate_right);
        motion_change = new Change(R.drawable.motion_change);
        motion_set = new Set(R.drawable.motion_set);

        CodeBlocks.add(motion_set);
        CodeBlocks.add(motion_rotate_left);
        CodeBlocks.add(motion_rotate_right);
        CodeBlocks.add(motion_change);



    }


}
