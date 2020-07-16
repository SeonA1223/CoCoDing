package com.example.cocoding.Object;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;

// "객체" 데이터 형식
public class ObjectData implements Parcelable {

    private Uri userObjectImage;
    private String objectName;

    public ObjectData(){

    }

    protected ObjectData(Parcel in) {
        userObjectImage = in.readParcelable(Uri.class.getClassLoader());
        objectName = in.readString();
    }

    public static final Creator<ObjectData> CREATOR = new Creator<ObjectData>() {
        @Override
        public ObjectData createFromParcel(Parcel in) {
            return new ObjectData(in);
        }

        @Override
        public ObjectData[] newArray(int size) {
            return new ObjectData[size];
        }
    };

    public String getobjectName() {
        return objectName;
    }

    public void setobjectName(String objectName) {
        this.objectName = objectName;
    }

    public Uri getuserObjectImage(){return userObjectImage;}

    public void setuserObjectImage(Uri uri) {this.userObjectImage = uri;}

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeParcelable(userObjectImage, flags);
        dest.writeString(objectName);
    }
}
