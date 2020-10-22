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

    ImageView codeflow1, codeflow2, codeflow3, codeflow4,
            codeflow5, codeflow6, codeflow7, codeflow8,
            codeflow9, codeflow10, codeflow11, codeflow12;

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


        codeflow1 = (ImageView) findViewById(R.id.codeflow1);
        codeflow2 = (ImageView) findViewById(R.id.codeflow2);
        codeflow3 = (ImageView) findViewById(R.id.codeflow3);
        codeflow4 = (ImageView) findViewById(R.id.codeflow4);
        codeflow5 = (ImageView) findViewById(R.id.codeflow5);
        codeflow6 = (ImageView) findViewById(R.id.codeflow6);
        codeflow7 = (ImageView) findViewById(R.id.codeflow7);
        codeflow8 = (ImageView) findViewById(R.id.codeflow8);
        codeflow9 = (ImageView) findViewById(R.id.codeflow9);
        codeflow10 = (ImageView) findViewById(R.id.codeflow10);
        codeflow11 = (ImageView) findViewById(R.id.codeflow11);
        codeflow12 = (ImageView) findViewById(R.id.codeflow12);

        codeflow1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), CodeActivity.class);
                startActivityForResult(intent, 100); //deprecated인데 사용은 가능하대ㅎㅎ

            }
        });

        codeflow5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), CodeActivity.class);
                intent.putExtra("block_button", false);
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

        if(requestCode == 100){
            if(resultCode==RESULT_OK){
                codeflow1.setImageResource(R.drawable.blue_shape_1_codemain_png);
                codeflow2.setImageResource(R.drawable.blue_shape_2_codemain_png);
                codeflow3.setImageResource(R.drawable.blue_shape_3_codemain_png);
                codeflow4.setImageResource(R.drawable.blue_shape_4_codemain_png);
                codeflow5.setImageResource(R.drawable.purple_shape_1_codemain_png);
                codeflow6.setImageResource(R.drawable.purple_shape_2_codemain_png);
                codeflow7.setImageResource(R.drawable.purple_shape_2_codemain_png);
                codeflow8.setImageResource(R.drawable.purple_shape_3_codemain_png);
                codeflow9.setImageResource(R.drawable.green_shape_1_codemain_png);
                codeflow10.setImageResource(R.drawable.green_shape_2_codemain_png);
                codeflow11.setImageResource(R.drawable.green_shape_3_codemain_png);
                codeflow12.setImageResource(R.drawable.green_shape_4_codemain_png);
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