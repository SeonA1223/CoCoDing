package com.example.cocoding.Code.Block.Motion;

import android.animation.Animator;
import android.animation.ObjectAnimator;

import com.example.cocoding.Code.Block.BlockItem;

public class ChangeY extends BlockItem {

    int y = 0;

    public ChangeY(int image) {
        super(image);
    }

    public void setY(int y){
        this.y = y;
    }

    @Override
    public String getID() {
        return "ChangeY";
    }

    @Override
    public Animator getCode() {
        return ObjectAnimator.ofFloat(object, "translationY", y);
    }
}
