package com.example.cocoding.Code;

import com.example.cocoding.RecyclerviewItem;
import com.example.cocoding.R;

import java.util.ArrayList;

public class CodeBlockData {

    ArrayList<RecyclerviewItem> CodeBlocks = new ArrayList<>();

    //각 BlockData마다 이미지 종류 다르기 때문에 지금은 여기서 이미지 선언하지만 후에는 각 클래스에서 다르게 선언해줘야 함
    //서버에서 가져올 수도 있음

    public ArrayList<RecyclerviewItem> getCodeBlocks(){
        return CodeBlocks;
    }

    public int getImageData(int data_position){
        return 0;

    }
}
