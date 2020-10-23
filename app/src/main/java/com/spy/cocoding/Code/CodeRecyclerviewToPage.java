package com.example.cocoding.Code;

import android.widget.ImageView;

import com.example.cocoding.Code.Block.BlockItem;

import java.util.ArrayList;
//recyclerview에서 CodeActivity로 데이터 전달방법
// (현재는 blockImage만 전달하지만, 객체로 전달을 통해, 코드까지 갖고 오는 방식을 선택할 예정 또는 다른 방법?)
public interface CodeRecyclerviewToPage {
    void getBlockImage(BlockItem blockItem);
}
