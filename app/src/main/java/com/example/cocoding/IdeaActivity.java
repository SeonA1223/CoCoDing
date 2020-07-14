package com.example.cocoding;

import android.os.Bundle;

public class IdeaActivity extends BaseActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_idea);
    }


    @Override
    int getContentViewId() {
        return R.layout.activity_idea;
    }

    @Override
    int getNavigationMenuItemId() {
        return R.id.navigation_home;
    }

}