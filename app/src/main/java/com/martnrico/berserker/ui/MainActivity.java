package com.martnrico.berserker.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.martnrico.berserker.R;
import com.martnrico.berserker.data.DataManager;
import com.martnrico.berserker.ui.base.BaseActivity;
import com.martnrico.berserker.ui.login.LoginActivity;
import com.martnrico.berserker.ui.splash.SplashActivity;

import javax.inject.Inject;

public class MainActivity extends BaseActivity {

    @Inject
    DataManager mDataManager;

    @Inject
    ScreenNavigator mScreenNavigator;

    @Override
    protected int layoutRes() {
        return R.layout.main_activity;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        decideNextActivity();
    }

    private void decideNextActivity() {
        if (mDataManager.getCurrentUserLoggedInMode()
                == DataManager.LoggedInMode.LOGGED_IN_MODE_LOGGED_OUT.getType()) {
            mScreenNavigator.navigateToActivity(this, LoginActivity.class, null, true);
        } else {
            startActivity(SplashActivity.getStartIntent(this));
        }
        finish();
    }
}
