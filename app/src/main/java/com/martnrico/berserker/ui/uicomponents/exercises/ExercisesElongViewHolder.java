package com.martnrico.berserker.ui.uicomponents.exercises;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.martnrico.berserker.R;
import com.martnrico.berserker.data.network.model.ExerciseModel;
import com.martnrico.berserker.utils.ItemClickListener;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Martín Rico Martínez on 11/03/2019.
 */
public class ExercisesElongViewHolder extends RecyclerView.ViewHolder {


    @BindView(R.id.exercise_title)
    TextView mExerciseTitle;

    @BindView(R.id.exercise_detail)
    TextView mExerciseDetail;

    @BindView(R.id.exercise_background)
    ImageView mExerciseBackgroun;

    private View mItemView;

    public ExercisesElongViewHolder(@NonNull View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);

        this.mItemView = itemView;
    }

    private void clear() {
        mExerciseTitle.setText("");
        mExerciseDetail.setText("");
    }

    public void onBind(ExerciseModel exerciseModel, final int position, final ItemClickListener itemClickListener) {
        clear();

        mExerciseTitle.setText(exerciseModel.getName());
        mExerciseDetail.setText(exerciseModel.getDescription());

        //mExerciseBackgroun.setIma...

        mItemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                itemClickListener.onItemClick(view, position);
            }
        });
    }
}
