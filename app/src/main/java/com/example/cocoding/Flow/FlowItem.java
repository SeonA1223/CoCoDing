package com.example.cocoding.Flow;

import com.example.cocoding.RecyclerviewItem;

public class FlowItem extends RecyclerviewItem {

    String name;
    public FlowItem(int image, String name) {
        super(image);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
