package com.martnrico.berserker.ui.uicomponents.scaleditem;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.martnrico.berserker.R;
import com.martnrico.berserker.utils.StringUtils;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Martín Rico Martínez on 18/12/2018.
 */
public class ScaledViewHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.name_exe_text)
    TextView mExerciseName;

    public ScaledViewHolder(@NonNull View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    private void clear() {
        mExerciseName.setText(StringUtils.EMPTY_STRING);
    }

    public void onBind(String exercise) {
        clear();
        mExerciseName.setText(exercise);
    }
}
