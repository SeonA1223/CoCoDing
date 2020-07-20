package com.example.cocoding;

import android.view.Menu;

public class CodeActivity extends BaseActivity {


    @Override
    int getContentViewId() {
        return R.layout.activity_code;
    }

    @Override
    int getNavigationMenuItemId() {
        return R.id.navigation_code;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.back, menu);
        return true;
    }

}