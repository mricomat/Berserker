package com.martnrico.berserker.ui.add.complete;

import com.martnrico.berserker.data.network.model.Entry.WodModel;
import com.martnrico.berserker.ui.base.BaseView;

import java.util.List;

/**
 * Created by Martín Rico Martínez on 21/04/2019.
 */
public interface NewWodCompleteView extends BaseView {

    void showWodList(List<WodModel> wodList);
}
