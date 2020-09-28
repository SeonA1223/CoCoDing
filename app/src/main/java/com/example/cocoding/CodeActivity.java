package com.example.cocoding;

import android.annotation.SuppressLint;
import android.content.ClipData;
import android.content.ClipDescription;
import android.os.Build;
import android.os.Bundle;

import android.util.Log;
import android.view.DragEvent;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;


import com.example.cocoding.Code.Block.BlockItem;
import com.example.cocoding.Code.CodeBlockPage;
import com.example.cocoding.Code.CodeRecyclerviewToPage;


import java.util.LinkedList;

public class CodeActivity extends BaseActivity implements CodeRecyclerviewToPage {

    Button code_shape; //버튼 클릭시 CodeBlockPage fragment 뜸
    LinearLayout linearLayout;
    CodeBlockPage codeBlockPage;
    LinkedList<BlockItem> BlockDB;
    float fromX, fromY;
    ImageView selected_Image;
    String tag;
    int id=0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        code_shape = (Button) findViewById(R.id.code_block);
        linearLayout = (LinearLayout) findViewById(R.id.code_container);
        linearLayout.setOnDragListener(mDragListener);


        BlockDB = new LinkedList<>();

        codeBlockPage = new CodeBlockPage();
        code_shape.setOnClickListener(new Button.OnClickListener() {

            @Override
            public void onClick(View v) {
                codeBlockPage.show(getSupportFragmentManager(), "check");

            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();


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
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.back, menu);
        return true;
    }


    @SuppressLint("ClickableViewAccessibility")
    @Override
    public void getBlockImage(BlockItem blockItem) {
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
                            ClipData dragData = new ClipData(tag, new String[] { ClipDescription.MIMETYPE_TEXT_PLAIN}, item);
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

        linearLayout.addView(imageView);

    }

    View.OnDragListener mDragListener = (view, dragEvent) -> {
        int id = view.getId();
        Log.d("tag", tag);
        int action = dragEvent.getAction();
        for(BlockItem Tag : BlockDB){
            if(Tag.getImage().getTag() == tag){
                selected_Image = Tag.getImage();
                Log.d("test1",  "[" + Tag + "]");
                Log.d("test2",  "[" + Tag.getCode() + "]");
            }
        }

        switch (action) {
            case DragEvent.ACTION_DROP:
                if (id == R.id.code_container) {
                    float x = dragEvent.getX() - ( (float) selected_Image.getWidth() / 2 );
                    float y = dragEvent.getY() - ( (float) selected_Image.getHeight() / 2);
                    selected_Image.setX(x);
                    selected_Image.setY(y);
                }
                break;
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




