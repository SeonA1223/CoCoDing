package com.example.cocoding;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.NavUtils;

import com.example.cocoding.Code.ExecutionActivity;

public class CodeMainActivity extends BaseActivity {

    ImageView codeflow0, codeflow1, codeflow2, codeflow3, codeflow4,
            codeflow5, codeflow6;

    ImageView execution;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        execution = (ImageView) findViewById(R.id.video_execution);

        Toolbar mToolbar = (Toolbar) findViewById(R.id.codemain_toolbar);

        setSupportActionBar(mToolbar);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.drawable_back_image_customise);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("");


        codeflow0 = (ImageView) findViewById(R.id.codeflow0);
        codeflow1 = (ImageView) findViewById(R.id.codeflow1);
        codeflow2 = (ImageView) findViewById(R.id.codeflow2);
        codeflow3 = (ImageView) findViewById(R.id.codeflow3);
        codeflow4 = (ImageView) findViewById(R.id.codeflow4);
        codeflow5 = (ImageView) findViewById(R.id.codeflow5);
        codeflow6 = (ImageView) findViewById(R.id.codeflow6);


        codeflow0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), CodeActivity.class);
                startActivityForResult(intent, 100); //deprecated인데 사용은 가능하대ㅎㅎ

            }
        });

        codeflow1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), CodeActivity2.class);
                //   intent.putExtra("block_button", false);
                startActivity(intent);
            }
        });

        execution.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), ExecutionActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 100) {
            if (resultCode == RESULT_OK) {
                codeflow0.setImageResource(R.drawable.blue_shape_1_codemain_png);
                codeflow1.setImageResource(R.drawable.blue_shape_2_codemain_png);
                codeflow2.setImageResource(R.drawable.purple_shape_1_codemain_png);
                codeflow3.setImageResource(R.drawable.purple_shape_2_codemain_png);
                codeflow4.setImageResource(R.drawable.green_shape_2_codemain_png);
                codeflow5.setImageResource(R.drawable.green_shape_3_codemain_png);
                codeflow5.setImageResource(R.drawable.green_shape_4_codemain_png);
            }
        }
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
        switch (item.getItemId()) {
            case android.R.id.home: { //toolbar의 back키 눌렀을 때 동작
                NavUtils.navigateUpFromSameTask(this);
                return true;
            }
        }
        return super.onOptionsItemSelected(item);
    }


}