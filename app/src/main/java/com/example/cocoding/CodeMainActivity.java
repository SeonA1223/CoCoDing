package com.example.cocoding;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.widget.Toolbar;
import androidx.core.app.NavUtils;

import com.example.cocoding.Idea.Idea_Algorithm;
import com.example.cocoding.Idea.Idea_Topic;
import com.example.cocoding.Idea.Idea_Topic_Content;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import static android.content.ContentValues.TAG;

public class CodeMainActivity extends BaseActivity {

    ImageView codeflow_one;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Toolbar mToolbar = (Toolbar) findViewById(R.id.codemain_toolbar);
        setSupportActionBar(mToolbar);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.drawable_back_image_customise);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("");


        codeflow_one = (ImageView)findViewById(R.id.codeflow_one);


        codeflow_one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), CodeActivity.class);
                startActivity(intent);
            }
        });



    }


    @Override
    int getNavigationMenuItemId() {
        return R.id.navigation_code;
    }

    @Override
    int getContentViewId() {
        return R.layout.activity_codemain;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:{ //toolbar의 back키 눌렀을 때 동작
                NavUtils.navigateUpFromSameTask(this);
                return true;
            }
        }
        return super.onOptionsItemSelected(item);
    }



}