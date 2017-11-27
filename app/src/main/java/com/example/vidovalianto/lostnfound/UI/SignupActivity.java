package com.example.vidovalianto.lostnfound.UI;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.vidovalianto.lostnfound.Model.User;
import com.example.vidovalianto.lostnfound.R;
import com.example.vidovalianto.lostnfound.SessionManager;

/**
 * Created by VidoValianto on 11/27/17.
 */

public class SignupActivity extends AppCompatActivity{

    ProgressDialog progressDialog;
    EditText mUsername;
    EditText mPassword;
    EditText mEmail;
    EditText mRePassword;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sign_up_page);

        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Signing in...");
        progressDialog.setCancelable(false);

        mUsername = (EditText) findViewById(R.id.edit_id);
        mPassword = (EditText) findViewById(R.id.edit_pass);
        mEmail = (EditText) findViewById(R.id.edit_email);
        mRePassword = (EditText) findViewById(R.id.edit_repass);

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








