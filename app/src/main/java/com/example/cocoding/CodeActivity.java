package com.example.cocoding;

import android.annotation.SuppressLint;
import android.content.ClipData;
import android.content.ClipDescription;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Point;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;

import android.provider.ContactsContract;
import android.util.Log;
import android.view.Display;
import android.view.DragAndDropPermissions;
import android.view.DragEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentTransaction;

import com.example.cocoding.Code.Block.BlockItem;
import com.example.cocoding.Code.Block.Execution;
import com.example.cocoding.Code.CodeBlockPage;
import com.example.cocoding.Code.CodeRecyclerviewToPage;
import com.example.cocoding.Code.ExecutionEachActivity;


import java.util.ArrayList;
import java.util.LinkedList;

@RequiresApi(api = Build.VERSION_CODES.N)
public class CodeActivity extends AppCompatActivity implements CodeRecyclerviewToPage {

    ImageView code_shape; //버튼 클릭시 CodeBlockPage fragment 뜸
    //LinearLayout linearLayout;
    ConstraintLayout constraintLayout, parent_constrainLayout;
    CodeBlockPage codeBlockPage;

    ScrollView scrollView;
    float fromX, fromY;
    ImageView selected_Image, execution;
    ConstraintLayout selected_constraintLayout;
    String tag;
    int id = 0;
    int count = 0;

