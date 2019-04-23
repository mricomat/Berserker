package com.martnrico.berserker.ui.addwod;

import android.support.v4.app.Fragment;

import com.martnrico.berserker.di.component.NewWodExercisesComponent;
import com.martnrico.berserker.di.component.PreviousWodComponent;
import com.martnrico.berserker.ui.addwod.complete.NewWodCompleteFragment;
import com.martnrico.berserker.ui.addwod.news.NewWodTypeWodListFragment;
import com.martnrico.berserker.ui.addwod.news.exercises.NewWodExercisesListFragment;
import com.martnrico.berserker.ui.addwod.previous.PreviousWodFragment;

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

    @ContributesAndroidInjector
    abstract NewWodTypeWodListFragment provideNewWodTypeWodListFragmentInjector();

    @Binds
    @IntoMap
    @FragmentKey(PreviousWodFragment.class)
    abstract AndroidInjector.Factory<? extends Fragment> bindPreviousWodFragmentInjector(PreviousWodComponent.Builder builder);

    @ContributesAndroidInjector
    abstract NewWodCompleteFragment provideNewWodCompleteFragmentInjector();

}
