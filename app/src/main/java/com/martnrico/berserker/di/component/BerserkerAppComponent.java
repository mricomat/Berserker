package com.martnrico.berserker.di.component;

import com.martnrico.berserker.BerserkerApplication;
import com.martnrico.berserker.di.module.ActivityBindingModule;
import com.martnrico.berserker.di.module.BerserkerAppModule;
import com.martnrico.berserker.di.module.ServiceModule;

import javax.inject.Singleton;

import dagger.Component;
import dagger.android.AndroidInjector;
import dagger.android.support.AndroidSupportInjectionModule;

/**
 * Created by Martín Rico Martínez on 19/11/2018.
 */
@Singleton
@Component(modules = {
        BerserkerAppModule.class,
        ActivityBindingModule.class,
        ServiceModule.class,
        AndroidSupportInjectionModule.class
})
public interface BerserkerAppComponent extends AndroidInjector<BerserkerApplication> {

    // void inject(BerserkerApplication berserkerApplication);

    @Component.Builder
    abstract class Builder extends AndroidInjector.Builder<BerserkerApplication> {
    }
}
