package com.example.cocoding.Code.Block.Event;

import com.example.cocoding.Code.Block.BlockItem;
import com.example.cocoding.Code.Block.BlockItems;
import com.example.cocoding.R;

public class Event extends BlockItems {

    BlockItem event_click_exceptxy_medium;

    BlockItem event_click_exceptxy_start;

    BlockItem event_clickxy_medium;

    BlockItem event_clickxy_start;

    BlockItem event_object_clicked_medium;

    BlockItem event_object_clicked_start;

    BlockItem event_play_clicked;

    BlockItem event_receive_signal;

    BlockItem event_send_signal_andwait;

    BlockItem event_send_signal;

    public Event() {
//        BlockItem block4 = new BlockItem(R.drawable.block4);
//        CodeBlocks.add(block4);

        event_click_exceptxy_medium = new Click_Exceptxy_Medium(R.drawable.event_click_exceptxy_medium);

        event_click_exceptxy_start = new Click_Exceptxy_Start(R.drawable.event_click_exceptxy_start);

        event_clickxy_medium = new Clickxy_Medium(R.drawable.event_clickxy_medium);

        event_clickxy_start = new Clickxy_Start(R.drawable.event_clickxy_start);

        event_object_clicked_medium = new Object_Clicked_Medium(R.drawable.event_object_clicked_medium);

        event_object_clicked_start = new Object_Clicked_Start(R.drawable.event_object_clicked_start);

        event_play_clicked = new Play_Clicked(R.drawable.event_play_clicked);

        event_receive_signal = new Receive_Signal(R.drawable.event_receive_signal);

        event_send_signal_andwait = new Send_Signal_Andwait(R.drawable.event_send_signal_andwait);

        event_send_signal = new Send_Signal(R.drawable.event_send_signal);

        CodeBlocks.add(event_play_clicked);
        CodeBlocks.add(event_click_exceptxy_medium);
        CodeBlocks.add(event_click_exceptxy_start);
        CodeBlocks.add(event_clickxy_medium);
        CodeBlocks.add(event_clickxy_start);
        CodeBlocks.add(event_object_clicked_medium);
        CodeBlocks.add(event_object_clicked_start);

        CodeBlocks.add(event_receive_signal);
        CodeBlocks.add(event_send_signal);
        CodeBlocks.add(event_send_signal_andwait);

        for(BlockItem blockItem : CodeBlocks){
            blockItem.setType("Event");
        }
    }

}
