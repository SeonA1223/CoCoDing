package com.example.cocoding.Code.Block.Motion;

import android.animation.Animator;
import android.animation.ObjectAnimator;

import com.example.cocoding.Code.Block.BlockItem;

public class Change extends BlockItem {

    int x = 0;

    public Change(int image) {
        super(image);
    }

    public void setX(int x){
        this.x = x;
    }

    @Override
    public String getID() {
        return "Change";
    }

    @Override
    public Animator getCode() {
        return ObjectAnimator.ofFloat(object, "translationX", x);
    }
}
