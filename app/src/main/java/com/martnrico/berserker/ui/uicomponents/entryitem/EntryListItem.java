package com.martnrico.berserker.ui.uicomponents.entryitem;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.martnrico.berserker.R;
import com.martnrico.berserker.ui.uicomponents.scaleditem.ScaledAdapter;
import com.martnrico.berserker.ui.uicomponents.woditem.WodItem;
import com.mikhaellopez.circularimageview.CircularImageView;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Martín Rico Martínez on 28/11/2018.
 */
public class EntryListItem extends CardView {

    @Inject
    ScaledAdapter mScaledAdapter;

    @BindView(R.id.circular_img)
    CircularImageView mCircularImg;

    @BindView(R.id.name_text)
    TextView mNameText;

    @BindView(R.id.date_text)
    TextView mDateText;

    @BindView(R.id.place_name)
    TextView mPlaceName;

    @BindView(R.id.wod_item_container)
    WodItem mWodItem;

    @BindView(R.id.like_button)
    ImageView mLikeButton;

    @BindView(R.id.comment_button)
    ImageView mCommentButton;

    @BindView(R.id.board_button)
    ImageView mBoardButton;

    @BindView(R.id.result_type_text)
    TextView mResultTypeText;

    @BindView(R.id.result_wod_text)
    TextView mResultWodText;

    @BindView(R.id.scaled_recyclerView)
    RecyclerView mRecyclerView;

    @BindView(R.id.entry_item_list_container)
    RelativeLayout mEntryContainer;

    public EntryListItem(@NonNull Context context) {
        this(context,null);
    }

    public EntryListItem(@NonNull Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public EntryListItem(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    private void init(Context context) {
        inflate(context, R.layout.entry_item_list, this);
        ButterKnife.bind(this);

        List<String> exerciseList = new ArrayList<>();
        mScaledAdapter = new ScaledAdapter(exerciseList);
        mRecyclerView.setAdapter(mScaledAdapter);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(context));
    }

    public void setCircularImg(String circularImgUrl) {
        // TODO URL
    }

    public void setNameText(String nameText) {
        mNameText.setText(nameText);
    }

    public void setDateText(String dateText) {
        mDateText.setText(dateText);
    }

    public void setPlaceName(String placeName) {
        mPlaceName.setText(placeName);
    }

    public void setBackgroundWod(int resId) {
        mWodItem.setBackground(resId);
    }

    public void setTitleWod(String title) {
        mWodItem.setTitleWod(title);
    }

    public void setExerciseList(List<String> exerciseList) {
        mWodItem.setExerciseList(exerciseList);
    }

    public void setResultWod(String resultWod) {
        mResultWodText.setText(resultWod);
    }

    public void setLikeButtonListener(OnClickListener onClickListener) {
        mLikeButton.setOnClickListener(onClickListener);
    }

    public void setCommentButtonListener(OnClickListener onClickListener) {
        mCommentButton.setOnClickListener(onClickListener);
    }

    public void setBoardButtonListener(OnClickListener onClickListener) {
        mBoardButton.setOnClickListener(onClickListener);
    }

    public void setEntryContainerListener(OnClickListener onClickListener) {
        mEntryContainer.setOnClickListener(onClickListener);
    }

    public void setLikeButtonState(boolean isLike) {
       if (isLike) {
           mLikeButton.setColorFilter(getContext().getColor(R.color.red_theme));
           //mLikeButton.setImageResource(R.drawable.icon_like_grey); // TODO set Red icon
       } else {
           mLikeButton.setColorFilter(getContext().getColor(R.color.grey_icon_default));
       }
    }

    public void setResultType(boolean isScaled) {
        if (!isScaled) {
            mResultTypeText.setText(R.string.type_rx);
            mResultTypeText.setTextColor(ContextCompat.getColor(getContext(), R.color.redFire));
        } else {
            mResultTypeText.setText(R.string.type_scaled);
            mResultTypeText.setTextColor(ContextCompat.getColor(getContext(), R.color.scaled_wod));
        }
    }

    public void setScaledCommentsList(List<String> mScaledExercise) {
        mScaledAdapter.addItems(mScaledExercise);
    }

    public ImageView getLikeButton() {
        return mLikeButton;
    }

    public ImageView getCommentButton() {
        return mCommentButton;
    }

    public ImageView getBoardButton() {
        return mBoardButton;
    }
}
