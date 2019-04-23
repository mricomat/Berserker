package com.martnrico.berserker.ui.add;

import android.support.v4.app.Fragment;

import com.martnrico.berserker.di.component.NewWodExercisesComponent;
import com.martnrico.berserker.di.component.PreviousWodComponent;
import com.martnrico.berserker.di.module.ScreenModule;
import com.martnrico.berserker.ui.add.complete.NewWodCompleteFragment;
import com.martnrico.berserker.ui.add.news.NewWodTypeListFragment;
import com.martnrico.berserker.ui.add.news.exercises.NewWodExercisesListFragment;
import com.martnrico.berserker.ui.add.previous.PreviousWodFragment;

import dagger.Binds;
import dagger.Module;
import dagger.android.AndroidInjector;
import dagger.android.ContributesAndroidInjector;
import dagger.android.support.FragmentKey;
import dagger.multibindings.IntoMap;

/**
 * Created by Martín Rico Martínez on 14/03/2019.
 */
@Module(subcomponents = {
        NewWodExercisesComponent.class,
        PreviousWodComponent.class,
})
public abstract class AddWodBindingScreenModule {

    @Binds
    @IntoMap
    @FragmentKey(NewWodExercisesListFragment.class)
    abstract AndroidInjector.Factory<? extends Fragment> bindNewWodExercisesFragmentInjector(NewWodExercisesComponent.Builder builder);

    @ContributesAndroidInjector(modules = {
            NewWodScreenBindingModule.class,
            ScreenModule.class,
    })
    abstract NewWodCompleteFragment provideNewWodCompleteFragmentInjector();

    @ContributesAndroidInjector
    abstract NewWodTypeListFragment provideNewWodTypeWodListFragmentInjector();

    @Binds
    @IntoMap
    @FragmentKey(PreviousWodFragment.class)
    abstract AndroidInjector.Factory<? extends Fragment> bindPreviousWodFragmentInjector(PreviousWodComponent.Builder builder);

}
