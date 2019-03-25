package com.martnrico.berserker.data;

import com.martnrico.berserker.data.network.ServiceHelper;
import com.martnrico.berserker.data.prefs.PreferencesHelper;

/**
 * Created by Martín Rico Martínez on 19/11/2018.
 */
public interface DataManager extends PreferencesHelper, ServiceHelper {

    void setUserAsLoggedOut();

    void updateUserInfo(
            String accessToken,
            Long userId,
            LoggedInMode loggedInMode,
            String userName,
            String email,
            String profilePicPath);

    enum LoggedInMode {
        LOGGED_IN_MODE_LOGGED_OUT(0),
        LOGGED_IN_MODE_SERVER(1);

        private final int mType;

        LoggedInMode(int type) {
            mType = type;
        }

        public int getType() {
            return mType;
        }
    }
}
