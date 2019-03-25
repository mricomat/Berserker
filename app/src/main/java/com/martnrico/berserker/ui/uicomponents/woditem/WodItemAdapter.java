package com.martnrico.berserker.ui.uicomponents.woditem;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.martnrico.berserker.R;

import java.util.List;

/**
 * Created by Martín Rico Martínez on 28/11/2018.
 */
public class WodItemAdapter extends RecyclerView.Adapter<WodItemViewHolder> {

    private List<String> mExerciseList;

    public WodItemAdapter(List<String> exerciseList) {
        this.mExerciseList = exerciseList;
    }

    @NonNull
    @Override
    public WodItemViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.wod_item_list,
                viewGroup, false);
        return new WodItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull WodItemViewHolder holder, int position) {
        if (mExerciseList != null && !mExerciseList.isEmpty()) {
            holder.onBind(mExerciseList.get(position));
        }
    }

    @Override
    public int getItemCount() {
        if (mExerciseList != null && mExerciseList.size() > 0) {
            return mExerciseList.size();
        } else {
            return 1;
        }
    }

    public void addItems(List<String> exercises) {
        mExerciseList.addAll(exercises);
        notifyDataSetChanged();
    }

    public void clearList() {
        mExerciseList.clear();
        notifyDataSetChanged();
    }
}
