package com.example.cocoding.Idea;

import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.example.cocoding.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Idea_Topic_Content extends AppCompatActivity {

    private Button button9;
    private EditText edit_idea_topic_content;

    DatabaseReference mRootRef = FirebaseDatabase.getInstance().getReference();
    DatabaseReference conditionRef = mRootRef.child("idea_topic_content");


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_idea_topic_content);
        button9 = (Button) findViewById(R.id.button9);
        edit_idea_topic_content = (EditText) findViewById(R.id.edit_idea_topic_content);
    }

    @Override
    protected void onStart() {
        super.onStart();

        conditionRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String idea_topic_content_text = dataSnapshot.getValue(String.class);
                edit_idea_topic_content.setText(idea_topic_content_text);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        button9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                conditionRef.setValue(edit_idea_topic_content.getText().toString());
            }
        });}

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.back, menu);
        return true;
    }

}
