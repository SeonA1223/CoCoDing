package com.example.cocoding.Code.Block;

import android.animation.Animator;
import android.media.Image;
import android.provider.ContactsContract;
import android.widget.ImageView;

import androidx.constraintlayout.widget.ConstraintLayout;

import com.example.cocoding.RecyclerviewItem;

public class BlockItem {

    int block_image;
    public ImageView object;
    public ImageView imageView;
    ConstraintLayout constraintLayout;

    public BlockItem(int image) {
        block_image = image;
    }

    public BlockItem(ConstraintLayout constraintLayout){
        this.constraintLayout = constraintLayout;
    }


    public int getBlockImage() {
        return block_image;
    }

    public void setBlockImage(int image) {
        block_image = image;
    }

    public void setObject(ImageView imageView){
        this.object = imageView;
    }

    public Animator getCode() {
        return null;
    }

    public String getID() {
        return null;
    }

    public void setImage(ImageView imageView) {
        this.imageView = imageView;
    }

    public ImageView getImage(){
        return imageView;
    }

    public ConstraintLayout getConstraintLayout() {
        return constraintLayout;
    }

    public void setConstraintLayout(ConstraintLayout constraintLayout) {
        this.constraintLayout = constraintLayout;
    }

    //    public int getInt() {
//        return 0;
//    }



}
