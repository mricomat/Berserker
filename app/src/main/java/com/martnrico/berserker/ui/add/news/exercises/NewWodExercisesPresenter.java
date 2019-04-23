package com.martnrico.berserker.ui.add.news.exercises;

import com.martnrico.berserker.ui.base.BasePresenter;

/**
 * Created by Martín Rico Martínez on 11/03/2019.
 */
public interface NewWodExercisesPresenter<V extends NewWodExercisesView> extends BasePresenter<V> {

    void getExercisesList();

    void exerciseSelected(int position);

    void onConfirmationButtonClick();

    void changeRecyclerItemView();
}
