package com.example.cocoding.Code;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.VideoView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.cocoding.BaseActivity;
import com.example.cocoding.R;

import java.util.ArrayList;
import java.util.Random;
import java.util.Stack;

public class ExecutionActivity extends AppCompatActivity {

    ImageView background;
    ImageView right_hp_bar, left_hp_bar;
    ImageView left_hp1, left_hp2, left_hp3, left_hp4;
    ImageView right_hp1, right_hp2, right_hp3, right_hp4;

    ImageView left_beaver, right_beaver;

    ImageView left_snowball, right_snowball;

    ImageView vs, win;

    Random random = new Random();

    int left_speed, right_speed;
    int left_hp_count, right_hp_count;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_code_execution);


        background = (ImageView) findViewById(R.id.execution_background);

        left_hp_bar = (ImageView) findViewById(R.id.execution_left_hp_bar);
        right_hp_bar = (ImageView) findViewById(R.id.execution_right_hp_bar);

        left_hp1 = (ImageView) findViewById(R.id.left_hp1);
        left_hp2 = (ImageView) findViewById(R.id.left_hp2);
        left_hp3 = (ImageView) findViewById(R.id.left_hp3);
        left_hp4 = (ImageView) findViewById(R.id.left_hp4);

        right_hp1 = (ImageView) findViewById(R.id.right_hp1);
        right_hp2 = (ImageView) findViewById(R.id.right_hp2);
        right_hp3 = (ImageView) findViewById(R.id.right_hp3);
        right_hp4 = (ImageView) findViewById(R.id.right_hp4);

        left_beaver = (ImageView) findViewById(R.id.execution_left_beaver);
        right_beaver = (ImageView) findViewById(R.id.execution_right_beaver);

        left_snowball = (ImageView) findViewById(R.id.left_snowball);
        right_snowball = (ImageView) findViewById(R.id.right_snowball);

        vs = (ImageView) findViewById(R.id.execution_vs);
        win = (ImageView) findViewById(R.id.execution_win);

        Stack<ImageView> left_hp = new Stack<ImageView>();
        left_hp.push(left_hp1);
        left_hp.push(left_hp2);
        left_hp.push(left_hp3);
        left_hp.push(left_hp4);
        Stack<ImageView> right_hp = new Stack<ImageView>();
        right_hp.push(right_hp1);
        right_hp.push(right_hp2);
        right_hp.push(right_hp3);
        right_hp.push(right_hp4);


        final AnimatorSet animSet = new AnimatorSet();
        ObjectAnimator left_snowball_move = ObjectAnimator.ofFloat(left_snowball, "translationX", 0, 500);
        ObjectAnimator right_snowball_move = ObjectAnimator.ofFloat(right_snowball, "translationX", 0, -500);
        ObjectAnimator right_snowball_hide = ObjectAnimator.ofFloat(right_snowball, "alpha", 0);
        ObjectAnimator left_snowball_hide = ObjectAnimator.ofFloat(left_snowball, "alpha", 0);

      //  left_speed = random.nextInt(1500 - 1000 + 1) + 1000;
      //  right_speed = random.nextInt(1500 - 1000 + 1) + 1000;

        left_speed = 1200;
        right_speed = 1000;

        left_snowball_move.setDuration(left_speed);
        right_snowball_move.setDuration(right_speed);

        animSet.playTogether(left_snowball_move, right_snowball_move);
        animSet.playSequentially(right_snowball_move, right_snowball_hide, left_snowball_hide);

        left_hp_count = 4;
        right_hp_count = 4;

        animSet.addListener(new AnimatorListenerAdapter() {
            int num = 7;

            @Override
            public void onAnimationEnd(Animator animation) {
                if (num > 0) {

                    left_snowball_move.setDuration(left_speed);
                    right_snowball_move.setDuration(right_speed);

                    left_snowball.setX(0);
                    right_snowball.setX(0);
                    if (left_speed > right_speed) {
                        if (!right_hp.empty()) {
                            right_hp.peek().setVisibility(View.INVISIBLE);
                            right_hp.pop();

                            left_hp_count -= 1;

                            if (left_hp_count == 0) {
                                right_beaver.setVisibility(View.INVISIBLE);
                                right_hp_bar.setVisibility(View.INVISIBLE);
                                left_hp_bar.setVisibility(View.INVISIBLE);
                                vs.setVisibility(View.INVISIBLE);
                                for (ImageView imageview : left_hp) {
                                    imageview.setVisibility(View.INVISIBLE);
                                }

                                ObjectAnimator left_beaver_win = ObjectAnimator.ofFloat(left_beaver, "translationX", 0, 400);
                                left_beaver_win.start();
                                win.setVisibility(View.VISIBLE);
                                return;
                            }
                        }
                    } else {
                        if (!left_hp.empty()) {
                            left_hp.peek().setVisibility(View.INVISIBLE);
                            left_hp.pop();

                            right_hp_count -= 1;
                            if (right_hp_count == 0) {
                                left_beaver.setVisibility(View.INVISIBLE);
                                right_hp_bar.setVisibility(View.INVISIBLE);
                                left_hp_bar.setVisibility(View.INVISIBLE);
                                vs.setVisibility(View.INVISIBLE);
                                for (ImageView imageview : right_hp) {
                                    imageview.setVisibility(View.INVISIBLE);
                                }
                               // right_beaver.setImageResource(R.drawable.execution_left_beaver_win);
                                ObjectAnimator right_beaver_win = ObjectAnimator.ofFloat(right_beaver, "translationX", 0, -400);
                                right_beaver_win.start();
                                win.setVisibility(View.VISIBLE);
                                return;

                            }
                        }
                    }
                    animation.start();
                    num--;
                }
            }
        });
        animSet.start();


    }


}
