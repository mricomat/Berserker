package com.martnrico.berserker.ui.uicomponents.complete.exercises;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.martnrico.berserker.R;
import com.martnrico.berserker.utils.ItemClickListener;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Martín Rico Martínez on 08/04/2019.
 */
public class CompleteExercisesAdapter extends RecyclerView.Adapter<CompleteExercisesViewHolder> {

    private List<String> mNameExerciseList;
    private List<String> mOriginNameExerciseList = new ArrayList<>();
    private ItemClickListener mOptionsListener;
    private int mRounds = 0;

    public CompleteExercisesAdapter(List<String> nameExerciseList, ItemClickListener optionsListener) {
        mNameExerciseList = nameExerciseList;
        mOptionsListener = optionsListener;
    }

    @NonNull
    @Override
    public CompleteExercisesViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.complete_exercises_item, viewGroup, false);
        return new CompleteExercisesViewHolder(view, mOptionsListener);
    }

    @Override
    public void onBindViewHolder(@NonNull CompleteExercisesViewHolder completeExercisesViewHolder, int position) {
        completeExercisesViewHolder.onBind(mNameExerciseList.get(position), position);
    }

    @Override
    public int getItemCount() {
        return mNameExerciseList == null ? 0 : mNameExerciseList.size();
    }

    public void setExerciseList(List<String> nameExerciseList) {
        mNameExerciseList = nameExerciseList;
        notifyDataSetChanged();
    }

    public void addNewRound() {
        if (!mNameExerciseList.get(0).equals("Round: 1")) {
            mOriginNameExerciseList = mNameExerciseList;
            mNameExerciseList = new ArrayList<>();
            mNameExerciseList.add("Round: " + ++mRounds);
            mNameExerciseList.addAll(mOriginNameExerciseList);
            mNameExerciseList.add("Round: " + ++mRounds);
            mNameExerciseList.addAll(mOriginNameExerciseList);
        } else {
            mNameExerciseList.add("Round: " + ++mRounds);
            mNameExerciseList.addAll(mOriginNameExerciseList);
        }
        notifyDataSetChanged();
    }
}
