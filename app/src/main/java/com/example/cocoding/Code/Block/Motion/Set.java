package com.example.cocoding.Code.Block.Motion;

import androidx.constraintlayout.widget.ConstraintLayout;

import com.example.cocoding.Code.Block.BlockItem;
import com.example.cocoding.Code.Block.Execution;
import com.example.cocoding.R;

public class Set extends BlockItem {

    public Set(int image) {
        super(image);
    }

    int layout;

    @Override
    public String getID() {
        return "Set";
    }

    public void set(int x, int y){
        object.setX(x);
        object.setY(y);

    }
}
