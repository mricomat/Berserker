package com.martnrico.berserker.data.network.model;

/**
 * Created by Martín Rico Martínez on 21/01/2019.
 */
public class TokenHeaderModel {

    private String mAccessToken;
    private String mTokenType;

    public TokenHeaderModel(String accessToken, String tokenType) {
        mAccessToken = accessToken;
        mTokenType = tokenType;
    }

    public String getAccessToken() {
        return mAccessToken;
    }

    public void setAccessToken(String accessToken) {
        mAccessToken = accessToken;
    }

    public String getTokenType() {
        return mTokenType;
    }

    public void setTokenType(String tokenType) {
        mTokenType = tokenType;
    }
}
