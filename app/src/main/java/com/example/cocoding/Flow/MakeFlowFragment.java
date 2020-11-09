package com.example.cocoding.Flow;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

//import androidx.fragment.app.FragmentResultListener;
import androidx.fragment.app.FragmentResultListener;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import android.text.InputType;
import android.util.Log;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.HorizontalScrollView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.cocoding.R;
import com.example.cocoding.RecyclerviewItem;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;


import org.w3c.dom.Text;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static android.content.ContentValues.TAG;
import static android.content.Context.LAYOUT_INFLATER_SERVICE;
import static android.content.Context.MODE_PRIVATE;


public class MakeFlowFragment extends Fragment {
    //흐름도 만들기 페이지
    ImageButton flow_shape;
    LinearLayout linearLayout;
    FlowItemData flowItemData;
    FlowItemRecyclerview flowItemRecyclerview;
    ArrayList<EditText> image;

    ArrayAdapter<String> arrayAdapter;

    static ArrayList<String> arrayIndex = new ArrayList<String>();
    static ArrayList<String> arrayData = new ArrayList<String>();

    boolean check_flow_part = false;
    boolean check_flow_shape = false;

    EditText imageview;
    ImageButton flow_part;
    String flow_text;

    ImageView flow_start_imageview;
    ImageView flow_command_imageview1;
    ImageView flow_command_imageview2;
    ImageView flow_condition_imageview;

    ImageView last1, last2, last3;

    EditText flow_start_edittext;
    EditText flow_condition_edittext;
    EditText flow_command_edittext;

    DatabaseReference mRootRef = FirebaseDatabase.getInstance().getReference(); //
    //  DatabaseReference conditionRef = mRootRef.child("flow").child("flow_data");
    //  DatabaseReference conditionRef2 = mRootRef.child("flow").child("flow_data").child("flow_order");//
    //   DatabaseReference conditionRef3 = mRootRef.child("flow").child("flow_data").child("flow_number");
    //   DatabaseReference conditionRef = mRootRef.child("flow").child("flow_data");


    int imageNumber;


    public MakeFlowFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

    }


    @SuppressLint("ClickableViewAccessibility")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_flow_make_flow, container, false);

        flow_shape = (ImageButton) view.findViewById(R.id.flow_shape);
        flow_part = (ImageButton) view.findViewById(R.id.flow_part);
        linearLayout = (LinearLayout) view.findViewById(R.id.second_fragment_flow_make_flow);

        flowItemRecyclerview = new FlowItemRecyclerview();

        flowItemData = new FlowItemData();


        arrayAdapter = new ArrayAdapter<String>(this.getContext(), R.layout.fragment_flow_make_flow);
//        EditText listView = (ListView) findViewById(R.id.db_list_view);
//        listView.setAdapter(arrayAdapter);