    ArrayList<BlockItem> BlockDB, ObjectDB, AllDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_code);

        code_shape = (ImageView) findViewById(R.id.code_block);
        constraintLayout = (ConstraintLayout) findViewById(R.id.code_container);
        parent_constrainLayout = (ConstraintLayout) findViewById(R.id.code_main_container);
        execution = (ImageView) findViewById(R.id.execution_each);
        constraintLayout.setOnDragListener(mDragListener);
        Intent intent = getIntent();
        boolean check = intent.getBooleanExtra("block_button", true);


        Toolbar mmToolbar = (Toolbar) findViewById(R.id.code_toolbar);
        setSupportActionBar(mmToolbar);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.drawable_back_image_customise);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("");

       BlockDB = new ArrayList<>();
       ObjectDB = new ArrayList<>();
       AllDB = new ArrayList<>();

        execution.setOnClickListener(new Button.OnClickListener(){

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), ExecutionEachActivity.class);
                if(count > 4) count = 4;
                if(!AllDB.isEmpty()) {
                    intent.putExtra("count", count);
                    startActivity(intent);
                    Log.d("count", ": " + count);
                    count++;
                }
            }
        });

        codeBlockPage = new CodeBlockPage();
        code_shape.setOnClickListener(new Button.OnClickListener() {

            @Override
            public void onClick(View v) {
                codeBlockPage.show(getSupportFragmentManager(), "check");

            }
        });
    }

    @SuppressLint("ClickableViewAccessibility")
    @Override
    public void getBlockImage(BlockItem blockItem) {
        if (blockItem.getID().equals("Set")) {
            int layout = blockItem.getLayout();
            LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            inflater.inflate(layout, constraintLayout, true);

            ConstraintLayout blockLayout = (ConstraintLayout) constraintLayout.findViewById(R.id.setXY);
            blockLayout.setTag(blockItem.getID() + id);
            id++;

            blockLayout.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    int action = motionEvent.getAction();
                    Log.d("check", "same?");
                    switch (action) {
                        case MotionEvent.ACTION_DOWN:
                            if (view != null) {
                                tag = view.getTag().toString();
                                ClipData.Item item = new ClipData.Item(tag);
                                ClipData dragData = new ClipData(tag, new String[]{ClipDescription.MIMETYPE_TEXT_PLAIN}, item);
//                                fromX = motionEvent.getX();
//                                fromY = motionEvent.getY();
                                View.DragShadowBuilder builder = new View.DragShadowBuilder(view);
                                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                                    view.startDragAndDrop(dragData, builder, null, 0);
                                } else {
                                    view.startDrag(dragData, builder, null, 0);
                                }
                            }

                            break;
                    }
                    return view.performClick();

                }
            });

            blockItem.setConstraintLayout(blockLayout);
            AllDB.add(blockItem);
            //여기 imageview가 없음,,, 여기는 온리 코드부분만 가져와야할듯???
        } else {
            ImageView imageView = new ImageView(this);
            imageView.setImageResource(blockItem.getBlockImage());
            imageView.setTag(blockItem.getID() + id);
            id++;
            imageView.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    int action = motionEvent.getAction();
                    switch (action) {
                        case MotionEvent.ACTION_DOWN:
                            if (view != null) {
                                tag = view.getTag().toString();
                                ClipData.Item item = new ClipData.Item(tag);
                                ClipData dragData = new ClipData(tag, new String[]{ClipDescription.MIMETYPE_TEXT_PLAIN}, item);
                                View.DragShadowBuilder builder = new View.DragShadowBuilder(view);
                                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                                    view.startDragAndDrop(dragData, builder, null, 0);
                                } else {
                                    view.startDrag(dragData, builder, null, 0);
                                }
                            }

                            break;
                    }
                    return view.performClick();

                }
            });

            constraintLayout.addView(imageView);
            blockItem.setImage(imageView);
            if(blockItem.getType().equals("Object")){
                ObjectDB.add(blockItem);
                AllDB.add(blockItem);
            }else {
                BlockDB.add(blockItem); //여기 imageview가 없음,,, 여기는 온리 코드부분만 가져와야할듯???
                AllDB.add(blockItem);
            }
        }
    }

    View.OnDragListener mDragListener = (view, dragEvent) -> {
        int id = view.getId();
        Log.d("tag", tag);
        int action = dragEvent.getAction();
        for (BlockItem Tag : AllDB) {
            if (Tag.getImage() != null) {
                if (Tag.getImage().getTag() == tag) {
                    selected_Image = Tag.getImage();
                    Log.d("test1", "[" + Tag + "]");
                    Log.d("test2", "[" + Tag.getCode() + "]");
                }
            } else {
                if (Tag.getConstraintLayout().getTag() == tag)
                    selected_constraintLayout = Tag.getConstraintLayout();
            }
        }

        if (action == DragEvent.ACTION_DROP) {
            if (id == R.id.code_container) {
                if (selected_Image != null) {
                    float x = dragEvent.getX() - ((float) selected_Image.getWidth() / 2);
                    float y = dragEvent.getY() - ((float) selected_Image.getHeight() / 2);
                    Log.d("value check", "" + x + "and " + y);
                    selected_Image.setX(x);
                    selected_Image.setY(y);
                    selected_Image = null;
                } else if  (selected_constraintLayout != null){
                    float a = dragEvent.getX() - ((float) selected_constraintLayout.getWidth() / 2);
                    float b = dragEvent.getY() - ((float) selected_constraintLayout.getHeight() / 2);
                    selected_constraintLayout.setX(a);
                    selected_constraintLayout.setY(b);
                    Log.d("constraint check", "" + a + "and " + b);
                    selected_constraintLayout = null;
                }
            }
        }

        return true;
    };
}
//        if(BlockDB != null) {
//            Log.d("이미지 들어가는지 확인", "1");
//            for(ImageView imageView: BlockDB){
//                Log.d("이미지 들어가는지 확인", "2");
//                imageView.setOnTouchListener(new View.OnTouchListener() {
//                    @Override
//                    public boolean onTouch(View view, MotionEvent event) {
////                        ClipData.Item item = new ClipData.Item((Intent) view.getTag());
////                        ClipData dragData = new ClipData((CharSequence) view.getTag(), new String[] { ClipDescription.MIMETYPE_TEXT_PLAIN}, item);
////                        view.startDragAndDrop(dragData, null, null, 0);
//                        switch (event.getAction()) {
//                            case MotionEvent.ACTION_DOWN:
//                                ClipData clipData = ClipData.newPlainText("", "");
//                                view.startDrag(clipData, new ImageDrag(view, (int) event.getX(), (int) event.getY()), view, 0);
//                                return true;
//                        }
//                        return false;
//                        }
//                });
//            }
//        }




