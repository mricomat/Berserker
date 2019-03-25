package com.martnrico.berserker.ui.base;

import retrofit2.HttpException;

/**
 * Created by Martín Rico Martínez on 19/11/2018.
 */
public interface BasePresenter<V> {

    void onAttach(V view);

    void onDetach();

    void handleApiError(Throwable error);

    void setUserAsLoggedOut();

}