package com.example.cocoding.Flow;

import com.example.cocoding.RecyclerviewItem;
import com.example.cocoding.R;
import com.example.cocoding.RecyclerviewItem;

import java.util.ArrayList;

public class FlowItemData {

    RecyclerviewItem shape1 = new RecyclerviewItem(R.drawable.shapeellipse_flowmain_2_popup_image);
    RecyclerviewItem shape2 = new RecyclerviewItem(R.drawable.shaperectangle_flowmain_2_popup_image);
    RecyclerviewItem shape3 = new RecyclerviewItem(R.drawable.shape_rectangle_left_flowmain_2_popup_image);
    RecyclerviewItem shape4 = new RecyclerviewItem(R.drawable.shape_rectangle_right_flowmain_2_popup_image);
    RecyclerviewItem shape5 = new RecyclerviewItem(R.drawable.shaperhombus_flowmain_2_popup_image);

    ArrayList<RecyclerviewItem> flowItems = new ArrayList<>();

    public FlowItemData() {
        flowItems.add(shape1);
        flowItems.add(shape2);
        flowItems.add(shape3);

        flowItems.add(shape4);
        flowItems.add(shape5);

    }

    public ArrayList<RecyclerviewItem> getFlowItems() {


        return flowItems;
    }

    public RecyclerviewItem getItem(int position) {
        return flowItems.get(position);
    }
}
