package com.martnrico.berserker.data.prefs;

import com.martnrico.berserker.data.DataManager;

/**
 * Created by Martín Rico Martínez on 20/11/2018.
 */
public interface PreferencesHelper {

    int getCurrentUserLoggedInMode();

    void setCurrentUserLoggedInMode(DataManager.LoggedInMode mode);

    Long getCurrentUserId();

    void setCurrentUserId(Long userId);

    String getCurrentUserName();

    void setCurrentUserName(String userName);

    String getCurrentUserEmail();

    void setCurrentUserEmail(String email);

    String getCurrentUserProfilePicUrl();

    void setCurrentUserProfilePicUrl(String profilePicUrl);

    String getAccessToken();

    void setAccessToken(String accessToken);
}
