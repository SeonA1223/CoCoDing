package com.spy.cocoding.Object;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.spy.cocoding.R;

import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ObjectFragment extends BottomSheetDialogFragment {
    private BottomSheetListener mListener;

    FirebaseFirestore db;
    //firebase 에 저장을 위한 이미지 저장용 hashmap
    private Map<String, Object> photo = new HashMap<>();

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private RecyclerView oRecyclerView;

    private ObjectAdapter oAdapter;

    private RecyclerView.LayoutManager oLayoutManager;

    //user가 추가한 image에 대한 각각의 정보를 arraylist속에 순서대로 저장할거에요
    List<String> objectName = new ArrayList();
    //그중에서도 getImageFromAlbum메소드를 통해 이미지의 Uri정보를 가져옵니다.
    List<Uri> userObjectImage = new ArrayList();

    //초기에는 사용자가 가져온 이미지가 0개에요
    private int objectNum = 0;

    //이미지 가져오는거 잘 됐는지 확인하려구
    private boolean imageAdded = false;


    // TODO: Rename and change types and number of parameters

    private String mParam1;
    private String mParam2;
    private Activity view;
    public static final int GALLERY_REQUEST_CODE = 1;
    private Context context;


    public ObjectFragment() {
        // Required empty public constructor
    }

    public interface BottomSheetListener {
        void onButtonClicked(String text);
    }

    public static ObjectFragment newInstance(String param1, String param2) {
        ObjectFragment fragment = new ObjectFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.object_fragment, container, false);

        return view;

    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        oRecyclerView = (RecyclerView) view.findViewById(R.id.object_recyclerview_object);
        oRecyclerView.setHasFixedSize(true);

        oAdapter = new ObjectAdapter();

        oLayoutManager = new GridLayoutManager(getActivity(), 4);

        oRecyclerView.setLayoutManager(oLayoutManager);

        db = FirebaseFirestore.getInstance();

        // 객체 추가하는 버튼
        FloatingActionButton addImage = (FloatingActionButton) view.findViewById(R.id.addImage);

        //fab 속에 있는 addImage 버튼을 누르면 갤러리에서 이미지를 가지고옴
        addImage.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                getImageFromAlbum();
                if (imageAdded) {
                    imageAdded = false;
                }
            }
        });

    }


    //갤러리 화면으로 넘어갑니다.
    private void getImageFromAlbum() {
        //Create an Intent with action as ACTION_PICK
        Intent intent = new Intent(Intent.ACTION_PICK);
        // Sets the type as image/*. This ensures only components of type image are selected
        intent.setType("image/*");
        //We pass an extra array with the accepted mime types. This will ensure only components with these MIME types as targeted.
        String[] mimeTypes = {"image/jpeg", "image/png"};
        intent.putExtra(Intent.EXTRA_MIME_TYPES, mimeTypes);
        // Launching the Intent
        startActivityForResult(intent, GALLERY_REQUEST_CODE);
    }

    //갤러리 속에서 이미지 버튼을 클릭하면 동작합니다.
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        // Result code is RESULT_OK only if the user selects an Image

        if (resultCode == Activity.RESULT_OK)
            switch (requestCode) {
                case GALLERY_REQUEST_CODE:
                    //data.getData returns the content URI for the selected Image
                    Uri selectedImage = data.getData();

                    //현재 자바 파일 속 리스트에 user가 선택한 이미지 Uri값을 저장함
                    userObjectImage.add(selectedImage);

                    //Adapter내의 Arraylist에 ObjectData형식(이름+uri)의 데이터를 추가함
                    addObject(objectNum);

                    photo.put("photo"+objectNum, selectedImage.toString());
                    db.collection("Object_test").document("Object")
                            .set(photo);
                    objectNum++;
                    Bundle bundle = new Bundle(1); // 파라미터의 숫자는 전달하려는 값의 갯수
                    int folderNum = bundle.getInt("folderNum");
                    bundle.putInt("folderNum", folderNum);
                    oAdapter.setArguments(bundle);
                    //adapter속에서 정보를 가져와서 recyclerview에 보여줌
                    oRecyclerView.setAdapter(oAdapter);

                    imageAdded = true;
                    break;
            }
    }

    //유저가 추가한 이미지에 대한 정보를 어댑터로 넘겨주는 메소드
    public void addObject(int i) {

        //이미지 이름은 현 폴더 리스트에 추가하여 저장
        objectName.add("image " + Integer.toString(i + 1));

        //ObjectData형식의 데이터 생성
        ObjectData data = new ObjectData();

        //데이터에 대한 각각의 정보를 update
        data.setobjectName(objectName.get(i));
        data.setuserObjectImage(userObjectImage.get(i));

        //어댑터 속 userobject에 해당하는 arraylist에 정보를 추가
        oAdapter.addData(data);
    }
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
//        try {
//            mListener = (BottomSheetListener) context;
//        } catch (ClassCastException e) {
//            throw new ClassCastException(context.toString()
//                    + " must implement BottomSheetListener");
//        }
    }

}
