package com.example.vidovalianto.lostnfound.UI;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

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

        RadioGroup rg=(RadioGroup)findViewById(R.id.radioGroup1);
        RadioButton rb=(RadioButton)findViewById(R.id.rb_home);

        // Change the corresponding icon and text color on nav button click.

        rb.setTextColor(Color.parseColor("#3F51B5"));


    }

    public void setHomeData(){
        recycleView.setHasFixedSize(true);
        recycleView.setLayoutManager(new LinearLayoutManager(this));
        Item item = new Item();
        item.setBarang("Kunci Kos");
        item.setHari("Kamis");
        item.setLokasi("Jakal km 9 dekat indomaret");
        item.setStatusBarang("HILANG");
        list.add(item);

        Item item2 = new Item();
        item2.setBarang("Handphone Xiomay warna kuning");
        item2.setHari("Senin");
        item2.setLokasi("Gedung D Lantai 6 Fakultas MIPA UGM");
        item2.setStatusBarang("HILANG");
        list.add(item2);

        Log.d(TAG, "setHomeData: " + list.get(0).getBarang());
        ItemAdapter adapter = new ItemAdapter(list);
        recycleView.setAdapter(adapter);

    }

}
