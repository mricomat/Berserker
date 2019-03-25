package com.martnrico.berserker.ui.home;

import com.martnrico.berserker.data.DataManager;
import com.martnrico.berserker.data.network.model.Entry.EntryModel;
import com.martnrico.berserker.data.network.model.Entry.PagedModel;
import com.martnrico.berserker.data.network.model.HomeDataModel;
import com.martnrico.berserker.ui.base.BasePresenterImpl;
import com.martnrico.berserker.utils.DisposableManager;
import com.martnrico.berserker.utils.MockData;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Martín Rico Martínez on 21/11/2018.
 */
public class HomePresenterImpl<V extends HomeView> extends BasePresenterImpl<V> implements HomePresenter<V> {

    private HomeDataModel mHomeData;

    @Inject
    public HomePresenterImpl(HomeDataModel homeData, DataManager dataManager, DisposableManager disposableManager) {
        super(dataManager, disposableManager);
        this.mHomeData = homeData;
    }

    @Override
    public void onAttach(V view) {
        super.onAttach(view);
        getMvpView().fillView(mHomeData);
        if (mHomeData.getEntriesList().isEmpty()) {
            getEntryList();
        } else {
            getMvpView().showEntryList(mHomeData.getEntriesList());
        }

    }

    @Override
    public void getEntryList() {
        getMvpView().showLoadingList();

        getDisposableManager().add(getDataManager().getPagedEntries(0, 20)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<PagedModel<EntryModel>>() {
                    @Override
                    public void accept(PagedModel<EntryModel> entryPagedModel) throws Exception {
                        mHomeData.setEntriesList(entryPagedModel.getContent());
                        List<EntryModel> entryMockList = new ArrayList<>(entryPagedModel.getContent());
                        entryMockList.addAll(MockData.getEntryModelList());
                        getMvpView().showEntryList(entryMockList);
                        getMvpView().hideLoadingList();
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        getMvpView().hideLoadingList();
                        handleApiError(throwable);
                    }
                }));
    }

    @Override
    public void updateLike(boolean like, int position) {

        // TODO
        // Call to updatestate
        // if success change the view
        getMvpView().changeLikeState(like, position);
    }

    @Override
    public void boardButtonAction() {

    }

    @Override
    public void navigateToSettings() {
        getDataManager().setUserAsLoggedOut();
        getMvpView().openLoginOnTokenExpire();
    }

    @Override
    public void onNewWodClick() {
        getMvpView().navigateAddWodActivity(mHomeData.getUserModel());
    }
}
