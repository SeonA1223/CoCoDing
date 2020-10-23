package com.example.cocoding;

import android.graphics.Bitmap;
import android.widget.ImageView;

public class RecyclerviewItem {

    int image;
    //server URL인 경우 image 자료형 String으로 바꿔줄 것, 지금은 서버 없이 실험용

    public RecyclerviewItem(int image){
        super();

        this.image = image;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}
