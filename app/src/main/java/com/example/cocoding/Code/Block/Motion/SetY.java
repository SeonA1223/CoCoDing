package com.example.cocoding.Code.Block.Motion;

import com.example.cocoding.Code.Block.BlockItem;

public class SetY extends BlockItem {

    public SetY(int image) {
        super(image);
    }

    @Override
    public String getID() {
        return "SetY";
    }

    public void setY(int y){
        object.setY(y);

    }
}
