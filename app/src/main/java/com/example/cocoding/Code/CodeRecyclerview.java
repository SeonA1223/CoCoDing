package com.example.cocoding.Code;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cocoding.Code.Block.BlockItem;
import com.example.cocoding.Code.Block.Caculation.Calculation;
import com.example.cocoding.Code.Block.BlockItems;
import com.example.cocoding.Code.Block.Control.Control;
import com.example.cocoding.Code.Block.Event.Event;
import com.example.cocoding.Code.Block.Motion.Motion;
import com.example.cocoding.Code.Block.Object;
import com.example.cocoding.Code.Block.Looks.Looks;
import com.example.cocoding.Code.Block.Variable.Variable;
import com.example.cocoding.R;

import java.util.ArrayList;

public class CodeRecyclerview extends Fragment {

    //viewpager 내에 보여지는 recyclerview
    RecyclerView recyclerView;
    Recyclerview_Code_ItemAdapter codeItemAdapter;
    BlockItems Motion, Shape, Event, Control, Calculation, variable, Object; //data 모음
    Context context;
    int position;
   ArrayList<BlockItem> arrayList; //RecyclerviewItem = image set 하는 class



   //ViewPager와 연결하기 위한 positioin 설정 위해 생성자에서 설정
    public CodeRecyclerview(int position) {
        this.position = position;
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    private CodeRecyclerviewToPage mCallback; //fragment에서 activity로 데이터 전달
    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        try {
            mCallback = (CodeRecyclerviewToPage) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString()
                    + " must implement FragmentToActivity");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, final ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_code_item_recyclerview, container, false);
        context = container.getContext();
        recyclerView = (RecyclerView) view.findViewById(R.id.code_recyclerview);
        //카테고리에 해당하는 블럭들(이미지) 객체 생성
        /*
        * codeBlockData0 : motion
        * codeBlockData1 : shape
        * codeBlockData2 : event
        * codeBlockData3 : control
        * codeBlockData4 : calculation
        * codeBlockData5 : variable
        * codeBlockData6 : object(image)
        * */
        Motion = new Motion();
        Shape = new Looks();
        Event = new Event();
        Control = new Control();
        Calculation = new Calculation();
        variable = new Variable();
        Object = new Object();

       GridLayoutManager gridLayoutManager = new GridLayoutManager(context, 1);
        arrayList = new ArrayList<BlockItem>();
        arrayList.addAll(Motion.getCodeBlocks()); //초기 설정 codeBlockData0으로 set
        codeItemAdapter = new Recyclerview_Code_ItemAdapter(context, arrayList);
        recyclerView.setLayoutManager(gridLayoutManager);
        recyclerView.setAdapter(codeItemAdapter);
        recyclerView.addItemDecoration(new CodeRecyclerview_ItemDecoration(getContext()));

        //position에 따라 arrayList 값 바뀌고 대체!
        switch (position) {
            case 0:
                arrayList.clear();
                arrayList.addAll(Object.getCodeBlocks());
                break;
            case 1:
                arrayList.clear();
                arrayList.addAll(Motion.getCodeBlocks());
               //recyclerviewItemAdapter.updateData(codeBlockData0.getCodeBlocks());
                break;
            case 2:
                arrayList.clear();
                arrayList.addAll(Shape.getCodeBlocks());
                break;
            case 3:
                arrayList.clear();
                arrayList.addAll(Event.getCodeBlocks());
                break;
            case 4:
                arrayList.clear();
                arrayList.addAll(Control.getCodeBlocks());
                break;
            case 5:
                arrayList.clear();
                arrayList.addAll(Calculation.getCodeBlocks());
                break;
            case 6:
                arrayList.clear();
                arrayList.addAll(variable.getCodeBlocks());
                break;


        }

        //arraylist값 바뀐 것 Adapter에 알려주기
      //  recyclerView.invalidate();
        codeItemAdapter.notifyDataSetChanged();
        recyclerView.setLayoutManager(gridLayoutManager);
        recyclerView.setAdapter(codeItemAdapter);

        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        codeItemAdapter.setOnItemClickListener(new Recyclerview_Code_ItemAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, BlockItem blockItem) {
                mCallback.getBlockImage(blockItem);
            }
        });
    }
}

