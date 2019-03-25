package com.martnrico.berserker.ui.uicomponents.woditem;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.martnrico.berserker.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Martín Rico Martínez on 28/11/2018.
 */
public class WodItem extends RelativeLayout {

    @BindView(R.id.background_item)
    ImageView mBackGround;

    @BindView(R.id.title_wod)
    TextView mTitleWod;

    @BindView(R.id.recyclerView_wod)
    RecyclerView mRecyclerView;

    private WodItemAdapter mAdapter;
    private List<String> mExerciseList = new ArrayList<>();

    public WodItem(Context context) {
        super(context);
        init(context);
    }

    public WodItem(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public WodItem(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    public WodItem(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init(context);
    }

    private void init(Context context) {
        inflate(context, R.layout.wod_item, this);
        ButterKnife.bind(this);
        mAdapter = new WodItemAdapter(mExerciseList);
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.setLayoutManager(new GridLayoutManager(getContext(), 2));
    }

    public void setBackground(int resId) {
        mBackGround.setImageResource(resId);
    }

    public void setTitleWod(String title) {
        mTitleWod.setText(title);
    }

    public void setExerciseList(List<String> exerciseList) {
        this.mExerciseList = exerciseList;
        mAdapter.clearList();
        mAdapter.addItems(mExerciseList);
    }
}
