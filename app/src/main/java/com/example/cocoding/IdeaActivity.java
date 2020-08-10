package com.example.cocoding;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.example.cocoding.Idea.Idea_Algorithm;
import com.example.cocoding.Idea.Idea_Topic;
import com.example.cocoding.Idea.Idea_Topic_Content;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class IdeaActivity extends BaseActivity {

//    DatabaseReference mRootRef = FirebaseDatabase.getInstance().getReference();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.e("come?", "[" + savedInstanceState + "]");

        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.idea_topic);
        LinearLayout linearLayout1 = (LinearLayout) findViewById(R.id.idea_topic_contents);
        LinearLayout linearLayout2 = (LinearLayout) findViewById(R.id.idea_algorithm);

//        TextView idea_topic_textview = (TextView) findViewById(R.id.idea_topic_textview);
//
//        mRootRef.addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
//                String idea_topic_text = dataSnapshot.getValue(String.class);
//                idea_topic_textview.setText(idea_topic_text);
//            }
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError error) {
//
//            }
//        });

        linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Idea_Topic.class);
                startActivity(intent);
            }
        });


        linearLayout1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Idea_Topic_Content.class);
                startActivity(intent);
            }
        });


        linearLayout2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Idea_Algorithm.class);
                startActivity(intent);
            }
        });

    }


    @Override
    int getNavigationMenuItemId() {
        return R.id.navigation_idea;
    }

    @Override
    int getContentViewId() {
        return R.layout.activity_idea;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.back, menu);
        return true;
    }



}