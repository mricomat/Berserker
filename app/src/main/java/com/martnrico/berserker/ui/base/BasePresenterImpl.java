package com.martnrico.berserker.ui.base;

import com.martnrico.berserker.data.DataManager;
import com.martnrico.berserker.utils.DisposableManager;

/**
 * Created by Martín Rico Martínez on 19/11/2018.
 */
public class BasePresenterImpl<V extends BaseView> implements BasePresenter<V>{

    private final DataManager mDataManager;
    private final DisposableManager mDisposableManager;

    private V mMvpView;

    public BasePresenterImpl(DataManager dataManager, DisposableManager disposableManager) {
        this.mDataManager = dataManager;
        this.mDisposableManager = disposableManager;
    }

    @Override
    public void onAttach(V view) {
        mMvpView = view;
    }

    @Override
    public void onDetach() {
        mDisposableManager.dispose();
        mMvpView = null;
    }

    @Override
    public void handleApiError(Throwable error) {
        getMvpView().openErrorActivity(error);
    }

    @Override
    public void setUserAsLoggedOut() {
        getDataManager().setAccessToken(null);
    }

    public boolean isViewAttached() {
        return mMvpView != null;
    }

    public V getMvpView() {
        return mMvpView;
    }

    public DataManager getDataManager() {
        return mDataManager;
    }

    public DisposableManager getDisposableManager() {
        return mDisposableManager;
    }
}
