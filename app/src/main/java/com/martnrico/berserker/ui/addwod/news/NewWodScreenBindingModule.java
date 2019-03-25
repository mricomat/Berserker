package com.martnrico.berserker.ui.addwod.news;

import com.martnrico.berserker.ui.addwod.news.exercises.NewWodExercisesPresenter;
import com.martnrico.berserker.ui.addwod.news.exercises.NewWodExercisesPresenterImpl;
import com.martnrico.berserker.ui.addwod.news.exercises.NewWodExercisesView;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Martín Rico Martínez on 11/03/2019.
 */
@Module
public abstract class NewWodScreenBindingModule {

    @Provides
    static NewWodExercisesPresenter<NewWodExercisesView> bindNewWodExercisesPresenter(
            NewWodExercisesPresenterImpl<NewWodExercisesView> presenter) {
        return presenter;
    }
}
