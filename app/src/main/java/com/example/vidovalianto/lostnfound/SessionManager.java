package com.example.vidovalianto.lostnfound;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by VidoValianto on 11/27/17.
 */

public class SessionManager {

    private static final String PREF_NAME = "lostnfound"; // preference filename
    private static final int MODE_PRIVATE = 0; // preference mode operation


    private static final String USER_NAME = "user_name";
    private static final String PASSWORD = "password";
    private static final String EMAIL = "email";


    private static final String LOGIN = "login";

    private SharedPreferences pref; // use to access preference
    private SharedPreferences.Editor editor; // use to edit preference

    public SessionManager(Context context)
    {
        pref = context.getSharedPreferences(PREF_NAME, MODE_PRIVATE);
        editor = pref.edit();
    }

    public void clearSession() // clear all value in preference
    {
        editor.clear();
        editor.commit();
    }

    public boolean isLogin() // check login info
    {
        return pref.getBoolean(LOGIN, false); // default value = false, means no one has login
    }

    public void setLogin(boolean isLogin) // set login info when user already login
    {
        editor.putBoolean(LOGIN, isLogin);
        editor.commit();
    }

    public void setUserName(String userName)
    {
        editor.putString(USER_NAME, userName);
        editor.commit();
    }


    public String getUserName()
    {
        return pref.getString(USER_NAME, "");
    }

    public void setPassword(String password)
    {
        editor.putString(PASSWORD, password);
        editor.commit();
    }

    public String getPassword()
    {
        return pref.getString(PASSWORD, "");
    }

    public void setEmail(String email)
    {
        editor.putString(EMAIL, email);
        editor.commit();
    }


    public String getEmail()
    {
        return pref.getString(EMAIL, "");
    }

}


