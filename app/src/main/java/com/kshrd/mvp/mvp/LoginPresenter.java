package com.kshrd.mvp.mvp;

import com.kshrd.mvp.base.BasePresenter;
import com.kshrd.mvp.listener.Callback;

/**
 * Created by pirang on 7/12/17.
 */

public class LoginPresenter extends BasePresenter<LoginContract.View> implements LoginContract.Presenter {

    private LoginContract.Interactor interactor;

    public LoginPresenter() {
        this.interactor = new LoginInteractor();
    }

    @Override
    public void login(String userName, String password) {
        getMvpView().showLoading();
        interactor.login(userName, password, new Callback() {
            @Override
            public void onSuccess() {
                getMvpView().hideLoading();
                getMvpView().onLoginSuccess();
            }

            @Override
            public void onFailed() {
                getMvpView().hideLoading();
                getMvpView().onLoginFailed();
            }
        });
    }

}
