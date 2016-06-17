package github.vatsal.popularmoviesapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import github.vatsal.popularmoviesapp.Adapters.recyclerAdapter.MoviesItemRecyclerAdapter;
import github.vatsal.popularmoviesapp.retrofit.api.ApiClient;
import github.vatsal.popularmoviesapp.retrofit.api.MoviesResponseModel;
import github.vatsal.popularmoviesapp.retrofit.api.MoviesResponseModelItem;
import github.vatsal.popularmoviesapp.retrofit.api.MoviesRetrofitCallback;
import retrofit2.Call;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    public final ApiClient objApi = ApiClient.getInstance();

    @Bind(R.id.recyclerViewMoviList)
    RecyclerView recyclerViewMoviList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        init();
    }

    public void init() {
        callForPopularMovies();
    }

    public void callForPopularMovies() {
        try {
            Call objCall = null;

            objCall = objApi.getApi(this).getPopularMovies();

            if (objCall != null) {
                objCall.enqueue(new MoviesRetrofitCallback<MoviesResponseModel>(this) {

                    @Override
                    public void onFailure(Call call, Throwable t) {

                        super.onFailure(call, t);
                    }

                    @Override
                    protected void onResponseMoviesResponse(Call call, Response response) {

                    }

                    @Override
                    protected void onResponseMoviesObject(Call call, MoviesResponseModel response) {

                        List<MoviesResponseModelItem> list = response.getResults();
                        populateMoviesAdapter(response);
                    }

                    @Override
                    protected void common() {

                    }
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void populateMoviesAdapter(MoviesResponseModel response) {

        GridLayoutManager gridLayoutManager;
        MoviesItemRecyclerAdapter notiRecyclerAdapter;

        recyclerViewMoviList.setHasFixedSize(true);

        gridLayoutManager = new GridLayoutManager(this, 2);
        recyclerViewMoviList.setLayoutManager(gridLayoutManager);

        notiRecyclerAdapter = new MoviesItemRecyclerAdapter(this, this, response.getResults());
        recyclerViewMoviList.setAdapter(notiRecyclerAdapter);
    }


}
