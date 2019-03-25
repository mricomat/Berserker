package com.martnrico.berserker.di.component;

import android.os.Bundle;

import com.martnrico.berserker.data.network.model.HomeDataModel;
import com.martnrico.berserker.di.module.ContextModule;
import com.martnrico.berserker.di.module.EntryItemModule;
import com.martnrico.berserker.ui.home.HomeScreenBindingModule;
import com.martnrico.berserker.di.module.ScreenModule;
import com.martnrico.berserker.di.ScreenScope;
import com.martnrico.berserker.ui.home.HomeActivity;

import dagger.BindsInstance;
import dagger.Subcomponent;
import dagger.android.AndroidInjector;

/**
 * Created by Martín Rico Martínez on 13/12/2018.
 */
@ScreenScope
@Subcomponent(modules = {
        ScreenModule.class,
        EntryItemModule.class,
        ContextModule.class,
        HomeScreenBindingModule.class,
})
public interface HomeComponent extends AndroidInjector<HomeActivity>{

    @Subcomponent.Builder
    abstract class Builder extends AndroidInjector.Builder<HomeActivity> {

        public abstract Builder contextModule(ContextModule contextModule);

        @BindsInstance
        public abstract void bindHomeDataModel(HomeDataModel homeData);

        @Override
        public void seedInstance(HomeActivity instance){
            Bundle bundle = instance.getIntent().getExtras();
            if (bundle != null) {
                HomeDataModel homeData = bundle.getParcelable(HomeActivity.HOME_DATA_KEY);
                bindHomeDataModel(homeData);
            }
            contextModule(new ContextModule(instance));
        }
    }
}
