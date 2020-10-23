package com.example.cocoding;

import android.annotation.SuppressLint;
import android.content.ClipData;
import android.content.ClipDescription;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Point;
import android.os.Build;
import android.os.Bundle;

import android.provider.ContactsContract;
import android.util.Log;
import android.view.Display;
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

import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentTransaction;

import com.example.cocoding.Code.Block.BlockItem;
import com.example.cocoding.Code.CodeBlockPage;
import com.example.cocoding.Code.CodeRecyclerviewToPage;


import java.util.LinkedList;

public class CodeActivity extends BaseActivity implements CodeRecyclerviewToPage {

    ImageView code_shape; //버튼 클릭시 CodeBlockPage fragment 뜸
    LinearLayout linearLayout;
    CodeBlockPage codeBlockPage;
    LinkedList<BlockItem> BlockDB;

    ScrollView scrollView;
    float fromX, fromY;
    ImageView selected_Image;
    ConstraintLayout selected_constraintLayout;
    String tag;
    int id = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        code_shape = (ImageView) findViewById(R.id.code_block);
        linearLayout = (LinearLayout) findViewById(R.id.code_container);
        scrollView = (ScrollView) findViewById(R.id.vertical_view);

        Display display = getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getRealSize(size);
        int height = size.y;
        int width = size.x;

        linearLayout.setMinimumHeight(height);
        linearLayout.setMinimumWidth(width);
        linearLayout.setOnDragListener(mDragListener);


        Intent intent = getIntent();
        boolean check = intent.getBooleanExtra("block_button", true);

        Log.d("check", "[" + check);

        if (check == false) {
            code_shape.setVisibility(View.INVISIBLE);
        }

        Toolbar mmToolbar = (Toolbar) findViewById(R.id.code_toolbar);
        setSupportActionBar(mmToolbar);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.drawable_back_image_customise);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("");


        BlockDB = new LinkedList<>();

        codeBlockPage = new CodeBlockPage();

//        if(!BlockDB.isEmpty()){
//            horizontalScrollView = new HorizontalScrollView(this);
//            horizontalScrollView.setMinimumHeight(height);
//            scrollView.addView(horizontalScrollView);
//        }

        code_shape.setOnClickListener(new Button.OnClickListener() {

            @Override
            public void onClick(View v) {
//                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
//                transaction.add(R.id.content, codeBlockPage);
//                transaction.commit();
                codeBlockPage.show(getSupportFragmentManager(), "check");

            }
        });
    }

    @Override
    int getNavigationMenuItemId() {
        return R.id.navigation_code;
    }

    @Override
    int getContentViewId() {
        return R.layout.activity_code;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home: { //toolbar의 back키 눌렀을 때 동작
                setResult(RESULT_OK);
                finish();
                return true;
            }
        }
        return super.onOptionsItemSelected(item);
    }


    @SuppressLint("ClickableViewAccessibility")
    @Override
    public void getBlockImage(BlockItem blockItem) {

        if (blockItem.getID().equals("Set")) {
            LayoutInflater mInflater = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);

            mInflater.inflate(R.layout.setxy, linearLayout, true);

            ConstraintLayout constraintLayout = (ConstraintLayout) linearLayout.findViewById(R.id.setXY);
            //  imageView = (ImageView) linearLayout.findViewById(R.id.image_setxy);

            constraintLayout.setTag(blockItem.getID() + id);
            id++;

            constraintLayout.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    int action = motionEvent.getAction();
                    switch (action) {
                        case MotionEvent.ACTION_DOWN:
                            if (view != null) {
                                tag = view.getTag().toString();
                                ClipData.Item item = new ClipData.Item(tag);
                                ClipData dragData = new ClipData(tag, new String[]{ClipDescription.MIMETYPE_TEXT_PLAIN}, item);
                                fromX = motionEvent.getX();
                                fromY = motionEvent.getY();
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

            blockItem.setConstraintLayout(constraintLayout);
            BlockDB.add(blockItem); //여기 imageview가 없음,,, 여기는 온리 코드부분만 가져와야할듯???
        } else {
            ImageView imageView = new ImageView(this);
            imageView.setImageResource(blockItem.getBlockImage());

            linearLayout.addView(imageView);


            //   imageView.setBackgroundColor(Color.parseColor("#afe3ff"));

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
                                fromX = motionEvent.getX();
                                fromY = motionEvent.getY();
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

            blockItem.setImage(imageView);
            BlockDB.add(blockItem); //여기 imageview가 없음,,, 여기는 온리 코드부분만 가져와야할듯???

        }


    }

    View.OnDragListener mDragListener = (view, dragEvent) -> {
        int id = view.getId();
        Log.d("tag", tag);
        int action = dragEvent.getAction();
        for (BlockItem Tag : BlockDB) {
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
                    selected_Image.setX(x);
                    selected_Image.setY(y);
                } else {
                    float x = dragEvent.getX() - ((float) selected_constraintLayout.getWidth() / 2);
                    float y = dragEvent.getY() - ((float) selected_constraintLayout.getHeight() / 2);
                    selected_constraintLayout.setX(x);
                    selected_constraintLayout.setY(y);
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