//
//        pref = getSharedPreferences("sample", MODE_PRIVATE);
//        editor = pref.edit();


        flow_shape.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                flowItemRecyclerview.show(getChildFragmentManager(), "please");

            }

        });

        flow_part.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                if (!check_flow_part) {
                    flow_part.setImageResource(R.drawable.mypart_flowmain_button_pressed);
                    check_flow_part = !check_flow_part;
                } else {
                    flow_part.setImageResource(R.drawable.mypart_flowmain_button);
                    check_flow_part = !check_flow_part;
                }
            }
        });

        if (flowItemRecyclerview != null) {
            getChildFragmentManager().setFragmentResultListener("requestKey", this, new FragmentResultListener() {
                @Override
                public void onFragmentResult(@NonNull String requestKey, @NonNull Bundle result) {
                    imageNumber = result.getInt("itemPosition");
                    Log.e("Fragment data send", "[" + imageNumber + "]");
                    image = new ArrayList<EditText>();
                    makeTextView(getContext(), imageNumber);
                    getData();
                }
            });
        }


        return view;

    }

    private View.OnClickListener StartClick = new View.OnClickListener() {

        @Override
        public void onClick(View v) {
            if (check_flow_part) {
                flow_start_edittext.setText("");
                flow_start_edittext.setVisibility(View.INVISIBLE);
                flow_start_imageview.setImageResource(R.drawable.start_flow_color);
            }
        }
    };

    private View.OnClickListener ConditionClick = new View.OnClickListener() {

        @Override
        public void onClick(View v) {
            if (check_flow_part) {
                flow_condition_edittext.setVisibility(View.INVISIBLE);
                flow_condition_imageview.setImageResource(R.drawable.color_three_yesno);
                last1.setImageResource(R.drawable.color_four_attack);
                last2.setImageResource(R.drawable.color_five_die);
                last3.setImageResource(R.drawable.color_six_green);
            }
        }
    };

    private View.OnClickListener Command1_Click = new View.OnClickListener() {

        @Override
        public void onClick(View v) {
            if (check_flow_part) {
                flow_command_edittext.setVisibility(View.INVISIBLE);
                flow_command_imageview1.setImageResource(R.drawable.color_two_initialize);


             //   HorizontalScrollView horizontalScrollView =  new HorizontalScrollView(v.getContext());
            //    linearLayout.addView(horizontalScrollView);
//                ImageView imageView2 = new ImageView(v.getContext());
//            imageView2.setImageResource(R.drawable.flow_color);
//            linearLayout.addView(imageView2);
        }


        }
    };



    public void makeTextView(Context context, int imageNumber) {
        if (context != null) {
            LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(LAYOUT_INFLATER_SERVICE);
            int index = View.generateViewId();
            int image_number = imageNumber;


            switch (image_number) {
                case 0:
                    layoutInflater.inflate(R.layout.flow_item_start, linearLayout, true);
                    flow_start_imageview = (ImageView) linearLayout.findViewById(R.id.flow_start_imageview);
                    flow_start_edittext = (EditText) linearLayout.findViewById(R.id.flow_start_edittext);
                    flow_start_imageview.setOnClickListener(StartClick);
                    break;
                case 1:
                    layoutInflater.inflate(R.layout.flow_item_command, linearLayout, true);
                    flow_command_imageview1 = (ImageView) linearLayout.findViewById(R.id.flow_command_imageview1);
                    flow_command_edittext = (EditText) linearLayout.findViewById(R.id.flow_command_edittext);
                    flow_command_imageview1.setOnClickListener(Command1_Click);
                    break;
                case 4:
                    layoutInflater.inflate(R.layout.flow_item_condition, linearLayout, true);
                    layoutInflater.inflate(R.layout.flow_item_last, linearLayout, true);
                    flow_condition_imageview = (ImageView) linearLayout.findViewById(R.id.flow_condition_imageview);
                    flow_condition_edittext = (EditText) linearLayout.findViewById(R.id.flow_condition_edittext);
                    last1 = (ImageView) linearLayout.findViewById(R.id.last1);
                    last2 = (ImageView) linearLayout.findViewById(R.id.last2);
                    last3 = (ImageView) linearLayout.findViewById(R.id.last3);
                    flow_condition_imageview.setOnClickListener(ConditionClick);
                    break;
            }


        }


//        LinearLayout.LayoutParams layoutParams = (LayoutParams) new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
//        layoutParams.gravity = Gravity.CENTER;
        //       layoutParams.setMargins(100, 20, 100, 20);
//        imageview.setLayoutParams(layoutParams);
//        linearLayout.addView(imageview);
//
// //       imageview.setOnKeyListener(new EditMessageOnKeyListener()); -> 하드웨어 키보드 이벤트..
//        Log.d("string값 체크", "[" + imageview.getText().toString() +"]");
//
//        imageview.setImeOptions(EditorInfo.IME_ACTION_DONE); //keyboard enter
//        imageview.setInputType(InputType.TYPE_CLASS_TEXT);//inpute type = text
//
//
//        imageview.setOnEditorActionListener(new TextView.OnEditorActionListener() { //When entered, keyboard enter change and store
//            @Override
//            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
//                switch (actionId){
//                    case EditorInfo.IME_ACTION_DONE:
//                        Toast.makeText(getContext(),"완료", Toast.LENGTH_LONG).show();
////                        conditionRef4.push().setValue(imageview.getText().toString());
//                        flow_text = imageview.getText().toString();
//                        Flow flow = new Flow(index, image_number, flow_text);
//                        Map<String, Object> childUpdates = new HashMap<>();
//                        Map<String, Object> flowItem = null;
//                        flowItem = flow.toMap();
//                        Log.d("flow_store_right?", "{" + flowItem + "}" );
//                        childUpdates.put("/flow_data/" + index, flow);
//                        mRootRef.updateChildren(childUpdates);
//                        break;
//                    default:
//                        Toast.makeText(getContext(),"기본", Toast.LENGTH_LONG).show();
//                        return false;
//                }
//                return true;
//            }
//        });

        //when value change, this works
        mRootRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
//                String text = snapshot.getValue(String.class);
//                imageview.setText(text);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        //   return imageview;
    }

    public void getData() {
        ValueEventListener getListener = new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                Log.e("getFirebaseDatabase", "key: " + snapshot.getChildrenCount());
                arrayData.clear();
                arrayIndex.clear();
                for (DataSnapshot flowSnapshot : snapshot.getChildren()) {
                    String key = flowSnapshot.getKey();
                    Flow get = flowSnapshot.getValue(Flow.class);
                    //    String[] info = {String.valueOf(get.id), String.valueOf(get.number), get.text};
                    //    String Result = setTextLength(info[0],10) + setTextLength(info[1],10) + setTextLength(info[2],10) + setTextLength(info[3],10);
                    //    arrayData.add(Result);
                    arrayIndex.add(key); // ===> [12, 22, 32] 으로 최종 출력되는데 왜인지,,,흠
                    Log.d("getFirebaseDatabase", "key: " + key);
                    //    Log.d("getFirebaseDatabase", "info: " + info[0] + info[1] + info[2] + info[3]);
                }
                arrayAdapter.clear();
                arrayAdapter.addAll(arrayData);
                arrayAdapter.notifyDataSetChanged();
                Log.d("getFirebaseDatabasedfdf", "key: " + arrayAdapter); // android.widget.ArrayAdapter@d218e45 라고 저장됨
                Log.d("getFirseDadc", "key: " + arrayIndex); // [1,2,3] -> 인덱스 저장됨
                Log.d("getFirebaseDase", "key: " + arrayData); // 아무것도 저장안됨
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Log.w("getFirebaseDatabase", "loadPost:onCancelled", error.toException());
            }
        };
        Query getData = FirebaseDatabase.getInstance().getReference().child("flow_data");
        getData.addListenerForSingleValueEvent(getListener);

    }

    public String setTextLength(String text, int length) {
        if (text.length() < length) {
            int gap = length - text.length();
            for (int i = 0; i < gap; i++) {
                text = text + " ";
            }
        }
        return text;
    }


