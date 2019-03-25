package com.martnrico.berserker.ui.uicomponents.entryitem;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import com.martnrico.berserker.data.network.model.Entry.EntryModel;
import com.martnrico.berserker.ui.home.HomePresenter;
import com.martnrico.berserker.ui.home.HomeView;

import java.util.List;

/**
 * Created by Martín Rico Martínez on 28/11/2018.
 */
public class EntryAdapter extends RecyclerView.Adapter<EntryViewHolder> {

    private List<EntryModel> mEntryModelList;
    private EntryItemListener mEntryListener;

    public EntryAdapter(List<EntryModel> entryModelList, EntryItemListener entryListener) {
        mEntryModelList = entryModelList;
        mEntryListener = entryListener;
    }

    @NonNull
    @Override
    public EntryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int position) {
        EntryListItem itemListView = new EntryListItem(parent.getContext());
        return new EntryViewHolder(itemListView, mEntryListener);
    }

    @Override
    public void onBindViewHolder(@NonNull EntryViewHolder entryViewHolder, int position) {
        entryViewHolder.onBind(mEntryModelList.get(position), position);
    }

    @Override
    public int getItemCount() {
        return mEntryModelList == null ? 0 : mEntryModelList.size();
    }

    @Override
    public long getItemId(int position) {
        return mEntryModelList.get(position).getId();
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }

    public void setEntryModelList(List<EntryModel> entryModelList) { // TODO CHECK THAT
        if (!mEntryModelList.equals(entryModelList)) {
            mEntryModelList.addAll(entryModelList);
            notifyDataSetChanged();
        }
    }

    public void setEntryModel(EntryModel entryModel) {
        mEntryModelList.add(entryModel);
        notifyDataSetChanged();
    }

    public void removeAll() {
        mEntryModelList.clear();
        notifyDataSetChanged();
    }

    public EntryModel getItemByPosition(int position) {
        return mEntryModelList.get(position);
    }
}
