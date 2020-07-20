package com.example.cocoding;

import android.view.Menu;

public class FlowActivity extends BaseActivity {


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