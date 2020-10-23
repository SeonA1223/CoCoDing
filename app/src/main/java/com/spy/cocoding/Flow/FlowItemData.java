package com.example.cocoding.Flow;

import com.example.cocoding.RecyclerviewItem;
import com.example.cocoding.R;
import com.example.cocoding.RecyclerviewItem;

import java.util.ArrayList;

public class FlowItemData {

    RecyclerviewItem shape1 = new RecyclerviewItem(R.drawable.shape1);
    RecyclerviewItem shape2 = new RecyclerviewItem(R.drawable.shape2);
    RecyclerviewItem shape3 = new RecyclerviewItem(R.drawable.shape3);
    RecyclerviewItem shape4 = new RecyclerviewItem(R.drawable.shape4);
    RecyclerviewItem shape5 = new RecyclerviewItem(R.drawable.shape5);
    RecyclerviewItem shape6 = new RecyclerviewItem(R.drawable.shape6);

    ArrayList<RecyclerviewItem> flowItems = new ArrayList<>();

    public FlowItemData() {
        flowItems.add(shape1);
        flowItems.add(shape2);
        flowItems.add(shape3);

        flowItems.add(shape4);
        flowItems.add(shape5);
        flowItems.add(shape6);

    }

    public ArrayList<RecyclerviewItem> getFlowItems() {


        return flowItems;
    }

    public RecyclerviewItem getItem(int position) {
        return flowItems.get(position);
    }
}
