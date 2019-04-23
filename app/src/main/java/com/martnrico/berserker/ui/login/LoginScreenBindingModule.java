package com.martnrico.berserker.ui.login;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Martín Rico Martínez on 20/11/2018.
 */
@Module
public abstract class LoginScreenBindingModule {

    @Provides
    static LoginPresenter<LoginView> bindListPresenter(LoginPresenterImpl<LoginView> presenter) {
        return presenter;
    }
}
