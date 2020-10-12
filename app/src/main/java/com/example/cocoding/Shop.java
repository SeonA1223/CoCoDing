package com.example.cocoding;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class Shop extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop);

        Toolbar mToolbar = (Toolbar) findViewById(R.id.idea_shop_toolbar);
        setSupportActionBar(mToolbar);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.drawable_back_image_customise);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("");


        ImageView image1 = (ImageView) findViewById(R.id.shop_img);
        ImageView image2 = (ImageView) findViewById(R.id.shop_img2);
        Button sbtn = (Button) findViewById(R.id.shop_btn);
        RelativeLayout review = (RelativeLayout) findViewById(R.id.review);

        review.bringChildToFront(sbtn);


        sbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                review.bringChildToFront(image1);
                review.bringChildToFront(sbtn);
            }
        });
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
