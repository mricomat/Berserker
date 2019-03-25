package com.martnrico.berserker.ui.splash;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;

import com.martnrico.berserker.R;
import com.martnrico.berserker.data.DataManager;
import com.martnrico.berserker.data.network.model.HomeDataModel;
import com.martnrico.berserker.data.network.model.UserModel;
import com.martnrico.berserker.ui.base.BaseActivity;
import com.martnrico.berserker.ui.home.HomeActivity;

import javax.inject.Inject;

/**
 * Created by Martín Rico Martínez on 19/11/2018.
 */
public class SplashActivity extends BaseActivity {

    @Inject
    DataManager mDataManager;

    public static Intent getStartIntent(Context context) {
        return new Intent(context, SplashActivity.class);
    }

    @Override
    protected int layoutRes() {
        return R.layout.splash_activity;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Handler handler = new Handler(); // TODO DELETE
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                navigateToHomeActivity();
            }
        }, 2000);
    }

    private void navigateToHomeActivity() {
        Intent intent = new Intent(this, HomeActivity.class);
        intent.putExtra(HomeActivity.HOME_DATA_KEY, new HomeDataModel(fillUserData()));
        startActivity(intent);
        finish();
    }

    private UserModel fillUserData() {
        UserModel userModel = new UserModel();
        userModel.setUserName(mDataManager.getCurrentUserName());
        userModel.setUserId(mDataManager.getCurrentUserId());
        userModel.setUserEmail(mDataManager.getCurrentUserEmail());
        userModel.setProfilePicUrl(mDataManager.getCurrentUserProfilePicUrl());
        return userModel;
    }
}
