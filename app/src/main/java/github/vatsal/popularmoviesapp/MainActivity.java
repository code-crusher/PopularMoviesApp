package github.vatsal.popularmoviesapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import github.vatsal.popularmoviesapp.retrofit.api.ApiClient;
import github.vatsal.popularmoviesapp.retrofit.api.MoviesResponseModel;
import github.vatsal.popularmoviesapp.retrofit.api.MoviesRetrofitCallback;
import retrofit2.Call;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    public final ApiClient objApi = ApiClient.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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
}
