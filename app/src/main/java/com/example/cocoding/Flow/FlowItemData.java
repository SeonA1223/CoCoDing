package com.example.cocoding.Flow;

import com.example.cocoding.RecyclerviewItem;
import com.example.cocoding.R;
import com.example.cocoding.RecyclerviewItem;

import java.util.ArrayList;

public class FlowItemData {

    FlowItem shape1 = new FlowItem(R.drawable.shapeellipse_flowmain_popup_image_nocolor, "Start");
    FlowItem shape2 = new FlowItem(R.drawable.shaperectangle_flowmain_popup_image_nocolor, "Command");
    FlowItem shape3 = new FlowItem(R.drawable.shape_rectangle_left_flowmain_popup_image_nocolor, "Command\n" + "for left side");
    FlowItem shape4 = new FlowItem(R.drawable.shape_rectangle_right_flowmain_popup_image_nocolor, "Command\n" + "for right side");
    FlowItem shape5 = new FlowItem(R.drawable.shaperhombus_flowmain_popup_image_nocolor, "Condition");



    ArrayList<FlowItem> flowItems = new ArrayList<>();

    public FlowItemData() {

        flowItems.add(shape1);
        flowItems.add(shape2);
        flowItems.add(shape3);

        flowItems.add(shape4);
        flowItems.add(shape5);

    }

    public ArrayList<FlowItem> getFlowItems() {


        return flowItems;
    }

    public FlowItem getItem(int position) {
        return flowItems.get(position);
    }
}
