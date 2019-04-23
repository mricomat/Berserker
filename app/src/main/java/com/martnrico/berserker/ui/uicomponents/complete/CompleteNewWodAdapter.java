package com.martnrico.berserker.ui.uicomponents.complete;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import com.martnrico.berserker.data.network.model.Entry.WodModel;

import java.util.List;

/**
 * Created by Martín Rico Martínez on 14/04/2019.
 */
public class CompleteNewWodAdapter extends RecyclerView.Adapter<CompleteNewWodViewHolder> {

    private CompleteNewWodListener mCompleteNewWodListener;
    private List<WodModel> mWodList;

    public CompleteNewWodAdapter(List<WodModel> wodList, CompleteNewWodListener completeNewWodListener) {
        mWodList = wodList;
        mCompleteNewWodListener = completeNewWodListener;
    }

    @NonNull
    @Override
    public CompleteNewWodViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        CompleteNewWodComponent completeNewWodComponent = new CompleteNewWodComponent(viewGroup.getContext());
        return new CompleteNewWodViewHolder(completeNewWodComponent);
    }

    @Override
    public void onBindViewHolder(@NonNull CompleteNewWodViewHolder completeNewWodViewHolder, int position) {
        completeNewWodViewHolder.onBind(mWodList.get(position), mCompleteNewWodListener);
    }

    @Override
    public int getItemCount() {
        return mWodList == null ? 0 : mWodList.size();
    }

    public void addWodList(List<WodModel> wodList) {
        mWodList.addAll(wodList);
        notifyDataSetChanged();
    }

    public void addWodModel(WodModel wodModel) {
        mWodList.add(wodModel);
        notifyDataSetChanged();
    }
}
