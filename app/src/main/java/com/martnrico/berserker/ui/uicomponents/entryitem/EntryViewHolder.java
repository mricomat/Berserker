package com.martnrico.berserker.ui.uicomponents.entryitem;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.martnrico.berserker.data.network.model.Entry.EntryModel;
import com.martnrico.berserker.utils.StringUtils;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import butterknife.ButterKnife;

/**
 * Created by Martín Rico Martínez on 28/11/2018.
 */
public class EntryViewHolder extends RecyclerView.ViewHolder {

    private EntryListItem mEntryListItem;
    private EntryItemListener mEntryListener;

    public EntryViewHolder(@NonNull View itemView, EntryItemListener entryListener) {
        super(itemView);
        ButterKnife.bind(this, itemView);
        mEntryListItem = (EntryListItem) itemView;
        mEntryListener = entryListener;
    }

    private void clear() {
        mEntryListItem.setNameText(StringUtils.EMPTY_STRING);
        mEntryListItem.setPlaceName(StringUtils.EMPTY_STRING);
        mEntryListItem.setDateText(StringUtils.EMPTY_STRING);
        mEntryListItem.setTitleWod(StringUtils.EMPTY_STRING);
        List<String> mEmptyList = new ArrayList<>();
        mEntryListItem.setExerciseList(mEmptyList);
    }

    public void onBind(final EntryModel entryModel, final int position) {
        clear();

        //mEntryListItem.setCircularImg(entryModel.getHeaderEntryModel().getUrlImage());
        mEntryListItem.setNameText(entryModel.getUserModel().getUserName());
        mEntryListItem.setPlaceName(entryModel.getPlace());
        Date date = new Date(entryModel.getDate());
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd MMMM");
        mEntryListItem.setDateText(dateFormat.format(date));
        mEntryListItem.setTitleWod(entryModel.getWodModel().getTypeWod());
        //mEntryListItem.setBackgroundWod(entryModel.getWodModel().getUriBackground());
        mEntryListItem.setExerciseList(entryModel.getWodModel().getExerciseList());
        mEntryListItem.setResultType(entryModel.isScaled());
        mEntryListItem.setResultWod(entryModel.getResultWod());
        mEntryListItem.setLikeButtonState(entryModel.isLike());

        mEntryListItem.setLikeButtonListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mEntryListener != null) {
                    mEntryListener.onClickLikeButton(!entryModel.isLike(), position);
                }
            }
        });

        mEntryListItem.setBoardButtonListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mEntryListener != null) {
                    mEntryListener.onClickBoardButton();
                }
            }
        });

        mEntryListItem.setCommentButtonListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mEntryListener != null) {
                    mEntryListener.onClickCommentButton();
                }
            }
        });

        mEntryListItem.setEntryContainerListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(mEntryListener != null) {
                    mEntryListener.onClickEntry(position);
                }
            }
        });

        mEntryListItem.setScaledCommentsList(entryModel.getCommentList());
    }
}
