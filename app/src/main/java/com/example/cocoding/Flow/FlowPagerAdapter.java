package com.example.cocoding.Flow;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.fragment.app.FragmentStatePagerAdapter;

public class FlowPagerAdapter extends FragmentPagerAdapter {
//makeFlowFragment와 signalFragment 연결하는 Adapter
    private int mPageCount;


    public FlowPagerAdapter(FragmentManager fm, int mPageCount) {
        super(fm);
        this.mPageCount = mPageCount;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                MakeFlowFragment makeFlowFragment = new MakeFlowFragment();
                return makeFlowFragment;
            case 1:
                SignalFragment signalFragment = new SignalFragment();
                return signalFragment;
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return mPageCount;
    }
}

