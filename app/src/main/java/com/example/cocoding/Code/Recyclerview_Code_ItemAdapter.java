package com.example.cocoding.Code;


import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cocoding.Code.Block.BlockItem;
import com.example.cocoding.R;
import com.example.cocoding.RecyclerviewItem;

import java.util.ArrayList;

public class Recyclerview_Code_ItemAdapter extends RecyclerView.Adapter<Recyclerview_Code_ItemAdapter.ViewHolder> {
    private Context context;
    private ArrayList<BlockItem> ArrayList;

    public OnItemClickListener mOnItemClickListener = null;

    int viewpager_position;

    public interface OnItemClickListener {
        void onItemClick(View view, BlockItem blockItem);
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        mOnItemClickListener = listener;
    }

    public Recyclerview_Code_ItemAdapter(Context context, ArrayList<BlockItem> CodeItemArrayList) {
        this.context = context;
        this.ArrayList = CodeItemArrayList;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private ImageView imageView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = (ImageView) itemView.findViewById(R.id.code_image);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    viewpager_position = getAdapterPosition();
                    BlockItem blockItem;
                    if (ArrayList != null) {
                        blockItem = ArrayList.get(viewpager_position);
                        mOnItemClickListener.onItemClick(view, blockItem);
                    }

                }
            });
        }
    }

//    앞에서 정의한 뷰 홀더가 새롭게 만들어지는 시점에 호출이 됩니다.
//
//    그 안에서 각각의 아이템을 위해 정의한 XML 레이아웃을 뷰 객체로 만들어줍니다.
//
//    그 후 그 객체를 반환하면서 ViewHolder 클래스에서 레이아웃을 참조할 수 있도록 도와줍니다.
//
//    즉 리사이클러뷰에 보이는 레이아웃 구성을 설정하고 인플레이션하는 매서드이라고 생각하면 됩니다.

    @NonNull
    @Override
    public Recyclerview_Code_ItemAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.code_item, viewGroup, false);
        return new Recyclerview_Code_ItemAdapter.ViewHolder(view);
    }

//    onCreateViewHolder 매서드를 통해 생성한 객체를 재활용하여 내부의 데이터만 바꾸는 형식입니다.
//
//    ViewHolder 클래스에 새로운 데이터를 담아 설정을 하여서 같은 객체에 다른 데이터를 포함합니다.

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final BlockItem codeItem = ArrayList.get(position);

//        if(viewpager_position == 0) {
//            LinearLayout.LayoutParams parmas = (LinearLayout.LayoutParams) holder.imageView.getLayoutParams();
//            parmas.width = 150;
//            parmas.height = 10;
//            holder.imageView.setLayoutParams(parmas);
//        }

        holder.imageView.setImageResource(codeItem.getBlockImage());
        Log.e("code", "[" + codeItem.getImage() + "]");
    }


    @Override
    public int getItemCount() {
        return ArrayList.size();
    } //어댑터에서 관리하는 아이템의 개수를 반환

//    public void setItems(ArrayList<RecyclerviewItem> ArrayList){
//        this.ArrayList = ArrayList;
//    }


}
