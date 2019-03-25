package com.martnrico.berserker;

import android.app.Activity;
import android.app.Application;

import com.martnrico.berserker.di.component.DaggerBerserkerAppComponent;

import javax.inject.Inject;

import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.HasActivityInjector;
import dagger.android.support.HasSupportFragmentInjector;


/**
 * Created by Martín Rico Martínez on 19/11/2018.
 */
public class BerserkerApplication extends Application implements HasSupportFragmentInjector, HasActivityInjector {

    @Inject
    DispatchingAndroidInjector<Activity> mActivityInjector;

    @Inject
    DispatchingAndroidInjector<android.support.v4.app.Fragment> mFragmentInjector;

    @Override
    public void onCreate() {
        super.onCreate();
        DaggerBerserkerAppComponent.builder().create(this).inject(this);
    }

    @Override
    public AndroidInjector<Activity> activityInjector() {
        return mActivityInjector;
    }

    @Override
    public AndroidInjector<android.support.v4.app.Fragment> supportFragmentInjector() {
        return mFragmentInjector;
    }
}
