package com.example.cocoding.Code.Block.Motion;

import android.animation.Animator;
import android.animation.ObjectAnimator;

import com.example.cocoding.Code.Block.BlockItem;

public class Rotation_Left extends BlockItem {

    int rotation = 0;

    public Rotation_Left(int image) {
        super(image);
    }

    public void setRotation(int rotation){
        this.rotation = rotation;
    }

    @Override
    public String getID() {
        return "Rotation_Left";
    }



    public Animator getCode(){
        return ObjectAnimator.ofFloat(object, "rotation", -rotation);
    }


}
