package com.example.cocoding.Code.Block;

import android.animation.Animator;
import android.media.Image;
import android.os.Parcel;
import android.os.Parcelable;
import android.provider.ContactsContract;
import android.widget.ImageView;

import androidx.constraintlayout.widget.ConstraintLayout;

import com.example.cocoding.RecyclerviewItem;

import java.io.Serializable;

public class BlockItem implements Parcelable {

    int block_image;
    public ImageView object;
    public ImageView imageView;
    int Layout;
    ConstraintLayout constraintLayout;
    String id, type;


    public BlockItem(int image) {
        block_image = image;
    }

    protected BlockItem(Parcel in) {
        block_image = in.readInt();
        Layout = in.readInt();
        id = in.readString();
        type = in.readString();
    }

    public static final Creator<BlockItem> CREATOR = new Creator<BlockItem>() {
        @Override
        public BlockItem createFromParcel(Parcel in) {
            return new BlockItem(in);
        }

        @Override
        public BlockItem[] newArray(int size) {
            return new BlockItem[size];
        }
    };

    public int getBlockImage() {
        return block_image;
    }

    public void setBlockImage(int image) {
        block_image = image;
    }

    public void setObject(ImageView imageView) {
        this.object = imageView;
    }

    public Animator getCode() {
        return null;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getID() {
        return id;
    }

    public void setID(String id){
        this.id = id;
    }

    public void setImage(ImageView imageView) {
        this.imageView = imageView;
    }

    public ImageView getImage() {
        return imageView;
    }

    public int getLayout() {
        return Layout;
    }

    public void setLayout(int layout) {
        this.Layout = layout;
    }

    public ConstraintLayout getConstraintLayout() {
        return constraintLayout;
    }

    public void setConstraintLayout(ConstraintLayout constraintLayout) {
        this.constraintLayout = constraintLayout;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(block_image);
        dest.writeInt(Layout);
        dest.writeString(id);
        dest.writeString(type);
    }
//    public int getInt() {
//        return 0;
//    }


}
