package com.example.cocoding;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       setContentView(R.layout.activity_main);

        Button btn = (Button) findViewById(R.id.btn);
        btn.setOnClickListener(
                new Button.OnClickListener() {
                    public void onClick(View v) {
                        //SubActivity로 가는 인텐트를 생성
                        Intent intent = new Intent(v.getContext(), IdeaActivity.class);
                        //액티비티 시작!
                        startActivity(intent);
                    }
                }
        );
    }


}