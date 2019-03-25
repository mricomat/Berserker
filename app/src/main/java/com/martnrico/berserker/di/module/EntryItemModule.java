package com.martnrico.berserker.di.module;

import com.martnrico.berserker.ui.uicomponents.scaleditem.ScaledAdapter;

import java.util.ArrayList;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Martín Rico Martínez on 18/12/2018.
 */
@Module
public class EntryItemModule {

    @Provides
    ScaledAdapter provideListAdapter() {
        return new ScaledAdapter(new ArrayList<String>());
    }
}
