package com.example.cocoding.Code;


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

public class Recyclerview_Code_ItemAdapter extends RecyclerView.Adapter<Recyclerview_Code_ItemAdapter.ViewHolder> {
    private Context context;
    private ArrayList<RecyclerviewItem> ArrayList;

    public com.example.cocoding.Flow.Recyclerview_Flow_ItemAdapter.OnItemClickListener mOnItemClickListener = null;

    public interface OnItemClickListener {
        void onItemClick(View view, int position);
    }

    public void setOnItemClickListener(com.example.cocoding.Flow.Recyclerview_Flow_ItemAdapter.OnItemClickListener listener) {
        mOnItemClickListener = listener;
    }

    public Recyclerview_Code_ItemAdapter(Context context, ArrayList<RecyclerviewItem> flowItemArrayList) {
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


        }
    }

    @NonNull
    @Override
    public Recyclerview_Code_ItemAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.flow_item, viewGroup, false);
        return new Recyclerview_Code_ItemAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final RecyclerviewItem flowItem = ArrayList.get(position);
        holder.imageView.setImageResource(flowItem.getImage());
        Log.e("Click 전" , "[" + flowItem.getImage() + "]");
    }



    @Override
    public int getItemCount() {
        return ArrayList.size();
    }

//    public void setItems(ArrayList<RecyclerviewItem> ArrayList){
//        this.ArrayList = ArrayList;
//    }


}
