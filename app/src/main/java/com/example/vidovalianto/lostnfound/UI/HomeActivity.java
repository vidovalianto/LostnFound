package com.example.vidovalianto.lostnfound.UI;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;

import com.example.vidovalianto.lostnfound.Model.Item;
import com.example.vidovalianto.lostnfound.R;
import com.example.vidovalianto.lostnfound.helper.ItemAdapter;

import java.util.ArrayList;

/**
 * Created by VidoValianto on 11/28/17.
 */

public class HomeActivity extends BaseActivity {

    private static final String TAG ="" ;
    RecyclerView recycleView;
    ArrayList<Item> list;
    LinearLayout dynamicContent,bottomNavBar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        list = new ArrayList<>();
        dynamicContent = (LinearLayout)  findViewById(R.id.dynamicContent);
        bottomNavBar= (LinearLayout) findViewById(R.id.bottomNavBar);
        View wizard = getLayoutInflater().inflate(R.layout.home_layout, null);
        dynamicContent.addView(wizard);

        recycleView = (RecyclerView) dynamicContent.findViewById(R.id.rv_barang);
        setHomeData();


    }

    public void setHomeData(){
        recycleView.setHasFixedSize(true);
        recycleView.setLayoutManager(new LinearLayoutManager(this));
        Item item = new Item();
        item.setBarang("Kunci Kos");
        item.setHari("Kamis");
        item.setLokasi("Jakal km 9 dekat indomaret");
        list.add(item);
        Log.d(TAG, "setHomeData: " + list.get(0).getBarang());
        ItemAdapter adapter = new ItemAdapter(list);
        recycleView.setAdapter(adapter);
    }

}
