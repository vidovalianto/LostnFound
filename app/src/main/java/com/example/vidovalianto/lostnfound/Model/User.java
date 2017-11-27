package com.example.vidovalianto.lostnfound.Model;

import java.io.Serializable;

/**
 * Created by VidoValianto on 11/27/17.
 */

public class User implements Serializable {

    private static String  username;
    private static String password;
    private static String email;

    public static String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public static String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public static String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
