package com.martnrico.berserker.di.component;

import android.os.Bundle;

import com.martnrico.berserker.ui.addwod.news.NewWodScreenBindingModule;
import com.martnrico.berserker.di.module.ScreenModule;
import com.martnrico.berserker.di.ScreenScope;
import com.martnrico.berserker.ui.addwod.news.exercises.NewWodExercisesListFragment;

import dagger.BindsInstance;
import dagger.Subcomponent;
import dagger.android.AndroidInjector;

/**
 * Created by Martín Rico Martínez on 11/03/2019.
 */
@ScreenScope
@Subcomponent(modules = {
        NewWodScreenBindingModule.class,
        ScreenModule.class,
})
public interface NewWodExercisesComponent extends AndroidInjector<NewWodExercisesListFragment> {

    @Subcomponent.Builder
    abstract class Builder extends AndroidInjector.Builder<NewWodExercisesListFragment> {

        @BindsInstance
        public abstract void bindTypeWodData(String typeWod);

        @Override
        public void seedInstance(NewWodExercisesListFragment instance) {
            Bundle bundle = instance.getArguments();
            if (bundle != null) {
                String typeWod = bundle.getString(NewWodExercisesListFragment.EXERCISES_LIST_KEY);
                bindTypeWodData(typeWod);
            }
        }
    }
}
