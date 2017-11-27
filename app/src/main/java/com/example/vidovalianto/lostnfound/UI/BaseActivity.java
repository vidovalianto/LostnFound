package com.example.vidovalianto.lostnfound.UI;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.RadioGroup;

import com.example.vidovalianto.lostnfound.R;

/**
 * Created by VidoValianto on 11/28/17.
 */

public class BaseActivity extends AppCompatActivity {

    RadioGroup radioGroup1;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);

        radioGroup1=(RadioGroup)findViewById(R.id.radioGroup1);
        radioGroup1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
        {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId)
            {
                Intent in;

                switch (checkedId)
                {
                    case R.id.rb_home:
                        Log.i("matching", "matching inside1 home" +  checkedId);
                        in=new Intent(getBaseContext(),HomeActivity.class);
                        startActivity(in);
                        overridePendingTransition(0, 0);
                        break;
                    case R.id.rb_post:
                        Log.i("matching", "matching inside1 post" + checkedId);

                        in = new Intent(getBaseContext(), PostActivity.class);
                        startActivity(in);
                        overridePendingTransition(0, 0);

                        break;
                    case R.id.rb_profile:
                        Log.i("matching", "matching inside1 profile" + checkedId);

                        in = new Intent(getBaseContext(), ProfileActivity.class);
                        startActivity(in);
                        overridePendingTransition(0, 0);
                        break;
                    default:
                        break;
                }
            }
        });
    }
}
