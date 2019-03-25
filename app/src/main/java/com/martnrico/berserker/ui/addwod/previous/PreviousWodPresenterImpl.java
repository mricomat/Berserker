package com.martnrico.berserker.ui.addwod.previous;

import com.martnrico.berserker.data.DataManager;
import com.martnrico.berserker.data.network.model.Entry.EntryModel;
import com.martnrico.berserker.data.network.model.Entry.PagedModel;
import com.martnrico.berserker.ui.addwod.AddWodActivity;
import com.martnrico.berserker.ui.base.BasePresenterImpl;
import com.martnrico.berserker.utils.DisposableManager;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Martín Rico Martínez on 19/03/2019.
 */
public class PreviousWodPresenterImpl<V extends PreviousWodView> extends BasePresenterImpl<V> implements PreviousWodPresenter<V> {

    private String mPreviousPlace;
    private List<EntryModel> mEntryList = new ArrayList<>();

    @Inject
    public PreviousWodPresenterImpl(String previousPlace, DataManager dataManager, DisposableManager disposableManager) {
        super(dataManager, disposableManager);
        mPreviousPlace = previousPlace;
    }

    @Override
    public void onAttach(V view) {
        super.onAttach(view);
        if (mEntryList.isEmpty()) {
            getWodList();
        } else {
            getMvpView().showEntryWodsList(mEntryList);
        }
    }

    private void getWodList() {
        switch (mPreviousPlace) {
            case AddWodActivity.BOX_WODS:
                getBoxWodList();
                break;
            case AddWodActivity.OLD_WODS:
                getOldWodList();
                break;
            case AddWodActivity.FAV_WODS:
                getFavWodList();
                break;
        }
    }

    @Override
    public void getBoxWodList() {
        getMvpView().showLoadingList();
        getData();
    }

    @Override
    public void getOldWodList() {
        getMvpView().showLoadingList();
        getData();
    }

    @Override
    public void getFavWodList() {
        getMvpView().showLoadingList();
        getData();
    }

    // TODO DELETE, THIS IS NOT THE CORRECT SERVICE
    private void getData() {
        getDisposableManager().add(getDataManager().getPagedEntries(0, 20)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<PagedModel<EntryModel>>() {
                    @Override
                    public void accept(PagedModel<EntryModel> entryPagedModel) throws Exception {
                        mEntryList.addAll(entryPagedModel.getContent());
                        getMvpView().showEntryWodsList(mEntryList);
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
}
