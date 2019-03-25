package com.martnrico.berserker.ui.addwod.news.exercises;

import com.martnrico.berserker.data.network.model.ExerciseModel;
import com.martnrico.berserker.ui.base.BaseView;

import java.util.List;

/**
 * Created by Martín Rico Martínez on 11/03/2019.
 */
public interface NewWodExercisesView extends BaseView {

    void showExercisesList(List<ExerciseModel> mExerciseList);

    void changeTitleBar(String typeWod);
}
