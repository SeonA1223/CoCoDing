package com.example.cocoding.Flow;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.cocoding.R;

import java.util.ArrayList;

public class MakeFlowListAdapter extends BaseAdapter {

    ArrayList<Integer> flowshape;

    public MakeFlowListAdapter(ArrayList<Integer> flowshape) {
        this.flowshape = flowshape;
    }

    @Override
    public int getCount() {
        return flowshape.size();
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView == null){
            convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_flow_make_flow, parent, false);
            TextView
        }
        return convertView;
    }
}
