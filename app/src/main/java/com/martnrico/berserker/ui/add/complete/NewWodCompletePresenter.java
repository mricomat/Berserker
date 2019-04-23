package com.martnrico.berserker.ui.add.complete;

import android.os.Bundle;

import com.martnrico.berserker.ui.base.BasePresenter;

/**
 * Created by Martín Rico Martínez on 21/04/2019.
 */
public interface NewWodCompletePresenter<V extends NewWodCompleteView> extends BasePresenter<V> {

    void updateArguments(Bundle bundle);
}
