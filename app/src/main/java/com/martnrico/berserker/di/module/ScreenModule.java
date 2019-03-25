package com.martnrico.berserker.di.module;

import com.martnrico.berserker.utils.DisposableManager;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Martín Rico Martínez on 08/11/2018.
 */
@Module
public abstract class ScreenModule {

    @Provides
    static DisposableManager provideDisposableManager() {
        return new DisposableManager();
    }
}
