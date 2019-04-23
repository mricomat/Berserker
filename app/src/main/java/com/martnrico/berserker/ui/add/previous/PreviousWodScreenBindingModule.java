package com.martnrico.berserker.ui.add.previous;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Martín Rico Martínez on 19/03/2019.
 */
@Module
public abstract class PreviousWodScreenBindingModule {

    @Provides
    static PreviousWodPresenter<PreviousWodView> bindPreviousWodPresenter(
            PreviousWodPresenterImpl<PreviousWodView> presenter) {
        return presenter;
    }

}
