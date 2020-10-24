package com.example.cocoding.Object;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;
import com.google.firebase.firestore.FirebaseFirestore;
import com.example.cocoding.MainActivity;
import com.example.cocoding.ObjectActivity;
import com.example.cocoding.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ObjectAdapter  extends RecyclerView.Adapter<ObjectAdapter.ViewHolder> {


    //Fragment>oRecyclerView 에서 가져온 정보를 ObjectData형식으로 현 자바 파일 속 arraylist속에 차곡차곡 저장할거에요
    private ArrayList<ObjectData> objectData = new ArrayList<>();
    private int folderNum = 10;
    String[] folder = new String[3];

    FirebaseFirestore db = FirebaseFirestore.getInstance();
    private Map<String, Object> pf = new HashMap<>();

    @Override
    public ObjectAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //한번에 보여주는 데이터 모양은 object_list_set.xml을 참고하면 됨
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.object_list_set, parent, false);

        return new ObjectAdapter.ViewHolder(v);
    }

    // 생성자에서 데이터 리스트 객체를 전달받음.
    public ObjectAdapter(){
    }

    //fragment내의 oRecyclerview로 부터 객체에 대한 정보(객체이름, 이미지Uri)를 가져와서 현 자바파일 속 arraylist속에 저장
    public void addData(ObjectData input){
        objectData.add(input);
    }

    // onBindViewHolder() - position에 해당하는 데이터를 뷰홀더의 아이템뷰에 표시.
    @Override
    public void onBindViewHolder(ObjectAdapter.ViewHolder holder, int position) {
        holder.onBind(objectData.get(position));
    }
    // getItemCount() - 전체 데이터 갯수 리턴.
    @Override
    public int getItemCount() {
        return objectData.size() ;
    }

    public void setArguments(Bundle bundle) {
        folderNum = bundle.getInt("folderNum");

    }


    // 아이템 뷰를 저장하는 뷰홀더 클래스.
    public class ViewHolder extends RecyclerView.ViewHolder {
        //보여줘야 하는 것들
        private TextView objectName;
        private ImageView userObjectImage;

        private ObjectData oData;

        public ViewHolder(View view) {
            super(view);
            //objectImage는 object_list_set 속 objectImage자리에 놓을 거에요
            userObjectImage = (ImageView) view.findViewById(R.id.objectImage);
            //objectName는 object_list_set 속 objectName자리에 놓을 거에요
            objectName = (TextView) view.findViewById(R.id.objectName);


            userObjectImage.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(final View v) {
                    int pos = getAdapterPosition() ;
                    if (pos != RecyclerView.NO_POSITION) {
                        // TODO : 객체 클릭시 폴더에 넣는거 여기에 작업,,

/*                        Bundle bundle = new Bundle();
                        //bundle.putParcelableArrayList(objectData.get(pos).toString(), objectData);
                        bundle.getString("hi", String.valueOf(pos));*/

//                        for(int i =0; i < folderNum; i++){
//                            folder[i] = "폴더"+i;
//                        }

                        AlertDialog.Builder builder = new AlertDialog.Builder(v.getContext());
                        builder.setTitle("폴더1에 저장").setMessage("선택하세요.");


                        builder.setItems(folder, new DialogInterface.OnClickListener(){
                            @Override
                            public void onClick(DialogInterface dialog, int pos)
                            {
                               // String[] items = getResources().getStringArray(R.array.LAN);

                                Toast.makeText(v.getContext(),folder[pos],Toast.LENGTH_LONG).show();
                            }
                        });

                        builder.setPositiveButton("OK", new DialogInterface.OnClickListener(){
                            @Override
                            public void onClick(DialogInterface dialog, int id)
                            {
                                pf.put("photo0", "1");
                                db.collection("cocodingObject").document("Object_Folder")
                                        .set(pf);
                                Toast.makeText(v.getContext(), "저장 완료", Toast.LENGTH_SHORT).show();

                            }
                        });
                        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener(){
                            @Override
                            public void onClick(DialogInterface dialog, int id)
                            {
                                Toast.makeText(v.getContext(), folderNum+"Cancel Click", Toast.LENGTH_SHORT).show();
                            }
                        });



                        AlertDialog alertDialog = builder.create();
                        alertDialog.show();
                    }

                }
            });

        }
        void onBind(ObjectData data) {
            //listImage에 대한 정보는 해당 데이터 셋의 image정보를 가져와서 세팅
            //ObjectFragment에서 getImageFromAlbum 메소드(onActivityResult(),addData)를 통해 이미지 URI정보 저장해놨음
            userObjectImage.setImageURI(data.getuserObjectImage());
            //listName에 대한 정보는 해당 데이터셋의 Name정보를 가져와서 세팅(현재는 넘버링으로 고정)
            objectName.setText(data.getobjectName());
        }
    }
}