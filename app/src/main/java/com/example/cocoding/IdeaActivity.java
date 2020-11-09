package com.example.cocoding;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.cocoding.Idea.Idea_Algorithm;
import com.example.cocoding.Idea.Idea_Topic;
import com.example.cocoding.Idea.Idea_Topic_Content;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FileDownloadTask;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.OnProgressListener;
import com.google.firebase.storage.UploadTask;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import androidx.appcompat.widget.Toolbar;
import androidx.core.app.NavUtils;
import androidx.fragment.app.DialogFragment;

import static android.content.ContentValues.TAG;

public class IdeaActivity extends BaseActivity {

    TextView idea_topic_textview;
    TextView idea_topic_contents_textview;
    TextView idea_algorithm_textview;

    int num = 2;

    DatabaseReference mRootRef = FirebaseDatabase.getInstance().getReference();
    DatabaseReference conditionRef = mRootRef.child("idea").child("idea_topic");
    DatabaseReference conditionRef1 = mRootRef.child("idea").child("idea_topic_content");
    DatabaseReference conditionRef2 = mRootRef.child("idea").child("idea_algorithm");


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Toolbar mToolbar = (Toolbar) findViewById(R.id.idea_toolbar);
        setSupportActionBar(mToolbar);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.drawable_back_image_customise);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("");

        Log.e("come?", "[" + savedInstanceState + "]");


        // ImageView man = (ImageView)findViewById(R.id.man);
        ImageView mate_add = (ImageView) findViewById(R.id.mate_add);

        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.idea_topic);
        LinearLayout linearLayout1 = (LinearLayout) findViewById(R.id.idea_topic_contents);
        LinearLayout linearLayout2 = (LinearLayout) findViewById(R.id.idea_algorithm);

        idea_topic_textview = (TextView) findViewById(R.id.idea_topic_textview);
        idea_topic_contents_textview = (TextView) findViewById(R.id.idea_topic_contents_textview);
        idea_algorithm_textview = (TextView) findViewById(R.id.idea_algorithm_textview);

        mate_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                show();

            }
        });


        conditionRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String idea_topic_text = dataSnapshot.getValue(String.class);
                idea_topic_textview.setText(idea_topic_text);
            }

            @Override
            public void onCancelled(DatabaseError error) {
            }
        });

        conditionRef1.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String idea_topic_contents_text = dataSnapshot.getValue(String.class);
                idea_topic_contents_textview.setText(idea_topic_contents_text);
            }

            @Override
            public void onCancelled(DatabaseError error) {
            }
        });

        conditionRef2.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String idea_algorithm_text = dataSnapshot.getValue(String.class);
                idea_algorithm_textview.setText(idea_algorithm_text);
            }

            @Override
            public void onCancelled(DatabaseError error) {
            }
        });


        ChildEventListener childEventListener = new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String previousChildName) {
                Log.d(TAG, "onChildAdded:" + dataSnapshot.getKey());

            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String previousChildName) {
                Log.d(TAG, "onChildChanged:" + dataSnapshot.getKey());
            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {
                Log.d(TAG, "onChildRemoved:" + dataSnapshot.getKey());

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String previousChildName) {
                Log.d(TAG, "onChildMoved:" + dataSnapshot.getKey());

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Log.w(TAG, "postComments:onCancelled", databaseError.toException());

            }
        };

        conditionRef.addChildEventListener(childEventListener);

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
//                final EditText editText = new EditText(this);
//
//                AlertDialog.Builder dlg = new AlertDialog.Builder(this);
//                Intent intent = new Intent(getApplicationContext(), Idea_Algorithm.class);
//                startActivity(intent);
                show();
            }
        });


    }

    void show() {
        Log.d("값 체크", ""+ num);

        ImageView image2 = (ImageView) findViewById(R.id.gray);
        ImageView image3 = (ImageView) findViewById(R.id.gray2);


        final EditText edittext = new EditText(this);

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Teammate Invitation");
        builder.setMessage("Input teammate's email");
        builder.setView(edittext);
        builder.setPositiveButton("SEND",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        String a = edittext.getText().toString();
                        Toast.makeText(getApplicationContext(), "Invite " + a, Toast.LENGTH_LONG).show();

                        if (a.equals("seona@naver.com")) {
                            image2.setImageResource(R.drawable.teamatetwo_ideamain_icon);
                        }else if(a.equals("inyeong@naver.com")){
                            image2.setImageResource(R.drawable.teamatetwo_ideamain_icon);
                            image3.setImageResource(R.drawable.teamatethree_ideamain_icon);
                        }

                    }
                });
        builder.setNegativeButton("CANCEL",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
        builder.show();
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
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home: { //toolbar의 back키 눌렀을 때 동작
                // finish();
                NavUtils.navigateUpFromSameTask(this);
                return true;
            }
        }
        return super.onOptionsItemSelected(item);
    }


}