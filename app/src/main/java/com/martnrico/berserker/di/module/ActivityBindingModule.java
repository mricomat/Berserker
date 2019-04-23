package com.martnrico.berserker.di.module;

import android.app.Activity;

import com.martnrico.berserker.di.ActivityScope;
import com.martnrico.berserker.di.component.HomeComponent;
import com.martnrico.berserker.ui.MainActivity;
import com.martnrico.berserker.ui.add.AddWodActivity;
import com.martnrico.berserker.ui.add.AddWodBindingScreenModule;
import com.martnrico.berserker.ui.error.ErrorActivity;
import com.martnrico.berserker.ui.home.HomeActivity;
import com.martnrico.berserker.ui.login.LoginActivity;
import com.martnrico.berserker.ui.login.LoginScreenBindingModule;
import com.martnrico.berserker.ui.splash.SplashActivity;

import dagger.Binds;
import dagger.Module;
import dagger.android.ActivityKey;
import dagger.android.AndroidInjector;
import dagger.android.ContributesAndroidInjector;
import dagger.multibindings.IntoMap;

/**
 * Created by Martín Rico Martínez on 20/11/2018.
 */
@Module(subcomponents = {
        HomeComponent.class,
})
public abstract class ActivityBindingModule {

    @ContributesAndroidInjector(modules = {
            NavigationModule.class,
    })
    @ActivityScope
    abstract MainActivity provideMainActivityInjector();

    @Binds
    @IntoMap
    @ActivityKey(HomeActivity.class)
    abstract AndroidInjector.Factory<? extends Activity> bindHomeInjector(HomeComponent.Builder builder);

    @ContributesAndroidInjector(modules = {
            LoginScreenBindingModule.class,
            ScreenModule.class,
    })
    @ActivityScope
    abstract LoginActivity provideLoginActivityInjector();

    @ContributesAndroidInjector
    @ActivityScope
    abstract SplashActivity provideSplashActivityInjector();

    @ContributesAndroidInjector
    @ActivityScope
    abstract ErrorActivity provideErrorActivityInjector();

    @ContributesAndroidInjector(modules = {
            AddWodBindingScreenModule.class,
    })
    @ActivityScope
    abstract AddWodActivity provideAddWodActivity();
}
