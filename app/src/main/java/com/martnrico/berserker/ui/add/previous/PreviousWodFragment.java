package com.martnrico.berserker.ui.addwod.previous;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.martnrico.berserker.R;
import com.martnrico.berserker.data.network.model.Entry.EntryModel;
import com.martnrico.berserker.ui.base.BaseFragment;
import com.martnrico.berserker.ui.uicomponents.entryitem.EntryAdapter;
import com.martnrico.berserker.ui.uicomponents.entryitem.EntryItemListener;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Martín Rico Martínez on 19/03/2019.
 */
public class PreviousWodFragment extends BaseFragment implements PreviousWodView, EntryItemListener {

    public static final String PREVIOUS_WOD_KEY = "previous_wod_key";

    @BindView(R.id.wod_recyclerView)
    RecyclerView mWodRecyclerView;

    @BindView(R.id.container_progressBar)
    RelativeLayout mContainerProgressBar;

    @Inject
    PreviousWodPresenter<PreviousWodView> mPreviousWodPresenter;

    private EntryAdapter mEntryAdapter;

    public static PreviousWodFragment newInstance(String previousPlace) {
        Bundle args = new Bundle();
        args.putString(PREVIOUS_WOD_KEY, previousPlace);
        PreviousWodFragment fragment = new PreviousWodFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.previous_wod_fragment, container, false);
        ButterKnife.bind(this, view);
        mEntryAdapter = new EntryAdapter(new ArrayList<EntryModel>(), null);
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        mPreviousWodPresenter.onAttach(this);
    }

    @Override
    protected void fillViews(View view) {
        mWodRecyclerView.setAdapter(mEntryAdapter);
        mWodRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
    }

    @Override
    public void showEntryWodsList(List<EntryModel> entryWodList) {
        mEntryAdapter.setEntryModelList(entryWodList);
    }

    @Override
    public void showLoadingList() {
        mContainerProgressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideLoadingList() {
        mContainerProgressBar.setVisibility(View.GONE);
    }

    @Override
    public void onClickEntry(int position) {
        // TODO GO create this wod again.
    }

    @Override
    public void onClickLikeButton(boolean like, int position) {
        // We do nothing here
    }

    @Override
    public void onClickBoardButton() {
        // We do nothing here
    }

    @Override
    public void onClickCommentButton() {
        // We do nothing here
    }


}
