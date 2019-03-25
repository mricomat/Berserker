package com.martnrico.berserker.data;

import android.content.Context;

import com.martnrico.berserker.data.network.ServiceHelper;
import com.martnrico.berserker.data.network.form.LoginForm;
import com.martnrico.berserker.data.network.model.Entry.EntryModel;
import com.martnrico.berserker.data.network.model.LoginModel;
import com.martnrico.berserker.data.network.model.Entry.PagedModel;
import com.martnrico.berserker.data.network.model.RegisterModel;
import com.martnrico.berserker.data.network.model.UserModel;
import com.martnrico.berserker.data.prefs.PreferencesHelper;
import com.martnrico.berserker.di.ApplicationContext;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Single;

/**
 * Created by Martín Rico Martínez on 19/11/2018.
 */
@Singleton
public class AppDataManager implements DataManager {

    private final Context mContext;
    private final PreferencesHelper mPreferencesHelper;
    private final ServiceHelper mServiceHelper;

    @Inject
    public AppDataManager(@ApplicationContext Context context,
                          PreferencesHelper preferencesHelper, ServiceHelper serviceHelper) {
        mContext = context;
        mPreferencesHelper = preferencesHelper;
        mServiceHelper = serviceHelper;
    }

    @Override
    public void setUserAsLoggedOut() {
        updateUserInfo(null, null, DataManager.LoggedInMode.LOGGED_IN_MODE_LOGGED_OUT,
                null, null, null);
    }

    @Override
    public void updateUserInfo(String accessToken, Long userId, LoggedInMode loggedInMode, String userName, String email, String profilePicPath) {
        setAccessToken(accessToken);
        setCurrentUserId(userId);
        setCurrentUserLoggedInMode(loggedInMode);
        setCurrentUserName(userName);
        setCurrentUserEmail(email);
        setCurrentUserProfilePicUrl(profilePicPath);

        //updateApiHeader(userId, accessToken);
    }

    @Override
    public int getCurrentUserLoggedInMode() {
        return mPreferencesHelper.getCurrentUserLoggedInMode();
    }

    @Override
    public void setCurrentUserLoggedInMode(LoggedInMode mode) {
        mPreferencesHelper.setCurrentUserLoggedInMode(mode);
    }

    @Override
    public Long getCurrentUserId() {
        return mPreferencesHelper.getCurrentUserId();
    }

    @Override
    public void setCurrentUserId(Long userId) {
        mPreferencesHelper.setCurrentUserId(userId);
    }

    @Override
    public String getCurrentUserName() {
        return mPreferencesHelper.getCurrentUserName();
    }

    @Override
    public void setCurrentUserName(String userName) {
        mPreferencesHelper.setCurrentUserName(userName);
    }

    @Override
    public String getCurrentUserEmail() {
        return mPreferencesHelper.getCurrentUserEmail();
    }

    @Override
    public void setCurrentUserEmail(String email) {
        mPreferencesHelper.setCurrentUserEmail(email);
    }

    @Override
    public String getCurrentUserProfilePicUrl() {
        return mPreferencesHelper.getCurrentUserProfilePicUrl();
    }

    @Override
    public void setCurrentUserProfilePicUrl(String profilePicUrl) {
        mPreferencesHelper.setCurrentUserProfilePicUrl(profilePicUrl);
    }

    @Override
    public String getAccessToken() {
        return mPreferencesHelper.getAccessToken();
    }

    @Override
    public void setAccessToken(String accessToken) {
        mPreferencesHelper.setAccessToken(accessToken);
    }

    @Override
    public Single<LoginModel> loginAuthentication(LoginForm loginForm) {
        return mServiceHelper.loginAuthentication(loginForm);
    }

    @Override
    public Single<RegisterModel> registerNewUser(UserModel userModel) {
        return mServiceHelper.registerNewUser(userModel);
    }

    @Override
    public Single<PagedModel<EntryModel>> getPagedEntries(Integer page, Integer size) {
        return mServiceHelper.getPagedEntries(page, size);
    }
}
