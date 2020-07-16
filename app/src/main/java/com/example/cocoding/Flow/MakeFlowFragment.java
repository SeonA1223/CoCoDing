package com.example.cocoding.Flow;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

//import androidx.fragment.app.FragmentResultListener;
import androidx.fragment.app.FragmentResultListener;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ListView;
import android.widget.TextView;

import com.example.cocoding.R;
import com.example.cocoding.RecyclerviewItem;

import java.util.ArrayList;


public class MakeFlowFragment extends Fragment {
    //흐름도 만들기 페이지
    Button flow_shape;
    ListView listView;
    FlowItemData flowItemData;
    FlowItemRecyclerview flowItemRecyclerview;
    MakeFlowListAdapter makeFlowListAdapter;

    int imageNumber;
    int mNumber = 0;

    ArrayList<Integer> listItems = new ArrayList<>();

    public MakeFlowFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

    }

    @SuppressLint("ClickableViewAccessibility")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_flow_make_flow, container, false);

        flow_shape = (Button) view.findViewById(R.id.flow_figure);
        listView = (ListView) view.findViewById(R.id.flow_make_listview);

        makeFlowListAdapter = new ArrayAdapter<Integer>(this, )
        flowItemRecyclerview = new FlowItemRecyclerview();
        flowItemData = new FlowItemData();
        flow_shape.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                flowItemRecyclerview.show(getChildFragmentManager(), "please");
            }

        });

        return view;

    }

    @Override
    public void onResume() {
        super.onResume();
        if (flowItemRecyclerview != null) {
            getChildFragmentManager().setFragmentResultListener("requestKey", this, new FragmentResultListener() {
                @Override
                public void onFragmentResult(@NonNull String requestKey, @NonNull Bundle result) {
                    imageNumber = result.getInt("itemPosition");
                    Log.e("Fragment data send", "[" + imageNumber + "]");
                    listItems.add(flowItemData.getItem(imageNumber).getImage());
                }
            });
        }
    }

//    private TextView makeTextView(int imageNumber) {
//        TextView imageview = new TextView(context);
//        imageview.setBackgroundResource(flowItemData.getItem(imageNumber).getImage());
//        LinearLayout.LayoutParams layoutParams = (LayoutParams) new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
//        layoutParams.gravity = Gravity.CENTER;
//        layoutParams.setMargins(100, 20, 100, 20);
//        imageview.setLayoutParams(layoutParams);
//
//        linearLayout.addView(imageview);
//
//        return imageview;
//    }

}
