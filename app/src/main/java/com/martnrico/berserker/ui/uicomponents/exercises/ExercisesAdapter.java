package com.martnrico.berserker.ui.uicomponents.exercises;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.martnrico.berserker.R;
import com.martnrico.berserker.data.network.model.ExerciseModel;
import com.martnrico.berserker.utils.ItemClickListener;

import java.util.List;

/**
 * Created by Martín Rico Martínez on 11/03/2019.
 */
public class ExercisesAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<ExerciseModel> mExerciseList;
    private ItemClickListener mClickListener;
    private boolean mIsSquareLayout = false;

    public ExercisesAdapter(List<ExerciseModel> exerciseList, ItemClickListener itemClickListener) {
        this.mExerciseList = exerciseList;
        this.mClickListener = itemClickListener;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view;
        if (viewType == R.layout.exercise_list_elong_item) {
            view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.exercise_list_elong_item, viewGroup, false);
            return new ExercisesElongViewHolder(view);
        } else {
            view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.exercises_list_square_item, viewGroup, false);
            return new ExercisesSquareViewHolder(view);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int position) {
        if (viewHolder instanceof ExercisesElongViewHolder) {
            ((ExercisesElongViewHolder) viewHolder).onBind(mExerciseList.get(position), position, mClickListener);
        } else if (viewHolder instanceof ExercisesSquareViewHolder) {
            ((ExercisesSquareViewHolder) viewHolder).onBind(mExerciseList.get(position), position, mClickListener);
        }
    }

    @Override
    public int getItemViewType(int position) {
        return mIsSquareLayout ? R.layout.exercises_list_square_item : R.layout.exercise_list_elong_item;
    }

    @Override
    public int getItemCount() {
        return mExerciseList == null ? 0 : mExerciseList.size();
    }

    public void setSquareLayout(boolean isSquareLayout) {
        mIsSquareLayout = isSquareLayout;
    }

    public boolean isSquareLayout() {
        return mIsSquareLayout;
    }

    public void setExerciseList(List<ExerciseModel> exerciseList) {
        mExerciseList = exerciseList;
        notifyDataSetChanged();
    }
}
