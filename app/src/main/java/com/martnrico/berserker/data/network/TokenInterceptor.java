package com.martnrico.berserker.data.network;

import com.martnrico.berserker.data.prefs.PreferencesHelper;

import java.io.IOException;

import javax.inject.Inject;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by Martín Rico Martínez on 21/01/2019.
 */
public class TokenInterceptor implements Interceptor {

    private PreferencesHelper mPreferencesHelper;

    @Inject
    public TokenInterceptor(PreferencesHelper PreferencesHelper) {
        this.mPreferencesHelper = PreferencesHelper;
    }

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request initialRequest = chain.request();
        Request modifiedRequest = initialRequest;
        if (mPreferencesHelper.getAccessToken() != null) {
            modifiedRequest = initialRequest.newBuilder()
                    .addHeader("Authorization", String.format("Bearer %s",
                            mPreferencesHelper.getAccessToken()))
                    .build();

        }
        return chain.proceed(modifiedRequest);

    }
}
