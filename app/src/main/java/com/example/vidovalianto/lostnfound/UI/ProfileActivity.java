package com.example.vidovalianto.lostnfound.UI;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.example.vidovalianto.lostnfound.Database.DatabaseHandler;
import com.example.vidovalianto.lostnfound.Model.User;
import com.example.vidovalianto.lostnfound.R;
import com.example.vidovalianto.lostnfound.SessionManager;

/**
 * Created by VidoValianto on 11/27/17.
 */

public class ProfileActivity extends BaseActivity {


    TextView mName;
    TextView mEmail;
    public DatabaseHandler mDbHelper;
    SessionManager mSession;
    LinearLayout dynamicContent,bottomNavBar;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        dynamicContent = (LinearLayout)  findViewById(R.id.dynamicContent);
        bottomNavBar= (LinearLayout) findViewById(R.id.bottomNavBar);
        View wizard = getLayoutInflater().inflate(R.layout.profile_page, null);
        dynamicContent.addView(wizard);

        mName = (TextView) dynamicContent.findViewById(R.id.textview_nama);
        mEmail = (TextView) dynamicContent.findViewById(R.id.textview_email);

        mSession = new SessionManager(this);

        mName.setText(mSession.getUserName());
        mEmail.setText(mSession.getEmail());

        RadioGroup rg=(RadioGroup)findViewById(R.id.radioGroup1);
        RadioButton rb=(RadioButton)findViewById(R.id.rb_profile);

        // Change the corresponding icon and text color on nav button click.

        rb.setTextColor(Color.parseColor("#3F51B5"));
    }

    @Override
    protected void onDestroy() {
        mDbHelper.close();
        super.onDestroy();
    }


}
