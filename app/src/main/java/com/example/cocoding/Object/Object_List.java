package com.example.cocoding.Object;

import android.Manifest;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import com.example.cocoding.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

// 폴더 속에 들어가면 정리된 리스트
public class Object_List extends AppCompatActivity {

    FirebaseFirestore db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.object_list);
//
//        db=FirebaseFirestore.getInstance();
//
//        DocumentReference docRef = db.collection("cocodingObject").document("ObjectActivity");
//
//
//        docRef.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
//            private static final String TAG = "";
//
//            @RequiresApi(api = Build.VERSION_CODES.M)
//            @Override
//            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
//
//                if (task.isSuccessful()) {
//                    DocumentSnapshot document = task.getResult();
//                    if (document.exists()) {
//
//                        ImageView iv = (ImageView) findViewById(R.id.image11);
//
//
//                        if (checkSelfPermission(Manifest.permission.READ_EXTERNAL_STORAGE)
//                                != PackageManager.PERMISSION_GRANTED) {
//
//                            // Should we show an explanation?
//                            if (shouldShowRequestPermissionRationale(
//                                    Manifest.permission.READ_EXTERNAL_STORAGE)) {
//                                // Explain to the user why we need to read the contacts
//
//                            }
//
//                            requestPermissions(new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},0);
//
//
//                            // MY_PERMISSIONS_REQUEST_READ_EXTERNAL_STORAGE is an
//                            // app-defined int constant that should be quite unique
//
//                            return;
//                        }
//                        DatabaseReference mRootRef = FirebaseDatabase.getInstance().getReference();
//                        DatabaseReference conditionRef = mRootRef.child("object").child("folder1").child("object1").child("object_uri");
//                        conditionRef.addValueEventListener(new ValueEventListener() {
//                            @Override
//                            public void onDataChange(DataSnapshot dataSnapshot) {
//                                String idea_topic_text = dataSnapshot.getValue(String.class);
//                                Uri u = Uri.parse(idea_topic_text.toString());
//                                iv.setImageURI(u);
//
//                                Log.d(TAG, "DocumentSnapshot data: " + u.toString());
//                            }
//
//                            @Override
//                            public void onCancelled(DatabaseError databaseError) {
//
//                            }
//                        });
//
//
//
//                    } else {
//                        Log.d(TAG, "No such document");
//                    }
//                } else {
//                    Log.d(TAG, "get failed with ", task.getException());
//                }
//            }
//        });


    }

}
