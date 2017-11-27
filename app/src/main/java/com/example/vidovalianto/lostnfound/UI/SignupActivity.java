package com.example.vidovalianto.lostnfound.UI;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.vidovalianto.lostnfound.Database.DatabaseHandler;
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
    public DatabaseHandler mDbHelper;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sign_up_page);

        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Signing up...");
        progressDialog.setCancelable(false);

        mUsername = (EditText) findViewById(R.id.edit_id);
        mPassword = (EditText) findViewById(R.id.edit_pass);
        mEmail = (EditText) findViewById(R.id.edit_email);
        mRePassword = (EditText) findViewById(R.id.edit_repass);

        mDbHelper = new DatabaseHandler(this.getApplicationContext());

        Button signup = (Button) findViewById(R.id.signupbutton);
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                signupUser();
            }
        });
    }

    public void signupUser(){
        if(mRePassword.getText().toString()==mPassword.getText().toString()){
            User user = new User();
            user.setUsername(mUsername.getText().toString());
            user.setPassword(mPassword.getText().toString());
            user.setEmail(mEmail.getText().toString());
            mDbHelper.addLocation(user);
            progressDialog.show();
            toLogin();
        }else{
            Toast.makeText(this,"Password tidak sama",Toast.LENGTH_SHORT);
        }

        User user = new User();
        user.setUsername(mUsername.getText().toString());
        user.setPassword(mPassword.getText().toString());
        user.setEmail(mEmail.getText().toString());
        mDbHelper.addLocation(user);
        progressDialog.show();
        toLogin();
    }

    public void toLogin() {
        Intent next = new Intent(this,LoginActivity.class);
        startActivity(next);
        progressDialog.dismiss();
        finish();
    }
}








