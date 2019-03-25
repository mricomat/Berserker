package com.martnrico.berserker.data.network.form;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Martín Rico Martínez on 21/11/2018.
 */
public class LoginForm {

    @SerializedName("email")
    private String mEmail;

    @SerializedName("password")
    private String mPassword;

    public LoginForm() {

    }

    public LoginForm(String email, String password) {
        this.mEmail = email;
        this.mPassword = password;
    }

    public String getEmail() {
        return mEmail;
    }

    public void setEmail(String email) {
        mEmail = email;
    }

    public String getPassword() {
        return mPassword;
    }

    public void setPassword(String password) {
        mPassword = password;
    }
}
