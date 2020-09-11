package com.example.cocoding;

import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.fragment.app.FragmentTransaction;

import com.example.cocoding.Code.CodeBlockPage;
import com.example.cocoding.Code.CodeRecyclerviewToPage;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;

public class CodeActivity extends BaseActivity implements CodeRecyclerviewToPage {

    Button code_shape; //버튼 클릭시 CodeBlockPage fragment 뜸
    CodeBlockPage codeBlockPage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        code_shape = (Button) findViewById(R.id.code_block);

        codeBlockPage = new CodeBlockPage();
        code_shape.setOnClickListener(new Button.OnClickListener() {

            @Override
            public void onClick(View v) {
                codeBlockPage.show(getSupportFragmentManager(), "check");

            }


        });
    }

    @Override
    protected void onStart() {
        super.onStart();

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
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.back, menu);
        return true;
    }

    @Override
    public ImageView makeBlock(int blockImage) {
        ImageView imageView = new ImageView(this);
        imageView.setImageResource(blockImage);
        return imageView;
    }

//    public ArrayList BlockDB(){
//
//    }
}