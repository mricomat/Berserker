package com.martnrico.berserker.ui.add.previous;

import com.martnrico.berserker.data.network.model.Entry.EntryModel;
import com.martnrico.berserker.ui.base.BaseView;

import java.util.List;

/**
 * Created by Martín Rico Martínez on 19/03/2019.
 */
public interface PreviousWodView extends BaseView {

    void showEntryWodsList(List<EntryModel> entryWodList);

    void showLoadingList();

    void hideLoadingList();

}
