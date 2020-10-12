package com.example.cocoding;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentTransaction;

import com.example.cocoding.Code.CodeBlockPage;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class CodeActivity extends BaseActivity {

    ImageView code_shape;
    CodeBlockPage codeBlockPage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_code);


        code_shape = (ImageView) findViewById(R.id.code_block);

        codeBlockPage = new CodeBlockPage();

        code_shape.setOnClickListener(new Button.OnClickListener() {

            @Override
            public void onClick(View v) {
//                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
//                transaction.add(R.id.content, codeBlockPage);
//                transaction.commit();
                codeBlockPage.show(getSupportFragmentManager(), "check");

            }


        });

        Toolbar mmToolbar = (Toolbar) findViewById(R.id.code_toolbar);
        setSupportActionBar(mmToolbar);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.drawable_back_image_customise);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("");

    }


    @Override
    int getNavigationMenuItemId() {
        return R.id.navigation_code;
    }

    @Override
    int getContentViewId() {
        return R.layout.activity_code;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:{ //toolbar의 back키 눌렀을 때 동작
                finish();
                return true;
            }
        }
        return super.onOptionsItemSelected(item);
    }

}