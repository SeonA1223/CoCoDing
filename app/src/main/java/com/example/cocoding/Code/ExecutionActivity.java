package com.example.cocoding.Code;

import android.net.Uri;
import android.os.Bundle;
import android.widget.VideoView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.cocoding.BaseActivity;
import com.example.cocoding.R;

public class ExecutionActivity extends AppCompatActivity {

    VideoView videoView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_code_execution);

        videoView = (VideoView) findViewById(R.id.video_execution);
        Uri video = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.execution);
        //일단 화질은 엄청 깨지지만 영상 대충 찍어서 넣어봤는데 다시 수정해야함

        videoView.setVideoURI(video);
        videoView.requestFocus();
        videoView.start();
    }
}
