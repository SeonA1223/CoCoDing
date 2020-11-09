package com.example.cocoding.Code;

import android.content.Context;
import android.graphics.Rect;
import android.util.TypedValue;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cocoding.Code.CodeRecyclerview;

public class CodeRecyclerview_ItemDecoration extends RecyclerView.ItemDecoration {

    private int size10;
    private int size20;

    public CodeRecyclerview_ItemDecoration(Context context){
        size10 = dpToPx(context, 5);
        size20 = dpToPx(context, 30);

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
        if(position == 0) {
            // 첫번 째 줄 아이템
            outRect.top = size20;
        }

        outRect.top = size10;
        outRect.bottom = size10;
        outRect.left = size20;
    }
}
