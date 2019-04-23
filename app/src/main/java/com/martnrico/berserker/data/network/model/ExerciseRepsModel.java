package com.martnrico.berserker.data.network.model;

/**
 * Created by Martín Rico Martínez on 23/04/2019.
 */
public class ExerciseRepsModel {

    private String mNameExercise;
    private int mReps;

    public ExerciseRepsModel(String nameExercise, int reps) {
        mNameExercise = nameExercise;
        mReps = reps;
    }

    public String getNameExercise() {
        return mNameExercise;
    }

    public void setNameExercise(String nameExercise) {
        mNameExercise = nameExercise;
    }

    public int getReps() {
        return mReps;
    }

    public void setReps(int reps) {
        mReps = reps;
    }
}
