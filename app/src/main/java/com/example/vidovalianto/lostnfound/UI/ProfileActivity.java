package com.example.vidovalianto.lostnfound.UI;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.vidovalianto.lostnfound.Database.DatabaseHandler;
import com.example.vidovalianto.lostnfound.Model.User;
import com.example.vidovalianto.lostnfound.R;
import com.example.vidovalianto.lostnfound.SessionManager;

/**
 * Created by VidoValianto on 11/27/17.
 */

public class ProfileActivity extends AppCompatActivity {


    TextView mName;
    TextView mEmail;
    public DatabaseHandler mDbHelper;
    SessionManager mSession;



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile_page);

        mName = (TextView) findViewById(R.id.textview_nama);
        mEmail = (TextView) findViewById(R.id.textview_email);

        mSession = new SessionManager(this);

        mName.setText(mSession.getUserName());
        mEmail.setText(mSession.getEmail());

    }

    @Override
    protected void onDestroy() {
        mDbHelper.close();
        super.onDestroy();
    }


}
