package com.example.cocoding.Code;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.example.cocoding.R;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.google.android.material.tabs.TabLayout;

import static com.google.android.material.tabs.TabLayout.MODE_SCROLLABLE;

public class CodeBlockPage extends BottomSheetDialogFragment {

    private TabLayout tabLayout;
    private ViewPager viewPager;
    int position;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        // flow 화면에서 상단에 두 탭을 만듦. 기본 세팅은 MakeFlowFragment 선택(setSelected true)

        View view = inflater.inflate(R.layout.fragment_code_block_page, container, false);
        viewPager = (ViewPager) view.findViewById(R.id.code_viewpager);
        tabLayout = (TabLayout) view.findViewById(R.id.code_tablayout);
        tabLayout.addTab(tabLayout.newTab().setText("Object"), 0);
        tabLayout.addTab(tabLayout.newTab().setText("Motion"), 1);
        tabLayout.addTab(tabLayout.newTab().setText("Shape"), 2);
        tabLayout.addTab(tabLayout.newTab().setText("Event"), 3);
        tabLayout.addTab(tabLayout.newTab().setText("Control"), 4);
        tabLayout.addTab(tabLayout.newTab().setText("calculation"), 5);
        tabLayout.addTab(tabLayout.newTab().setText("variable"), 6);
        tabLayout.setTabMode(MODE_SCROLLABLE);

        //   Log.e("확인", "[" + tabLayout.getSelectedTabPosition() + "]");

        CodePagerAdapter codePagerAdapter = new CodePagerAdapter(getChildFragmentManager(), tabLayout.getTabCount());

        viewPager.setAdapter(codePagerAdapter);


        viewPager.addOnPageChangeListener(
                new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {

            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }


            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
            }


        });

        return view;

    }

}
