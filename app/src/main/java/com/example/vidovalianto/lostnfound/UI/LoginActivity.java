package com.example.vidovalianto.lostnfound.UI;

import android.app.ProgressDialog;
import android.content.Intent;
import android.database.Cursor;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.vidovalianto.lostnfound.Database.DatabaseHandler;
import com.example.vidovalianto.lostnfound.Model.User;
import com.example.vidovalianto.lostnfound.R;
import com.example.vidovalianto.lostnfound.SessionManager;

public class LoginActivity extends AppCompatActivity {

    private static final String TAG = "database" ;
    ProgressDialog progressDialog;
    EditText mUsername;
    EditText mPassword;
    SessionManager mSession;
    public DatabaseHandler mDbHelper;

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

        String username = mUsername.getText().toString();
        String password = mPassword.getText().toString();

        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        mSession.setUserName(user.getUsername());
        mSession.setPassword(user.getPassword());
        progressDialog.show();
        toProfile();

//        if(mDbHelper.finduser(username)!=null){
//        User user = new User();
//        user.setUsername(username);
//        user.setPassword(password);
//        mSession.setUserName(user.getUsername());
//        mSession.setPassword(user.getPassword());
//        progressDialog.show();
//        toProfile();}else {
//            Toast.makeText(this,"No User Found",Toast.LENGTH_SHORT);
//        }
    }

//    public Cursor getBusinessInfo(String name) {
//        return mDbHelper.rawQuery("SELECT business,address,phone,hours,website,type FROM Business where name like ?", new String[]{"%"+name+"%"}); };

    public void toProfile() {
        Intent next = new Intent(this,ProfileActivity.class);
        startActivity(next);
        progressDialog.dismiss();
        finish();
    }

    public void toSignUp() {
        Intent next = new Intent(this,SignupActivity.class);
        startActivity(next);
        finish();
    }

}
