package com.martnrico.berserker.di.module;

import com.martnrico.berserker.ui.ScreenNavigator;
import com.martnrico.berserker.ui.ScreenNavigatorImpl;

import dagger.Binds;
import dagger.Module;

/**
 * Created by Martín Rico Martínez on 20/11/2018.
 */
@Module
public abstract class NavigationModule {

    @Binds
    abstract ScreenNavigator provideScreenNavigator(ScreenNavigatorImpl screenNavigator);

}
