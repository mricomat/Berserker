package com.martnrico.berserker.ui.uicomponents.entryitem;

/**
 * Created by Martín Rico Martínez on 19/03/2019.
 */
public interface EntryItemListener {

    void onClickLikeButton(boolean like, int position);

    void onClickBoardButton();

    void onClickCommentButton();

    void onClickEntry(int position);
}
