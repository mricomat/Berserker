package com.martnrico.berserker.ui.uicomponents.scaleditem;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.martnrico.berserker.R;

import java.util.List;

/**
 * Created by Martín Rico Martínez on 18/12/2018.
 */
public class ScaledAdapter extends RecyclerView.Adapter<ScaledViewHolder>{

    private List<String> mExerciseList;

    public ScaledAdapter(List<String> exerciseList) {
        this.mExerciseList = exerciseList;
    }

    @NonNull
    @Override
    public ScaledViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.scaled_item_list,
                viewGroup, false);
        return new ScaledViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ScaledViewHolder holder, int position) {
        if (mExerciseList != null && !mExerciseList.isEmpty()) {
            holder.onBind(mExerciseList.get(position));
        }
    }

    @Override
    public int getItemCount() {
        return mExerciseList == null ? 0 : mExerciseList.size();
    }

    public void addItems(List<String> exercises) {
        clearList();
        mExerciseList.addAll(exercises);
        notifyDataSetChanged();
    }

    public void clearList() {
        mExerciseList.clear();
        notifyDataSetChanged();
    }
}
