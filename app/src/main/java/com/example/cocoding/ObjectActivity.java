package com.example.cocoding;

import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cocoding.Object.FolderAdapter;
import com.example.cocoding.Object.FolderData;
import com.example.cocoding.Object.ObjectFragment;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ObjectActivity extends BaseActivity {

    private FragmentManager manager;
    private ObjectFragment oFragment = new ObjectFragment();


    // "폴더"리스트 recyclerview
    private RecyclerView fRecyclerView;

    // 폴더 어댑터
    private FolderAdapter fAdapter;

    // 폴더 레이아웃 매니저
    private RecyclerView.LayoutManager fLayoutManager;

    // 폴더에 해당하는 각각의 정보를 사용자에게 받아서 임시로 저장하는 공간
    List<String> listName = new ArrayList();
    List<Integer> listImage = Arrays.asList(R.drawable.folder_icon);

    //초기에는 폴더가 0개에요
    private int folderNum = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_object);

        // 폴더 추가하는 버튼
        ImageButton addFolder = (ImageButton) findViewById(R.id.add_folder);

        // object list fragment 여는 버튼
        ImageButton addObject = (ImageButton) findViewById(R.id.add_object);

        // 폴더가 추가되는 recyclerview 선언
        fRecyclerView = (RecyclerView) findViewById(R.id.object_recyclerview_folder);
        fRecyclerView.setHasFixedSize(true);

        // adapter 생성
        fAdapter = new FolderAdapter();

        // layoutmanager
        fLayoutManager = new GridLayoutManager(this, 2);

        manager = getSupportFragmentManager();

        addFolder.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                addFolder(folderNum);
                folderNum++;
                fRecyclerView.setAdapter(fAdapter);
            }
        });
        addObject.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){

                    //ObjectFragment bottomSheet = new ObjectFragment();
                    oFragment.show(getSupportFragmentManager(), "exampleBottomSheet");
            }
        });

    }

    //각 폴더에 대한 정보를 어댑터로 넘겨주는 메소드
    public void addFolder(int i) {
        //폴더 이름은 현 폴더 리스트에 추가하여 저장
        listName.add("folder " + Integer.toString(i + 1));

        //FolderData형식의 데이터 생성
        FolderData data = new FolderData();

        //데이터에대한 각각의 정보를 update
        data.setlistName(listName.get(i));
        data.setlistImage(listImage.get(0));

        //어댑터 속 folder에 해당하는 arraylist에 정보를 추가
        fAdapter.addData(data);

    }

    @Override
    int getContentViewId() {
        return R.layout.activity_code;
    }

    @Override
    int getNavigationMenuItemId() {
        return R.id.navigation_code;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.back, menu);
        return true;
    }

}