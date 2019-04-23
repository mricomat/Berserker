package com.martnrico.berserker.di.component;

import android.os.Bundle;

import com.martnrico.berserker.di.ScreenScope;
import com.martnrico.berserker.di.module.ScreenModule;
import com.martnrico.berserker.ui.add.previous.PreviousWodFragment;
import com.martnrico.berserker.ui.add.previous.PreviousWodScreenBindingModule;

import dagger.BindsInstance;
import dagger.Subcomponent;
import dagger.android.AndroidInjector;

/**
 * Created by Martín Rico Martínez on 19/03/2019.
 */
@ScreenScope
@Subcomponent(modules = {
        PreviousWodScreenBindingModule.class,
        ScreenModule.class,
})
public interface PreviousWodComponent extends AndroidInjector<PreviousWodFragment> {

    @Subcomponent.Builder
    abstract class Builder extends AndroidInjector.Builder<PreviousWodFragment> {

        @BindsInstance
        public abstract void bindTypeWodData(String typeWod);

        @Override
        public void seedInstance(PreviousWodFragment instance) {
            Bundle bundle = instance.getArguments();
            if (bundle != null) {
                String previousPlace = bundle.getString(PreviousWodFragment.PREVIOUS_WOD_KEY);
                bindTypeWodData(previousPlace);
            }
        }
    }
}
