package com.example.cocoding.Idea;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.example.cocoding.IdeaActivity;
import com.example.cocoding.R;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.w3c.dom.Text;

public class Idea_Topic extends AppCompatActivity {

    private ImageButton button7;
    public EditText edit_topic;
//    SharedPreferences pref;
//    SharedPreferences.Editor editor;
//
//    FirebaseDatabase database;
//    DatabaseReference myRef;

//    private FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
//    private DatabaseReference databaseReference = firebaseDatabase.getReference();
//    private DatabaseReference conditionRef = mRootRef.child("text");


    DatabaseReference mRootRef = FirebaseDatabase.getInstance().getReference();
    DatabaseReference conditionRef = mRootRef.child("idea").child("idea_topic");

//    public void saveData(){
//        Text txt = new Text(edit_topic.getText().toString());
//        myRef.child(특정분류+"idea_topic").setValue(txt);
//    }
//
//    public void saveData(String key, String text) {
//        editor.putString(key,text);
//        editor.commit();
//    }
//
//    public String getData(String key) {
//        String result = pref.getString(key, "");
//        return result;
//    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_idea_topic);

        Toolbar mmToolbar = (Toolbar) findViewById(R.id.idea_topic_toolbar);
        setSupportActionBar(mmToolbar);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.drawable_back_image_customise);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("");




        button7 = (ImageButton) findViewById(R.id.button7);
        edit_topic = (EditText) findViewById(R.id.edit_topic);
//        pref = getSharedPreferences("sample", MODE_PRIVATE);
//        editor = pref.edit();
    }

    @Override
    protected void onStart() {
        super.onStart();

        conditionRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String idea_topic_text = dataSnapshot.getValue(String.class);
                edit_topic.setText(idea_topic_text);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                if (view == button7) {
//                    saveData();
//                } else {
//                    Toast.makeText(getApplicationContext(),"Done을 누르세요.",Toast.LENGTH_LONG).show();
//                }
//                databaseReference.child("message").push().setValue(edit_topic);
            conditionRef.setValue(edit_topic.getText().toString());
            }
        });}

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

//        button7.setOnClickListener(cl);
//
//        database = FirebaseDatabase.getInstance();
//        myRef = database.getReference();
//
//        myRef.child(특정분류).addChildEventListener(new ChildEventListener() {
//            @Override
//            public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
//                if(dataSnapshot.getKey().equals("idea_topic")){
//                    Text text = dataSnapshot.getValue(Text.class);
//                    edit_topic.setText(text.edit_topic);
//                }
//            }
//
//            @Override
//            public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
//
//            }
//
//            @Override
//            public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) {
//
//            }
//
//            @Override
//            public void onChildMoved(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
//
//            }
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError databaseError) {
//
//            }
//        });
//
//    }
//
//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//
//        getMenuInflater().inflate(R.menu.back, menu);
//        return true;
//    }
//
//}
//
//class Text{
//    public String edit_topic;
//    public Text(){
//
//    }
//
//    public Text(String edit_topic){
//        this.edit_topic = edit_topic;
//    }
//}
