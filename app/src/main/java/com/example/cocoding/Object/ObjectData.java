package com.example.cocoding.Object;

import android.net.Uri;

// "객체" 데이터 형식
public class ObjectData {

    private Uri userObjectImage;
    private String objectName;

    public String getobjectName() {
        return objectName;
    }

    public void setobjectName(String objectName) {
        this.objectName = objectName;
    }

    public Uri getuserObjectImage(){return userObjectImage;}

    public void setuserObjectImage(Uri uri) {this.userObjectImage = uri;}
}
