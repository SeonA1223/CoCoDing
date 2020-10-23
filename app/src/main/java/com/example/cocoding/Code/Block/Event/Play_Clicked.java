package com.example.cocoding.Code.Block.Event;

import com.example.cocoding.Code.Block.BlockItem;

public class Play_Clicked extends BlockItem {


    public Play_Clicked(int image) {
        super(image);
    }

    @Override
    public String getID() {
        return "playClicked";
    }
}