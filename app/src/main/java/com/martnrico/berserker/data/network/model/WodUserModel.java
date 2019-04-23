package com.martnrico.berserker.data.network.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Martín Rico Martínez on 23/04/2019.
 */
public class WodUserModel {

    private Long mId;
    private Long mDate;
    private String mTypeWod;

    private String mResultWod;

    private String mLevelWod;

    private boolean mIsCompleted;

    private List<ExerciseRepsModel> mExerciseRepsList = new ArrayList<>();

    public WodUserModel() {

    }

    public Long getId() {
        return mId;
    }

    public void setId(Long id) {
        mId = id;
    }

    public Long getDate() {
        return mDate;
    }

    public void setDate(Long date) {
        mDate = date;
    }

    public String getTypeWod() {
        return mTypeWod;
    }

    public void setTypeWod(String typeWod) {
        mTypeWod = typeWod;
    }

    public String getResultWod() {
        return mResultWod;
    }

    public void setResultWod(String resultWod) {
        mResultWod = resultWod;
    }

    public String getLevelWod() {
        return mLevelWod;
    }

    public void setLevelWod(String levelWod) {
        mLevelWod = levelWod;
    }

    public boolean isCompleted() {
        return mIsCompleted;
    }

    public void setCompleted(boolean completed) {
        mIsCompleted = completed;
    }

    public List<ExerciseRepsModel> getExerciseRepsList() {
        return mExerciseRepsList;
    }

    public void setExerciseRepsList(List<ExerciseRepsModel> exerciseRepsList) {
        mExerciseRepsList = exerciseRepsList;
    }
}
