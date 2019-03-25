package com.martnrico.berserker.ui.base;

/**
 * Created by Martín Rico Martínez on 19/11/2018.
 */
public interface BaseView {

    void openErrorActivity(Throwable error);

    void openLoginOnTokenExpire();

}
