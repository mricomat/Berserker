package com.martnrico.berserker.ui.home;

import com.martnrico.berserker.ui.base.BasePresenter;

/**
 * Created by Martín Rico Martínez on 21/11/2018.
 */
public interface HomePresenter <V extends HomeView> extends BasePresenter<V> {

    void getEntryList();

    void updateLike(boolean like, int position);

    void boardButtonAction();

    void navigateToSettings();

    void onNewWodClick();
}
