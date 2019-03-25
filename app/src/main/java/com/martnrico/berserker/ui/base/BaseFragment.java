package com.martnrico.berserker.ui.base;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.View;

import dagger.android.AndroidInjection;
import dagger.android.support.AndroidSupportInjection;
import dagger.android.support.DaggerFragment;

/**
 * Created by Martín Rico Martínez on 19/11/2018.
 */
public abstract class BaseFragment extends DaggerFragment implements BaseView {

    private BaseActivity mActivity;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        fillViews(view);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof BaseActivity) {
            this.mActivity = (BaseActivity) context;
        }
    }

    @Override
    public void openErrorActivity(Throwable error) {
        if(mActivity != null) {
            mActivity.openErrorActivity(error);
        }
    }

    @Override
    public void onDetach() {
        mActivity = null;
        super.onDetach();
    }

    @Override
    public void openLoginOnTokenExpire() {
        if(mActivity != null) {
            mActivity.openLoginOnTokenExpire();
        }
    }

    protected abstract void fillViews(View view);

    public BaseActivity getBaseActivity() {
        return mActivity;
    }
}
