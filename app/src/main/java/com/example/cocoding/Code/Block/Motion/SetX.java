package com.example.cocoding.Code.Block.Motion;

import com.example.cocoding.Code.Block.BlockItem;

public class SetX extends BlockItem {

    public SetX(int image) {
        super(image);
    }

    @Override
    public String getID() {
        return "SetX";
    }

    public void setX(int x){
        object.setX(x);

    }
}
