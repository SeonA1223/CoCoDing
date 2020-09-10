package com.example.cocoding.Flow;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cocoding.R;
import com.example.cocoding.RecyclerviewItem;

import java.util.ArrayList;

public class Recyclerview_Flow_ItemAdapter extends RecyclerView.Adapter<Recyclerview_Flow_ItemAdapter.ViewHolder> {
    private Context context;
    private ArrayList<RecyclerviewItem> ArrayList;

    public OnItemClickListener mOnItemClickListener = null;

    public interface OnItemClickListener {
        void onItemClick(View view, int position);
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        mOnItemClickListener = listener;
    }

    public Recyclerview_Flow_ItemAdapter(Context context, ArrayList<RecyclerviewItem> flowItemArrayList) {
        this.context = context;
        this.ArrayList = flowItemArrayList;
    }


//    public void updateData(ArrayList<RecyclerviewItem> arrayList){
//        arrayList.clear();
//        arrayList.addAll(arrayList);
//        notifyDataSetChanged();
//    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private ImageView imageView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = (ImageView) itemView.findViewById(R.id.flow_image);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition();
                    Log.e("check", "[" + v.getId() + "]");
                    Log.e("check", "[" + position + "]");
                    mOnItemClickListener.onItemClick(v, position);
                    //conditionRef.push().setValue(position); // 파이어베이스에 순서도 도형의 position 저장 -> MakeFlowFragment에 imageNumber를 활용하기로,,
                }
            });
        }
    }

    @NonNull
    @Override
    public Recyclerview_Flow_ItemAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.flow_item, viewGroup, false);
        return new Recyclerview_Flow_ItemAdapter.ViewHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull Recyclerview_Flow_ItemAdapter.ViewHolder viewHolder, int i) {
        final RecyclerviewItem flowItem = ArrayList.get(i);
        viewHolder.imageView.setImageResource(flowItem.getImage());
        Log.e("Click 전" , "[" + flowItem.getImage() + "]");

        /*서버 or internet에서 값 가져올 경우
        Glide.with(ViewHolder.view.getContext()).load(item.getUrl()).into(viewHolder.(URL id);
        * */
//        viewHolder.imageView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Fragment fragment = new MakeFlowFragment();
//                Bundle bundle = new Bundle();
//                bundle.putInt("imageNumber", flowItem.getImage());
//                Log.e("Click 후" , "[" + flowItem.getImage() + "]");
//                //fragment.setArguments(bundle);
//
//            }
//        });



    }

    @Override
    public int getItemCount() {
        return ArrayList.size();
    }

//    public void setItems(ArrayList<RecyclerviewItem> ArrayList){
//        this.ArrayList = ArrayList;
//    }


}
