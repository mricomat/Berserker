package com.martnrico.berserker.ui.uicomponents.exercises;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.martnrico.berserker.R;
import com.martnrico.berserker.data.network.model.ExerciseModel;
import com.martnrico.berserker.utils.ItemClickListener;
import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Martín Rico Martínez on 18/03/2019.
 */
public class ExercisesSquareViewHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.exercise_title)
    TextView mExerciseTitle;

    @BindView(R.id.exercise_background)
    ImageView mExerciseBackground;

    private View mItemView;

    public ExercisesSquareViewHolder(@NonNull View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);

        this.mItemView = itemView;
    }

    private void clear() {
        mExerciseTitle.setText("");
    }

    public void onBind(ExerciseModel exerciseModel, final int position, final ItemClickListener itemClickListener) {
        clear();

        mExerciseTitle.setText(exerciseModel.getName());

        Picasso.get().load(exerciseModel.getUrlBackgroundImg()).into(mExerciseBackground);
        mItemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                itemClickListener.onItemClick(view, position);
            }
        });
    }
}
