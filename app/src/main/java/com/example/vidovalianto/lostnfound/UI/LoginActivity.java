package com.example.vidovalianto.lostnfound.UI;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.vidovalianto.lostnfound.Model.User;
import com.example.vidovalianto.lostnfound.R;
import com.example.vidovalianto.lostnfound.SessionManager;

public class LoginActivity extends AppCompatActivity {

    ProgressDialog progressDialog;
    EditText mUsername;
    EditText mPassword;
    SessionManager mSession;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_page);

        mSession = new SessionManager(this);

        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Signing in...");
        progressDialog.setCancelable(false);

        mUsername = (EditText) findViewById(R.id.edit_id);
        mPassword = (EditText) findViewById(R.id.edit_pass);

        Button login_btn = (Button) findViewById(R.id.loginbutton);
        login_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkUser();
            }
        });

        Button signup_btn = (Button) findViewById(R.id.signupbutton);
        signup_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                toSignUp();
            }
        });

    }


    public void checkUser(){
        User user = new User();
        user.setUsername(mUsername.getText().toString());
        user.setPassword(mPassword.getText().toString());
        progressDialog.show();
        toProfile();
    }

    public void toProfile() {
        Intent next = new Intent(this,ProfileActivity.class);
        startActivity(next);
        finish();
    }

    public void toSignUp() {
        Intent next = new Intent(this,SignupActivity.class);
        startActivity(next);
        finish();
    }

    public void toProfileAct(View view)
    {
        Intent  intent = new Intent(getApplicationContext(), ProfileActivity.class);
        startActivity(intent);

    }


}
