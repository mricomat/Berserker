package com.martnrico.berserker.di.module;

import android.content.Context;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Martín Rico Martínez on 13/12/2018.
 */
@Module
public class ContextModule {

    private Context mContext;

    public ContextModule(Context context) {
        this.mContext = context;
    }

    @Provides
    Context providesContext() {
        return mContext;
    }
}
