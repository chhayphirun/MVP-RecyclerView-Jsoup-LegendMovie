package com.kshrd.mvp.ui.movie.mvp;

import android.util.Log;

import com.kshrd.mvp.base.BasePresenter;
import com.kshrd.mvp.entity.Movie;
import com.kshrd.mvp.listener.CallbackWithList;

import java.util.List;

/**
 * Created by pirang on 7/14/17.
 */

public class MoviePresenter extends BasePresenter<MovieContract.View> implements MovieContract.Presenter {

    private MovieContract.Interactor interactor;

    public MoviePresenter() {
        this.interactor = new MovieInteractor();
    }

    @Override
    public void loadMovie() {
        getMvpView().showLoading();
        interactor.loadMovie(new CallbackWithList<Movie>() {
            @Override
            public void onSuccess(List<Movie> list) {
                getMvpView().updateListView(list);
                onComplete();
            }

            @Override
            public void onFailed() {
                onComplete();
            }

            @Override
            public void onError() {
                onComplete();
                Log.e("oooo", "Error");
            }

            @Override
            public void onComplete() {
                getMvpView().hideLoading();
            }
        });
    }
}
