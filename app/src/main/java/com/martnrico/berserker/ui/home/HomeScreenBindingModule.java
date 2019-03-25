package com.martnrico.berserker.ui.home;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Martín Rico Martínez on 13/12/2018.
 */
@Module
public abstract class HomeScreenBindingModule {

    @Provides
    static HomePresenter<HomeView> bindHomePresenter(HomePresenterImpl<HomeView> presenter) {
        return presenter;
    }

}
