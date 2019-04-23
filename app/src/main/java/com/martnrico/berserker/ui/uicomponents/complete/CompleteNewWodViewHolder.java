package com.martnrico.berserker.ui.uicomponents.complete;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.martnrico.berserker.data.network.model.Entry.WodModel;
import com.martnrico.berserker.utils.ItemClickListener;

import java.util.List;

import butterknife.ButterKnife;

/**
 * Created by Martín Rico Martínez on 14/04/2019.
 */
public class CompleteNewWodViewHolder extends RecyclerView.ViewHolder {

    private CompleteNewWodComponent mCompleteNewWodComponent;

    public CompleteNewWodViewHolder(@NonNull View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
        mCompleteNewWodComponent = (CompleteNewWodComponent) itemView;
    }

    private void clear() {

    }

    public void onBind(WodModel wodModel, final CompleteNewWodListener completeNewWodListener){
        mCompleteNewWodComponent.setExerciseList(wodModel.getExerciseList());
        mCompleteNewWodComponent.setTypeWod(wodModel.getTypeWod());

        mCompleteNewWodComponent.setOptionsButtonListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                completeNewWodListener.onOptionsButtonClicked();
            }
        });

        mCompleteNewWodComponent.setOptionsExerciseListener(new ItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                completeNewWodListener.onOptionsExerciseClicked(position);
            }
        });
    }
}
