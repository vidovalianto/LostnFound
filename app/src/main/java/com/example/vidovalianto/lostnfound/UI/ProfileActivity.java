package com.example.vidovalianto.lostnfound.UI;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.vidovalianto.lostnfound.Model.User;
import com.example.vidovalianto.lostnfound.R;

/**
 * Created by VidoValianto on 11/27/17.
 */

class ProfileActivity extends AppCompatActivity {

    ProgressDialog progressDialog;
    EditText mUsername;
    EditText mPassword;
    EditText mEmail;
    EditText mRePassword;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile_page);

        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Signing in...");
        progressDialog.setCancelable(false);

        mUsername = (EditText) findViewById(R.id.edit_id);
        mPassword = (EditText) findViewById(R.id.edit_pass);
        mEmail = (EditText) findViewById(R.id.edit_email);
        mRePassword = (EditText) findViewById(R.id.edit_repass);
        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottom_navigation);

        bottomNavigationView.setOnNavigationItemSelectedListener(
                new BottomNavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                        switch (item.getItemId())
                        {
                            case R.id.action_home:;
                            case R.id.action_post:;
                            case R.id.action_profile:;
                        }
                        return true;
                    }
                }
        )
        ;


        Button next = (Button) findViewById(R.id.loginbutton);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkUser();
            }
        });
    }

    public void checkUser(){
        if(mRePassword.getText().toString()==mPassword.getText().toString()){
        final User user = new User();
        user.setUsername(mUsername.getText().toString());
        user.setPassword(mPassword.getText().toString());
        progressDialog.show();
        toLogin();
    }}

    public void toLogin() {
        Intent next = new Intent(this,LoginActivity.class);
        startActivity(next);
        finish();
    }




}
