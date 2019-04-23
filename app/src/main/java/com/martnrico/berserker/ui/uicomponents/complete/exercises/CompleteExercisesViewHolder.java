package com.martnrico.berserker.ui.uicomponents.complete.exercises;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.martnrico.berserker.R;
import com.martnrico.berserker.utils.ItemClickListener;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Martín Rico Martínez on 08/04/2019.
 */
public class CompleteExercisesViewHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.name_exercise_text)
    TextView mNameExercise;

    @BindView(R.id.options_button)
    ImageView mOptionsButton;

    @BindView(R.id.round_container)
    LinearLayout mRoundContainer;

    @BindView(R.id.round_title)
    TextView mRoundTitle;

    @BindView(R.id.data_item_container)
    RelativeLayout mDataItemContainer;

    private ItemClickListener mOptionsListener;

    public CompleteExercisesViewHolder(@NonNull View itemView, ItemClickListener optionsListener) {
        super(itemView);
        ButterKnife.bind(this, itemView);
        mOptionsListener = optionsListener;
    }

    public void onBind(String nameExercise, final int position) {
        if (!nameExercise.contains("Round: ")) {
            mNameExercise.setText(nameExercise);

            mOptionsButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mOptionsListener.onItemClick(itemView, position);
                }
            });
        } else {
            setRound(nameExercise);
        }

    }

    private void setRound(String nameExercise) {
        mDataItemContainer.setVisibility(View.GONE);
        mRoundContainer.setVisibility(View.VISIBLE);
        mRoundTitle.setText(nameExercise);
    }
}
