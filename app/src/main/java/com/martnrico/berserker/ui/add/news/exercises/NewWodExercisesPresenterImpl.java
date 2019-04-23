package com.martnrico.berserker.ui.addwod.news.exercises;

import com.martnrico.berserker.data.DataManager;
import com.martnrico.berserker.data.network.model.Entry.WodModel;
import com.martnrico.berserker.data.network.model.ExerciseModel;
import com.martnrico.berserker.ui.base.BasePresenterImpl;
import com.martnrico.berserker.utils.DisposableManager;
import com.martnrico.berserker.utils.MockData;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.inject.Inject;

/**
 * Created by Martín Rico Martínez on 11/03/2019.
 */
public class NewWodExercisesPresenterImpl<V extends NewWodExercisesView> extends BasePresenterImpl<V> implements NewWodExercisesPresenter<V> {

    private String mTypeWod;

    private List<ExerciseModel> mExerciseList = new ArrayList<>();
    private List<String> mExercisesNamesSelected = new ArrayList<>();

    @Inject
    public NewWodExercisesPresenterImpl(String typeWod, DataManager dataManager, DisposableManager disposableManager) {
        super(dataManager, disposableManager);
        this.mTypeWod = typeWod;
    }

    @Override
    public void onAttach(V view) {
        super.onAttach(view);
        getMvpView().changeTitleBar(mTypeWod);
        getExercisesList();
    }

    @Override
    public void getExercisesList() {
        // TODO
        mExerciseList = MockData.getMockExercises();
        getMvpView().showExercisesList(mExerciseList);
    }

    @Override
    public void exerciseSelected(int position) {
        String exerciseName = mExerciseList.get(position).getName();
        if (mExercisesNamesSelected.contains(exerciseName)) {
            mExercisesNamesSelected.remove(exerciseName);
        } else {
            mExercisesNamesSelected.add(exerciseName);
        }
    }

    @Override
    public void onConfirmationButtonClick() {
        WodModel wodModel = new WodModel();
        wodModel.setTypeWod(mTypeWod);
        wodModel.setDate(Calendar.getInstance().getTimeInMillis());
        wodModel.setExerciseList(mExercisesNamesSelected);

        getMvpView().navigateToCompleteNewWodFragment(wodModel);
    }

    @Override
    public void changeRecyclerItemView() {

    }
}
