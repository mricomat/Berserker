package com.martnrico.berserker.ui.addwod.previous;

import com.martnrico.berserker.ui.base.BasePresenter;

/**
 * Created by Martín Rico Martínez on 19/03/2019.
 */
public interface PreviousWodPresenter<V extends PreviousWodView> extends BasePresenter<V> {

    void getBoxWodList();

    void getOldWodList();

    void getFavWodList();
}
