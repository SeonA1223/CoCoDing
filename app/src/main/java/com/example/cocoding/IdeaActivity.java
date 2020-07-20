package com.example.cocoding;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.annotation.NonNull;

public class IdeaActivity extends BaseActivity {


    @Override
    int getContentViewId() {
        return R.layout.activity_idea;
    }

    @Override
    int getNavigationMenuItemId() {
        return R.id.navigation_idea;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.back, menu);
        return true;
    }

}