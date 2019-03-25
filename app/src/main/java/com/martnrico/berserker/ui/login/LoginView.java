package com.martnrico.berserker.ui.login;

import com.martnrico.berserker.data.network.model.HomeDataModel;
import com.martnrico.berserker.data.network.model.UserModel;
import com.martnrico.berserker.ui.base.BaseView;

/**
 * Created by Martín Rico Martínez on 20/11/2018.
 */
public interface LoginView extends BaseView {

    void showFadeIn();

    void showLoading();

    void hideLoading();

    void showForgotPassDialog();

    void showEmailInputError(int error);

    void showPasswordInputError(int error);

    void navigateToHomeActivity(HomeDataModel homeData);

}
