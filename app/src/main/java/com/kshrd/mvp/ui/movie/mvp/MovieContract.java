package com.kshrd.mvp.ui.movie.mvp;

import com.kshrd.mvp.base.BaseMvpPresenter;
import com.kshrd.mvp.base.BaseMvpView;
import com.kshrd.mvp.entity.Movie;
import com.kshrd.mvp.listener.CallbackWithList;

import java.util.List;

/**
 * Created by pirang on 7/14/17.
 */

public interface MovieContract {

    interface View extends BaseMvpView {
        void updateListView(List<Movie> movieList);
    }

    interface Presenter extends BaseMvpPresenter<MovieContract.View> {
        void loadMovie();
    }

    interface Interactor {
        void loadMovie(CallbackWithList<Movie> callback);
    }

}
