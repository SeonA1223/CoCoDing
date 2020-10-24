package com.example.cocoding.Object;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.NavUtils;

import com.example.cocoding.BaseActivity;
import com.example.cocoding.R;

// 폴더 속에 들어가면 정리된 리스트
public class Object_List extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.object_list);

        Toolbar mmToolbar = (Toolbar) findViewById(R.id.object_toolbar);
        setSupportActionBar(mmToolbar);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.drawable_back_image_customise);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("");

//        @Override
//        int getNavigationMenuItemId() {
//            return R.id.navigation_idea;
//        }
//
//        @Override
//        int getContentViewId() {
//            return R.layout.activity_idea;
//        }
//
//        @Override
//        public boolean onOptionsItemSelected(MenuItem item) {
//            switch (item.getItemId()){
//                case android.R.id.home:{ //toolbar의 back키 눌렀을 때 동작
//                    finish();
//                    return true;
//                }
//            }
//            return super.onOptionsItemSelected(item);
//        }




    }

}
