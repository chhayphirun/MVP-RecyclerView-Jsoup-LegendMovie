package com.kshrd.mvp.base;

/**
 * Created by pirang on 7/13/17.
 */

public interface BaseMvpPresenter<V extends BaseMvpView> {

    void onAttach(V mvpView);

    void onDetach();

}
