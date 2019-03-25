package com.martnrico.berserker.ui.login;

import com.martnrico.berserker.R;
import com.martnrico.berserker.data.DataManager;
import com.martnrico.berserker.data.network.form.LoginForm;
import com.martnrico.berserker.data.network.model.Entry.EntryModel;
import com.martnrico.berserker.data.network.model.Entry.PagedModel;
import com.martnrico.berserker.data.network.model.HomeDataModel;
import com.martnrico.berserker.data.network.model.LoginModel;
import com.martnrico.berserker.data.network.model.UserModel;
import com.martnrico.berserker.ui.base.BasePresenterImpl;
import com.martnrico.berserker.utils.CommonUtils;
import com.martnrico.berserker.utils.DisposableManager;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import retrofit2.HttpException;

/**
 * Created by Martín Rico Martínez on 20/11/2018.
 */

public class LoginPresenterImpl<V extends LoginView> extends BasePresenterImpl<V> implements LoginPresenter<V> {

    private boolean isNewRun = true;

    @Inject
    public LoginPresenterImpl(DataManager dataManager, DisposableManager disposableManager) {
        super(dataManager, disposableManager);
    }

    @Override
    public void onAttach(V view) {
        super.onAttach(view);
        if (isNewRun) {
            getMvpView().showFadeIn();
            isNewRun= false;
        }
    }

    @Override
    public void onSignInClick(String email, String password) {
        //validate email and password
        if (email == null || email.isEmpty()) {
            getMvpView().showEmailInputError(R.string.empty_email);
            return;
        }
        if (!CommonUtils.isEmailValid(email)) {
            getMvpView().showEmailInputError(R.string.invalid_email);
            return;
        }
        if (password == null || password.isEmpty()) {
            getMvpView().showPasswordInputError(R.string.empty_password);
            return;
        }

        getMvpView().showLoading();

        loginAuthentication(email, password);

        // TODO ErrorHandler


    }

    private void loginAuthentication(String email, String password) {
        getDisposableManager().add(getDataManager().loginAuthentication(new LoginForm(email, password))
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<LoginModel>() {
                    @Override
                    public void accept(LoginModel response) throws Exception {
                        getDataManager().updateUserInfo(
                                response.getAccessToken(),
                                response.getUserId(),
                                DataManager.LoggedInMode.LOGGED_IN_MODE_SERVER,
                                response.getUserName(),
                                response.getUserEmail(),
                                response.getProfilePicUrl());

                        UserModel userModel = new UserModel();
                        userModel.setProfilePicUrl(response.getProfilePicUrl());
                        userModel.setUserEmail(response.getUserEmail());
                        userModel.setUserId(response.getUserId());
                        userModel.setUserName(response.getUserName());
                        userModel.setRank("");
                        userModel.setRate(0);

                        getMvpView().hideLoading();

                        entriesCallService(userModel);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        if (!isViewAttached()) {
                            return;
                        }

                        getMvpView().hideLoading();

                        if (throwable instanceof HttpException && ((HttpException) throwable).code() == 401) {
                            getMvpView().showEmailInputError(R.string.email_password_wrong);
                        } else {
                            handleApiError(throwable);
                        }

                    }
                }));
    }

    private void entriesCallService(final UserModel userModel) {
        getDisposableManager().add(getDataManager().getPagedEntries(0, 20)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<PagedModel<EntryModel>>() {
                    @Override
                    public void accept(PagedModel<EntryModel> entryPagedModel) throws Exception {
                        HomeDataModel homeDataModel = new HomeDataModel(userModel, entryPagedModel.getContent());
                        getMvpView().hideLoading();
                        getMvpView().navigateToHomeActivity(homeDataModel);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        getMvpView().hideLoading();
                    }
                }));
    }

    @Override
    public void onForgotPassClick() {
        // TODO Service to send an Email to recover Password
        getMvpView().showForgotPassDialog();
    }
}
