package com.example.cocoding.Object;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.cocoding.R;

import java.util.ArrayList;

public class FolderAdapter extends RecyclerView.Adapter<FolderAdapter.ViewHolder>{

    //Fragment>fRecyclerView 에서 가져온 정보를 FolderData형식으로 현 자바 파일 속 arraylist속에 차곡차곡 저장할거에요
    private ArrayList<FolderData> folderData = new ArrayList<>();

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //한번에 보여주는 데이터 모양은 object_folder_set.xml을 참고하면 됨
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.object_folder_set, parent, false);

        return new ViewHolder(v);
    }

    // 생성자에서 데이터 리스트 객체를 전달받음.
    public FolderAdapter(){
    }

    //fragment내의 fRecyclerview로 부터 folder에 대한 정보(폴더이름, 이미지)를 가져와서 현 자바파일 속 arraylist속에 저장
    public void addData(FolderData input){
        folderData.add(input);
    }

    // onBindViewHolder() - position에 해당하는 데이터를 뷰홀더의 아이템뷰에 표시.
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.onBind(folderData.get(position));
    }

    // getItemCount() - 전체 데이터 갯수 리턴.
    @Override
    public int getItemCount() {
        return folderData.size() ;
    }

    // 아이템 뷰를 저장하는 뷰홀더 클래스.
    public class ViewHolder extends RecyclerView.ViewHolder {
        //보여줘야하는 것들
        private ImageView listImage;
        private TextView listName;

        public ViewHolder(View view) {
            super(view);
            //listImage는 object_folder_set 속 listImage자리에 놓을 거에요
            listImage = (ImageView) view.findViewById(R.id.listImage);
            //listName은 object_folder_set 속 listName자리에 놓을 거에요
            listName = (TextView) view.findViewById(R.id.listName);

            //folder이미지를 누르면 해당 객체리스트를 보여주는 xml화면으로 전환됨
            //object_list.xml로 넘어감.
            //나중에 object_list.xml속에 recyclerview를 추가해줄거사ㅓㄴ아ㅓ ㅏㅓㅗㅁ
            listImage.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int pos = getAdapterPosition() ;
                    if (pos != RecyclerView.NO_POSITION) {
                        // TODO : use pos.
                        Context context = v.getContext();
                        Intent intent = new Intent(v.getContext(),Object_List.class);

                        intent.putExtra("folderNum", 1);
                        context.startActivity(intent);
                    }
                }
            });
            listName.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int pos = getAdapterPosition() ;
                    if (pos != RecyclerView.NO_POSITION) {
                        // TODO : use pos.

                    }
                }
            });
        }
        void onBind(FolderData data) {
            //listImage에 대한 정보는 해당 데이터 셋의 image정보를 가져와서 세팅(현재는 폴더모양으로 고정)
            listImage.setImageResource(data.getlistImage());
            //listName에 대한 정보는 해당 데이터셋의 Name정보를 가져와서 세팅(현재는 넘버링으로 고정)
            listName.setText(data.getlistName());
        }
    }

}
