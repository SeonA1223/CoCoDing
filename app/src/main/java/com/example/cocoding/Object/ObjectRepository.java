package com.example.cocoding.Object;

import java.util.ArrayList;
import java.util.List;

// 폴더, 객체 저장하는 곳
public class ObjectRepository {

    // 폴더마다 리스트가 있고, 그 속에 객체를 저장
    private List<Integer> folder = new ArrayList<>();

//    public void addFolder(int input){
//        folder.add(input);
//    }
//
//    public void addObject(int folderPos, int objectPos){
//
//    }

    public void addObject(int objectPos){
        folder.add(objectPos);
    }


}
