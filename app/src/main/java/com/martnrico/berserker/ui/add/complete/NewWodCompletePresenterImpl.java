package com.martnrico.berserker.ui.add.complete;

import android.os.Bundle;

import com.martnrico.berserker.data.DataManager;
import com.martnrico.berserker.data.network.model.Entry.WodModel;
import com.martnrico.berserker.ui.base.BasePresenterImpl;
import com.martnrico.berserker.utils.DisposableManager;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

/**
 * Created by Martín Rico Martínez on 21/04/2019.
 */
public class NewWodCompletePresenterImpl<V extends NewWodCompleteView> extends BasePresenterImpl<V> implements NewWodCompletePresenter<V> {

    private List<WodModel> mWodList = new ArrayList<>();

    @Inject
    public NewWodCompletePresenterImpl(DataManager dataManager, DisposableManager disposableManager) {
        super(dataManager, disposableManager);
    }

    @Override
    public void updateArguments(Bundle bundle) {
        if (bundle != null) {
            WodModel wodModel = bundle.getParcelable(NewWodCompleteFragment.COMPLETE_WOD_DATA_KEY);
            if (!bundle.getBoolean(NewWodCompleteFragment.COMPLETE_WOD_BOOl_KEY)) {
               mWodList.clear();
            }
            mWodList.add(wodModel);
            getMvpView().showWodList(mWodList);
        }
    }
}
