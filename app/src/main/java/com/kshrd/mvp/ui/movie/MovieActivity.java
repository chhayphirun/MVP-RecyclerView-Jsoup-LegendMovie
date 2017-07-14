package com.kshrd.mvp.ui.movie;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.ButtonBarLayout;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.kshrd.mvp.R;
import com.kshrd.mvp.base.BaseActivity;
import com.kshrd.mvp.entity.Movie;
import com.kshrd.mvp.ui.movie.mvp.MovieContract;
import com.kshrd.mvp.ui.movie.mvp.MoviePresenter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MovieActivity extends BaseActivity implements MovieContract.View {

    private MovieContract.Presenter presenter;

    @BindView(R.id.listView)
    ListView listView;

    private ArrayAdapter<Movie> adapter;
    private List<Movie> movieList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie);
        setUnbinder(ButterKnife.bind(this));

        setupListView();

        presenter = new MoviePresenter();
        presenter.onAttach(this);
        presenter.loadMovie();

    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    private void setupListView() {
        movieList = new ArrayList<>();
        adapter = new ArrayAdapter<>(
                this, android.R.layout.simple_list_item_1, movieList
        );
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(MovieActivity.this, movieList.get(i).getTitle(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void updateListView(List<Movie> movieList) {
        this.movieList.addAll(movieList);
        adapter.notifyDataSetChanged();
    }
}
