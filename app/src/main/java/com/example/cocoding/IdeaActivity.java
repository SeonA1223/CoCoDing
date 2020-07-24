package com.example.cocoding;

import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class IdeaActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.e("come?", "[" + savedInstanceState + "]");

    }


    @Override
    int getNavigationMenuItemId() {
        return R.id.navigation_idea;
    }

    @Override
    int getContentViewId() {
        return R.layout.activity_idea;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.back, menu);
        return true;
    }

}