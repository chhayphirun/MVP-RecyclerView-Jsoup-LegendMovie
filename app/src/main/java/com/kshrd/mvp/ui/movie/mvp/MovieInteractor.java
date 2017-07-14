package com.kshrd.mvp.ui.movie.mvp;

import com.kshrd.mvp.data.CinemaParser;
import com.kshrd.mvp.entity.Movie;
import com.kshrd.mvp.listener.CallbackWithList;

/**
 * Created by pirang on 7/14/17.
 */

public class MovieInteractor implements MovieContract.Interactor {

    @Override
    public void loadMovie(CallbackWithList<Movie> callback) {
        new CinemaParser(callback).execute();
    }
}
