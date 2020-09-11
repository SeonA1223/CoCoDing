package com.example.cocoding.Code;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cocoding.R;
import com.example.cocoding.RecyclerviewItem;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

import java.util.ArrayList;

public class CodeRecyclerview extends Fragment {

    //viewpager 내에 보여지는 recyclerview
    RecyclerView recyclerView;
    Recyclerview_Code_ItemAdapter codeItemAdapter;
    CodeBlockData codeBlockData0, codeBlockData1, codeBlockData2, codeBlockData3, codeBlockData4, codeBlockData5, codeBlockData6, codeBlockData7; //data 모음
    Context context;
    int position;
   ArrayList<RecyclerviewItem> arrayList; //RecyclerviewItem = image set 하는 class

    private CodeRecyclerviewToPage mCallback; //fragment에서 activity로 데이터 전달

   //ViewPager와 연결하기 위한 positioin 설정 위해 생성자에서 설정
    public CodeRecyclerview(int position) {
        this.position = position;
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

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
        * codeBlockData7 : ?더 있나?
        * */
        codeBlockData0 = new CodeBlockData0();
        codeBlockData1 = new CodeBlockData1();
        codeBlockData2 = new CodeBlockData2();
        codeBlockData3 = new CodeBlockData3();
        codeBlockData4 = new CodeBlockData4();
        codeBlockData5 = new CodeBlockData5();
        codeBlockData6 = new CodeBlockData6();
        codeBlockData7 = new CodeBlockData7();

  //      Log.e("확인", "[" + codeBlockData0.getCodeBlocks() + codeBlockData0.getCodeBlocks().size() + "]");


        //현재 블럭 한 열당 4개 해놓았는데 1개씩으로 바뀔 수 있음 이야기해봐야함
        GridLayoutManager gridLayoutManager = new GridLayoutManager(context, 4);
        arrayList = new ArrayList<RecyclerviewItem>();
        arrayList.addAll(codeBlockData0.getCodeBlocks()); //초기 설정 codeBlockData0으로 set
        codeItemAdapter = new Recyclerview_Code_ItemAdapter(context, arrayList);
        recyclerView.setLayoutManager(gridLayoutManager);
        recyclerView.setAdapter(codeItemAdapter);


     //    Log.e("arraylist", "[" + CodeBlockPage.Position + "]");

        //position에 따라 arrayList 값 바뀌고 대체!
        switch (position) {
            case 0:
                arrayList.clear();
                arrayList.addAll(codeBlockData0.getCodeBlocks());
               //recyclerviewItemAdapter.updateData(codeBlockData0.getCodeBlocks());
                break;
            case 1:
                arrayList.clear();
                arrayList.addAll(codeBlockData1.getCodeBlocks());
                break;
            case 2:
                arrayList.clear();
                arrayList.addAll(codeBlockData2.getCodeBlocks());
                break;
            case 3:
                arrayList.clear();
                arrayList.addAll(codeBlockData3.getCodeBlocks());
                break;
            case 4:
                arrayList.clear();
                arrayList.addAll(codeBlockData4.getCodeBlocks());
                break;
            case 5:
                arrayList.clear();
                arrayList.addAll(codeBlockData5.getCodeBlocks());
                break;
            case 6:
                arrayList.clear();
                arrayList.addAll(codeBlockData6.getCodeBlocks());
                break;
            case 7:
                arrayList.clear();
                arrayList.addAll(codeBlockData7.getCodeBlocks());
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
            public void onItemClick(View view, int blockImage) {
                mCallback.makeBlock(blockImage);
            }
        });
    }
}

