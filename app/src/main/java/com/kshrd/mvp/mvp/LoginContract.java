package com.kshrd.mvp.mvp;

import com.kshrd.mvp.listener.Callback;

/**
 * Created by pirang on 7/12/17.
 */

public interface LoginContract {

    interface View {
        void showLoading();
        void hideLoading();
        void onLoginSuccess();
        void onLoginFailed();
    }

    interface Presenter {
        void login(String userName, String password);
    }

    interface Interactor {
        void login(String userName, String password, Callback callback);
    }

}
