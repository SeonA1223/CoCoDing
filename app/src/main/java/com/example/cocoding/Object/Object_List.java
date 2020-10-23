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

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
//import com.google.firebase.firestore.DocumentReference;
//import com.google.firebase.firestore.DocumentSnapshot;
//import com.google.firebase.firestore.FirebaseFirestore;
import com.example.cocoding.R;

// 폴더 속에 들어가면 정리된 리스트
public class Object_List extends AppCompatActivity {

//    FirebaseFirestore db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.object_list);
//        db=FirebaseFirestore.getInstance();
//        DocumentReference docRef = db.collection("Object_test").document("Object");
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
//                        ImageView iv = (ImageView) findViewById(R.id.image);
//                        Uri u = Uri.parse(document.getData().toString().substring(8,document.getData().toString().length()-1));
//                        if (checkSelfPermission(Manifest.permission.READ_EXTERNAL_STORAGE)
//                                != PackageManager.PERMISSION_GRANTED) {
//
//                            // Should we show an explanation?
//                            if (shouldShowRequestPermissionRationale(
//                                    Manifest.permission.READ_EXTERNAL_STORAGE)) {
//                                // Explain to the user why we need to read the contacts
//                            }
//
//                            requestPermissions(new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},0);
//
//                            // MY_PERMISSIONS_REQUEST_READ_EXTERNAL_STORAGE is an
//                            // app-defined int constant that should be quite unique
//
//                            return;
//                        }
//                        iv.setImageURI(u);
//                        Log.d(TAG, "DocumentSnapshot data: " + document.getData());
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
