package com.martnrico.berserker.ui.home;

import com.martnrico.berserker.data.network.model.Entry.EntryModel;
import com.martnrico.berserker.data.network.model.HomeDataModel;
import com.martnrico.berserker.data.network.model.UserModel;
import com.martnrico.berserker.ui.base.BaseView;

import java.util.List;

/**
 * Created by Martín Rico Martínez on 21/11/2018.
 */
public interface HomeView extends BaseView {

    void showEntryList(List<EntryModel> entryModelList);

    void fillView(HomeDataModel homeData);

    void changeLikeState(boolean like, int position);

    void navigateAddWodActivity(UserModel userModel);

    void showLoadingList();

    void hideLoadingList();

    void showError();

    void hideError();

}
