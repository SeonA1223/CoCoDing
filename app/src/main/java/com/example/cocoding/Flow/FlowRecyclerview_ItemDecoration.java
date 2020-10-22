package com.example.cocoding.Flow;

import android.content.Context;
import android.graphics.Rect;
import android.util.TypedValue;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class FlowRecyclerview_ItemDecoration extends RecyclerView.ItemDecoration {

    private int size30;
    private int size40;
    private int size15;
    private int size20;

    public FlowRecyclerview_ItemDecoration(Context context){
        size30 = dpToPx(context, 30);
        size40 = dpToPx(context, 40);
        size15 = dpToPx(context, 15);
        size20 = dpToPx(context, 20);

    }

    //dp => pixel단위로 변경
    private int dpToPx(Context context, int dp) {

        return (int) TypedValue.applyDimension
                (TypedValue.COMPLEX_UNIT_DIP, dp, context.getResources().getDisplayMetrics());
    }

    @Override
    public void getItemOffsets(@NonNull Rect outRect, @NonNull View view, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
        super.getItemOffsets(outRect, view, parent, state);

        int position = parent.getChildAdapterPosition(view);
        int itemCount = state.getItemCount();

        //상하 설정
        if(position == 0 ) {
            // 첫번 째 줄 아이템
            outRect.top = size40;
            outRect.bottom = size15;
        }else if(position == 1 || position == 2){
            outRect.top = size40;
            outRect.bottom = size15;

        }else {
            outRect.top = size15;
            outRect.bottom = size15;
        }

     //    spanIndex = 0 //-> 왼쪽
     //    spanIndex = 1 //-> 오른쪽
        GridLayoutManager.LayoutParams lp = (GridLayoutManager.LayoutParams) view.getLayoutParams();
        int spanIndex = lp.getSpanIndex();

        if(spanIndex == 0) {
            //왼쪽 아이템
            outRect.left = size20;

        } else{
            //오른쪽 아이템
            outRect.left = size20;
        }
        outRect.right = size20;

//        outRect.top = size;
//        outRect.right = size30;
//        outRect.bottom = size30;
//        outRect.left = size30;
    }
}

