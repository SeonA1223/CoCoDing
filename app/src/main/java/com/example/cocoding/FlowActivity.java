package com.example.cocoding;

import android.os.Bundle;
import android.view.Menu;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.example.cocoding.Flow.FlowPagerAdapter;
import com.google.android.material.tabs.TabLayout;

public class FlowActivity extends BaseActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flow);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.flow_tablayout);
        tabLayout.addTab(tabLayout.newTab().setText("흐름도 만들기"), 0, true);
        tabLayout.addTab(tabLayout.newTab().setText("신호"), 1);

        final ViewPager viewPager = (ViewPager) findViewById(R.id.flow_viewpager);
        FlowPagerAdapter flowPagerAdapter = new FlowPagerAdapter(getSupportFragmentManager(), tabLayout.getTabCount());
        viewPager.setAdapter(flowPagerAdapter);

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
    }

    @Override
    int getContentViewId() {
        return R.layout.activity_flow;
    }

    @Override
    int getNavigationMenuItemId() {
        return R.id.navigation_flow;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.back, menu);
        return true;
    }
}