//    class EditMessageOnKeyListener implements View.OnKeyListener {
//        @Override
//        public boolean onKey(View v, int KeyCode, KeyEvent event){
//            if(event.getAction()== KeyEvent.ACTION_DOWN) {
//                Log.d("click", "{" + 877);
////                    Log.d(MY_TAG, "KeyEvent.ACTION_DOWN");
//
//            }else if(event.getAction()==KeyEvent.ACTION_UP){
//                Log.d("click", "{" + 899);
////                        Log.d(MY_TAG, "KeyEvent.ACTION_UP");
//            }if (KeyCode == KeyEvent.KEYCODE_ENTER){
//                Log.d("click", "{" + 888);
////                ChildEventListener childEventListener = new ChildEventListener() {
////                    @Override
////                    public void onChildAdded(DataSnapshot dataSnapshot, String previousChildName) {
////                        Log.d(TAG, "onChildAdded:" + dataSnapshot.getKey());
////
////                    }
////
////                    @Override
////                    public void onChildChanged(DataSnapshot dataSnapshot, String previousChildName) {
////                        Log.d(TAG, "onChildChanged:" + dataSnapshot.getKey());
////                    }
////
////                    @Override
////                    public void onChildRemoved(DataSnapshot dataSnapshot) {
////                        Log.d(TAG, "onChildRemoved:" + dataSnapshot.getKey());
////
////                    }
////
////                    @Override
////                    public void onChildMoved(DataSnapshot dataSnapshot, String previousChildName) {
////                        Log.d(TAG, "onChildMoved:" + dataSnapshot.getKey());
////
////                    }
////
////                    @Override
////                    public void onCancelled(DatabaseError databaseError) {
////                        Log.w(TAG, "postComments:onCancelled", databaseError.toException());
////
////                    }
////                };
//                Log.d("string값 체크", "[" + imageview.getText().toString() +"]");
//                conditionRef4.push().setValue(imageview.getText().toString());
//
////                conditionRef4.addChildEventListener(childEventListener);
//
//
////                            Log.d(MY_TAG, "KeyEvent.KEYCODE_ENTER");
//                return true;
//            }return false;
//        }
//    }

}




