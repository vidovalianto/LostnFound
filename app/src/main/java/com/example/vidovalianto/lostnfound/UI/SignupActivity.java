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
    SessionManager mSession;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sign_up_page);

        mSession = new SessionManager(this);

        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Signing in...");
        progressDialog.setCancelable(false);

        mUsername = (EditText) findViewById(R.id.edit_id);
        mPassword = (EditText) findViewById(R.id.edit_pass);

        Button signup_btn = (Button) findViewById(R.id.signupbutton);
        signup_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                toSignUp();
            }
        });
    }


    public void toSignUp() {
        progressDialog.show();
        Intent next = new Intent(this,SignupActivity.class);
        startActivity(next);
        finish();

    }


}





