package com.example.cocoding.Code.Block.Motion;

import android.animation.Animator;
import android.animation.ObjectAnimator;

import com.example.cocoding.Code.Block.BlockItem;

public class ChangeX extends BlockItem {

    int x = 0;

    public ChangeX(int image) {
        super(image);
    }

    public void setX(int x){
        this.x = x;
    }

    @Override
    public String getID() {
        return "ChangeX";
    }

    @Override
    public Animator getCode() {
        return ObjectAnimator.ofFloat(object, "translationX", x);
    }
}
