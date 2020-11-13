package com.example.cocoding.Code;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.cocoding.Code.Block.BlockItem;
import com.example.cocoding.Code.Block.Execution;
import com.example.cocoding.R;

import java.util.ArrayList;
import java.util.LinkedList;

public class ExecutionEachActivity extends AppCompatActivity implements Execution {

    int count;
    LinearLayout linearLayout;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_code_execution2);

        count = getIntent().getIntExtra("count", 4);
        linearLayout = (LinearLayout) findViewById(R.id.execution_each_layout);

        ImageView imageView = new ImageView(this);
        imageView.setMaxWidth(300);
        imageView.setMaxHeight(300);
        imageView.setImageResource(R.drawable.execution_left_beaver_1);

        linearLayout.addView(imageView);

        if (count == 0) {
            imageView.setX(0);
            imageView.setY(0);
        } else if (count == 1) {
            imageView.setX(200);
            imageView.setY(200);
        } else if (count == 2) {
            imageView.setX(200);
            imageView.setY(200);
            ObjectAnimator translationY = ObjectAnimator.ofFloat(imageView, "translationY", 0, 700);
            translationY.setDuration(1000);
            ObjectAnimator translationX = ObjectAnimator.ofFloat(imageView, "translationX", 0, 300);
            translationX.setDuration(1000);
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.playTogether(translationX, translationY);
            animatorSet.start();
        } else if (count == 3) {
            imageView.setX(200);
            imageView.setY(200);
            AnimatorSet animatorSet = new AnimatorSet();
            ObjectAnimator translationY = ObjectAnimator.ofFloat(imageView, "translationY", 0, 700);
            translationY.setDuration(1000);
            ObjectAnimator translationX = ObjectAnimator.ofFloat(imageView, "translationX", 0, 300);
            translationX.setDuration(1000);
            animatorSet.playTogether(translationX, translationY);
            ObjectAnimator rotation = ObjectAnimator.ofFloat(imageView, "rotation", 180);
            rotation.setDuration(1000);
            animatorSet.playSequentially(translationY, rotation);
            animatorSet.start();
        } else {
            imageView.setX(200);
            imageView.setY(200);
            AnimatorSet animatorSet = new AnimatorSet();
            ObjectAnimator translationY = ObjectAnimator.ofFloat(imageView, "translationY", 0, 700);
            translationY.setDuration(1000);
            ObjectAnimator translationX = ObjectAnimator.ofFloat(imageView, "translationX", 0, 300);
            translationX.setDuration(1000);
            animatorSet.playTogether(translationX, translationY);
            ObjectAnimator rotation = ObjectAnimator.ofFloat(imageView, "rotation", 180);
            rotation.setDuration(1000);
            animatorSet.playSequentially(translationY, rotation);
            ObjectAnimator translation = ObjectAnimator.ofFloat(imageView, "alpha", 0);
            translation.setDuration(1000);
            animatorSet.playSequentially(rotation, translation);
            animatorSet.start();
        }


    }
}
