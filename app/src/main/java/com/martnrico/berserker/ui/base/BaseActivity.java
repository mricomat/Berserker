package com.martnrico.berserker.ui.base;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;

import com.martnrico.berserker.ui.error.ErrorActivity;
import com.martnrico.berserker.ui.login.LoginActivity;

import java.util.UUID;

import butterknife.ButterKnife;
import dagger.android.AndroidInjection;
import dagger.android.support.DaggerAppCompatActivity;

/**
 * Created by Martín Rico Martínez on 19/11/2018.
 */
public abstract class BaseActivity extends DaggerAppCompatActivity implements BaseView{

    private static String INSTANCE_ID_KEY = "instance_id";

    private String mInstanceId;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        if (savedInstanceState != null) {
            mInstanceId = savedInstanceState.getString(INSTANCE_ID_KEY);
        } else {
            mInstanceId = UUID.randomUUID().toString();
        }

        //AndroidInjection.inject(this);
        super.onCreate(savedInstanceState);

        setContentView(layoutRes());
        ButterKnife.bind(this);
        onViewBound();
        /*ViewGroup screenContainer = findViewById(R.id.screen_container);
        if (screenContainer == null) {
            throw new NullPointerException("Activity must have a view with id: screen_container");
        }*/
    }

    @Override
    public void openLoginOnTokenExpire() {
        startActivity(LoginActivity.getStartIntent(this));
        finish();
    }

    @Override
    public void openErrorActivity(Throwable error) {
        startActivity(ErrorActivity.getStartIntent(this, error));
    }

    protected void onViewBound() {

    }

    protected void setListeners() {

    }

    @Override
    public void onBackPressed() {
        int count = getFragmentManager().getBackStackEntryCount();

        if (count == 0) {
            super.onBackPressed();
            getFragmentManager().popBackStack();
        } else {
            getFragmentManager().popBackStack();
        }
    }

    @Override
    public void onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState) {
        super.onSaveInstanceState(outState, outPersistentState);
        outState.putString(INSTANCE_ID_KEY, mInstanceId);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    public void startActivityFromFragment(Fragment fragment, Intent intent, int requestCode) {
        super.startActivityFromFragment(fragment, intent, requestCode);
    }

    @LayoutRes
    protected abstract int layoutRes();

    public String getInstanceId() {
        return this.mInstanceId;
    }
}
