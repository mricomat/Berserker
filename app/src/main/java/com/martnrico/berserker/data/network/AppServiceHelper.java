package com.martnrico.berserker.data.network;

import com.martnrico.berserker.data.network.form.LoginForm;
import com.martnrico.berserker.data.network.model.Entry.EntryModel;
import com.martnrico.berserker.data.network.model.LoginModel;
import com.martnrico.berserker.data.network.model.Entry.PagedModel;
import com.martnrico.berserker.data.network.model.RegisterModel;
import com.martnrico.berserker.data.network.model.UserModel;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Scheduler;
import io.reactivex.Single;

/**
 * Created by Martín Rico Martínez on 21/11/2018.
 */
@Singleton
public class AppServiceHelper implements ServiceHelper {

    private final ServiceHelper mServiceHelper;
    private final Scheduler mScheduler;

    @Inject
    AppServiceHelper(ServiceHelper serviceHelper, Scheduler scheduler) {
        this.mServiceHelper = serviceHelper;
        this.mScheduler = scheduler;
    }

    @Override
    public Single<LoginModel> loginAuthentication(LoginForm loginForm) {
        return mServiceHelper.loginAuthentication(loginForm).subscribeOn(mScheduler);
    }

    @Override
    public Single<RegisterModel> registerNewUser(UserModel userModel) {
        return mServiceHelper.registerNewUser(userModel).subscribeOn(mScheduler);
    }

    @Override
    public Single<PagedModel<EntryModel>> getPagedEntries(Integer page, Integer size) {
        return mServiceHelper.getPagedEntries(page, size);
    }
}
