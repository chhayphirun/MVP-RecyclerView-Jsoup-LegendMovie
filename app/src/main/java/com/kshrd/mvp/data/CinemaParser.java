package com.kshrd.mvp.data;

import android.os.AsyncTask;
import android.util.Log;

import com.kshrd.mvp.entity.Movie;
import com.kshrd.mvp.listener.CallbackWithList;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by pirang on 7/10/17.
 */

public class CinemaParser extends AsyncTask<Void, Void, List<Movie>> {

    private List<Movie> movieList;
    private CallbackWithList<Movie> callback;

    public CinemaParser(CallbackWithList<Movie> callback) {
        movieList = new ArrayList<>();
        this.callback = callback;
    }

    @Override
    protected List<Movie> doInBackground(Void... voids) {
        String baseUrl = "https://www.legend.com.kh";
        String url = baseUrl + "/Browsing/Movies/ComingSoon";
        Document document = null;
        try {
            document = Jsoup.connect(url).get();
            Elements movies = document.select("article#movies-list div.list-item.movie");
            for (Element movie : movies) {
                String posterUrl = movie.select("div.image-outer img").first().attr("src");
                posterUrl=posterUrl.substring(posterUrl.indexOf('w'));
                String title = movie.select("div.item-details h3.item-title").first().text();
                String link = baseUrl + movie.select("div.image-outer a").first().attr("href");
                String linktrailer = movie.select("div.movie-actions div.alt-action a.play").attr("href");
                String date = movie.select("div.item-details div.item-details-inner p.movie-opening-date ").first().text();

                Log.e("ooooo",posterUrl.substring(posterUrl.indexOf('w')));
                Log.e("ooooodate",date);
                Movie item;
                if(linktrailer!=null){
                    item = new Movie(title, posterUrl.substring(posterUrl.indexOf('w')), link,linktrailer,date);

                }else {
                    item = new Movie(title, posterUrl.substring(posterUrl.indexOf('w')), link,"",date);
                }
                movieList.add(item);
            }
        } catch (IOException e) {
            e.printStackTrace();
            callback.onError();
        }
        return movieList;

    }

    @Override
    protected void onPostExecute(List<Movie> movieList) {
        callback.onSuccess(movieList);
    }
}
