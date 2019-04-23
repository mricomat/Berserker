package com.martnrico.berserker.ui.add;

import com.martnrico.berserker.ui.add.complete.NewWodCompletePresenter;
import com.martnrico.berserker.ui.add.complete.NewWodCompletePresenterImpl;
import com.martnrico.berserker.ui.add.complete.NewWodCompleteView;
import com.martnrico.berserker.ui.add.news.exercises.NewWodExercisesPresenter;
import com.martnrico.berserker.ui.add.news.exercises.NewWodExercisesPresenterImpl;
import com.martnrico.berserker.ui.add.news.exercises.NewWodExercisesView;

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

    @Provides
    static NewWodCompletePresenter<NewWodCompleteView> bindNewWodCompletePresenter(
            NewWodCompletePresenterImpl<NewWodCompleteView> presenter) {
        return presenter;
    }
}
