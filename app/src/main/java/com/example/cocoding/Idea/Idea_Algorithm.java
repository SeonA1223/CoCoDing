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

public class Idea_Algorithm extends AppCompatActivity {

    private Button button8;
    private EditText edit_idea_algorithm;

    DatabaseReference mRootRef = FirebaseDatabase.getInstance().getReference();
    DatabaseReference conditionRef = mRootRef.child("idea_algorithm");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_idea_algorithm);
        button8 = (Button) findViewById(R.id.button8);
        edit_idea_algorithm = (EditText) findViewById(R.id.edit_idea_algorithm);
    }

    @Override
    protected void onStart() {
        super.onStart();

        conditionRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String idea_algorithm_text = dataSnapshot.getValue(String.class);
                edit_idea_algorithm.setText(idea_algorithm_text);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                conditionRef.setValue(edit_idea_algorithm.getText().toString());
            }
        });}

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.back, menu);
        return true;
    }

}
