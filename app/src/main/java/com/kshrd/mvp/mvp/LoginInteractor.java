package com.kshrd.mvp.mvp;

import com.kshrd.mvp.listener.Callback;

/**
 * Created by pirang on 7/12/17.
 */

public class LoginInteractor implements LoginContract.Interactor {

    @Override
    public void login(String userName, String password, Callback callback) {
        String name = "android";
        String pwd = "android";

        if (userName.equals(name) && password.equals(pwd)) {
            callback.onSuccess();
        } else {
            callback.onFailed();
        }
    }
}
