package com.martnrico.berserker.ui.login;

import com.martnrico.berserker.di.PerActivity;
import com.martnrico.berserker.ui.base.BasePresenter;

/**
 * Created by Martín Rico Martínez on 20/11/2018.
 */
@PerActivity
public interface LoginPresenter<V extends LoginView> extends BasePresenter<V> {

    void onSignInClick(String email, String password);

    void onForgotPassClick();

}
