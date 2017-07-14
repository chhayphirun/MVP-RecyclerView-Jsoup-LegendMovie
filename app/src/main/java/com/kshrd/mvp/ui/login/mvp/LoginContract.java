package com.kshrd.mvp.ui.login.mvp;

import com.kshrd.mvp.base.BaseMvpPresenter;
import com.kshrd.mvp.base.BaseMvpView;
import com.kshrd.mvp.listener.Callback;

/**
 * Created by pirang on 7/12/17.
 */

public interface LoginContract {

    interface View extends BaseMvpView {
        void onLoginSuccess();
        void onLoginFailed();
    }

    interface Presenter extends BaseMvpPresenter<LoginContract.View> {
        void login(String userName, String password);
    }

    interface Interactor {
        void login(String userName, String password, Callback callback);
    }

}
