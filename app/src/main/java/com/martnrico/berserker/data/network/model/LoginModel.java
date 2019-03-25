package com.martnrico.berserker.data.network.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Martín Rico Martínez on 21/11/2018.
 */
public class LoginModel {

    @SerializedName("accessToken")
    private String mAccessToken;

    @SerializedName("userId")
    private Long mUserId;

    @SerializedName("userName")
    private String mUserName;

    @SerializedName("userEmail")
    private String mUserEmail;

    @SerializedName("profilePicUrl")
    private String mProfilePicUrl;

    public String getAccessToken() {
        return mAccessToken;
    }

    public void setAccessToken(String accessToken) {
        this.mAccessToken = accessToken;
    }

    public Long getUserId() {
        return mUserId;
    }

    public void setUserId(Long userId) {
        mUserId = userId;
    }

    public String getUserName() {
        return mUserName;
    }

    public void setUserName(String userName) {
        mUserName = userName;
    }

    public String getUserEmail() {
        return mUserEmail;
    }

    public void setUserEmail(String userEmail) {
        mUserEmail = userEmail;
    }

    public String getProfilePicUrl() {
        return mProfilePicUrl;
    }

    public void setProfilePicUrl(String profilePicUrl) {
        mProfilePicUrl = profilePicUrl;
    }
}
