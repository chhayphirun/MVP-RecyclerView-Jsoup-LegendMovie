package com.kshrd.mvp.mvp;

import com.kshrd.mvp.listener.Callback;

/**
 * Created by pirang on 7/12/17.
 */

public class LoginPresenter implements LoginContract.Presenter {

    private LoginContract.View view;
    private LoginContract.Interactor interactor;

    public LoginPresenter(LoginContract.View view) {
        this.view = view;
        this.interactor = new LoginInteractor();
    }

    @Override
    public void login(String userName, String password) {
        view.showLoading();
        interactor.login(userName, password, new Callback() {
            @Override
            public void onSuccess() {
                view.hideLoading();
                view.onLoginSuccess();
            }

            @Override
            public void onFailed() {
                view.hideLoading();
                view.onLoginFailed();
            }
        });
    }

}
