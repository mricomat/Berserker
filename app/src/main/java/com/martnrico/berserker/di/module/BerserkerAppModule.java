package com.martnrico.berserker.di.module;

import android.app.Application;
import android.content.Context;

import com.martnrico.berserker.BerserkerApplication;
import com.martnrico.berserker.data.AppDataManager;
import com.martnrico.berserker.data.DataManager;
import com.martnrico.berserker.data.prefs.AppPreferencesHelper;
import com.martnrico.berserker.data.prefs.PreferencesHelper;
import com.martnrico.berserker.di.ApplicationContext;
import com.martnrico.berserker.di.PreferenceInfo;
import com.martnrico.berserker.utils.AppConstants;

import javax.inject.Singleton;

import dagger.Binds;
import dagger.Module;
import dagger.Provides;

/**
 * Created by Martín Rico Martínez on 20/11/2018.
 */
@Module
public abstract class BerserkerAppModule {

    @Binds
   abstract Application mApplication(BerserkerApplication application);

    @Provides
    @ApplicationContext
    static Context provideApplicationContext(Application application) {
        return application;
    }

    @Provides
    @Singleton
    static DataManager provideDataManager(AppDataManager appDataManager) {
        return appDataManager;
    }

    @Provides
    @Singleton
    static PreferencesHelper providePreferencesHelper(AppPreferencesHelper appPreferencesHelper) {
        return appPreferencesHelper;
    }

    @Provides
    @PreferenceInfo
    static String providePreferenceName() {
        return AppConstants.PREF_NAME;
    }

}
